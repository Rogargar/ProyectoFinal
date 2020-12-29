package com.application.fProject.controller;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.application.fProject.dtos.UserDto;
import com.application.fProject.dtos.UserPersistentDto;
import com.application.fProject.exceptions.BadRequestException;
import com.application.fProject.exceptions.ObjectNotFoundException;
import com.application.fProject.services.UserService;

/**
 * Controller for user entity
 * 
 * @author Rocío García
 *
 */
@RestController
@RequestMapping("/users")
public class UserController {

	private final UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	/**
	 * Get all users
	 * 
	 * @return List of users
	 */
	@GetMapping
	public ResponseEntity<List<UserDto>> findAll() {
		return ResponseEntity.ok(userService.findAll());
	}

	/**
	 * Get user by id 
	 * 
	 * @param id the id
	 * @return User found
	 * @throws ObjectNotFoundException If user wasn't found
	 */
	@GetMapping("/{id}")
	public ResponseEntity<UserDto> findById(@PathVariable("id") String id) throws ObjectNotFoundException {
		return ResponseEntity.ok(userService.findById(id));
	}

	/**
	 * Confirm email and password
	 * 
	 * @param user User find
	 * @return number: 1 if email and password are true, -1 if email is false, -2 if
	 *         password is false and email is true
	 */
	@PostMapping("/emailPass")
	@CrossOrigin(origins = "http://localhost:4200")
	public String trueEmailAndPass(@Valid @RequestBody UserPersistentDto user) {
		System.out.println(user);
		return userService.findByEmailAndPass(user);
	}

	/**
	 * Find by email
	 * 
	 * @param email User's email
	 * @return User found
	 */
	@GetMapping("/email/{email}")
	public ResponseEntity<UserDto> findEmail(@PathVariable("email") String email) {
		return ResponseEntity.ok(userService.findByEmail(email));
	}
	
	/**
	 * Creates a new user
	 * 
	 * @param user User to create
	 * @return Persisted user
	 */
	@PostMapping
	public ResponseEntity<UserDto> create(@Valid @RequestBody UserPersistentDto user) throws BadRequestException {
		return ResponseEntity.ok(userService.create(user));
	}

	/**
	 * Update a user
	 * 
	 * @param id   User's id
	 * @param user User data to update
	 * @return Persisted user
	 * @throws BadRequestException     if the email is repeat
	 * @throws ObjectNotFoundException if user wasn't found
	 */
	@PutMapping("/{id}")
	public ResponseEntity<UserDto> update(@PathVariable("id") String id, @Valid @RequestBody UserPersistentDto user)
			throws BadRequestException, ObjectNotFoundException {
		return ResponseEntity.ok(userService.update(id, user));
	}

	/**
	 * Removes user from database
	 * 
	 * @param id User's id
	 * @throws ObjectNotFoundException if user wasn't found
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> remove(@PathVariable("id") String id) throws ObjectNotFoundException {
		userService.remove(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	/**
	 * File new img for user
	 * 
	 * @param file img
	 * @param id the id user
	 * @return Persisted user
	 * @throws ObjectNotFoundException if user wasn't
	 * @throws BadRequestException if router fail
	 */
	@PostMapping("/upload")
	public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file, @RequestParam("id") String id)
			throws ObjectNotFoundException, BadRequestException {
		Map<String, Object> response = new HashMap<>();

		UserDto user = userService.findById(id);

		if (!file.isEmpty()) {
			String nombreFile = UUID.randomUUID().toString() + "_" + file.getOriginalFilename().replace(" ", "");

			Path rutaFile = Paths.get("userImg").resolve(nombreFile).toAbsolutePath();

			try {
				Files.copy(file.getInputStream(), rutaFile);
			} catch (IOException e) {
				response.put("message", "Error al subir la imagen: " + nombreFile);
				response.put("error", e.getMessage().concat(" : ").concat(e.getCause().getMessage()));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}

			String fotoAnterior = user.getImg();

			if (fotoAnterior != null && fotoAnterior.length() > 0) {
				Path rutaAnterio = Paths.get("uploads").resolve(fotoAnterior).toAbsolutePath();
				File archivoAnterior = rutaAnterio.toFile();

				if (archivoAnterior.exists() && archivoAnterior.canRead()) {
					archivoAnterior.delete();
				}
			}

			user.setImg(nombreFile);

			userService.update(id, user);

			response.put("user", user);
		}

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);

	}

	/**
	 * Get img for user
	 * 
	 * @param namePicture name of img
	 * 
	 * @return the img
	 */
	@GetMapping("/uploads/img/{namePicture:.+}")
	public ResponseEntity<Resource> watchPicture(@PathVariable String namePicture) {
		Path rutaFile = Paths.get("userImg").resolve(namePicture).toAbsolutePath();
		Resource resource = null;

		try {

			resource = new UrlResource(rutaFile.toUri());

		} catch (MalformedURLException e) {

			e.printStackTrace();
		}

		if (!resource.exists() && !resource.isReadable()) {
			throw new RuntimeException("Error al cargar la imagen");
		}

		HttpHeaders cabecer = new HttpHeaders();
		cabecer.add(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=\"" + resource.getFilename() + "\"");

		return new ResponseEntity<Resource>(resource, cabecer, HttpStatus.OK);
	}

}
