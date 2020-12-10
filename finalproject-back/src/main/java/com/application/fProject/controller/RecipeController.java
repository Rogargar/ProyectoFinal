package com.application.fProject.controller;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
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

import com.application.fProject.dtos.RecipeDto;
import com.application.fProject.dtos.RecipePersistentDto;
import com.application.fProject.exceptions.BadRequestException;
import com.application.fProject.exceptions.ObjectNotFoundException;
import com.application.fProject.services.RecipeService;

@RestController
@RequestMapping("/recipes")
public class RecipeController {
	private final RecipeService recipeService;

	@Autowired
	public RecipeController(RecipeService recipeService) {
		this.recipeService = recipeService;
	}

	@GetMapping
	public ResponseEntity<List<RecipeDto>> findAll() {
		return ResponseEntity.ok(recipeService.findAll());
	}

	@GetMapping("/publicated")
	public ResponseEntity<List<RecipeDto>> findAllByPublicated() {
		return ResponseEntity.ok(recipeService.findAllByPublicated());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<RecipeDto> findById(@PathVariable("id") String id) throws ObjectNotFoundException {
		return ResponseEntity.ok(recipeService.findById(id));
	}

	@GetMapping("/label/{id}")
	public ResponseEntity<List<RecipeDto>> findByIdLabel(@PathVariable("id") String id) throws ObjectNotFoundException {
		return ResponseEntity.ok(recipeService.findByIdLabel(id));
	}

	@GetMapping("/owner/{id}")
	public ResponseEntity<List<RecipeDto>> findByIdOwner(@PathVariable("id") String id) throws ObjectNotFoundException {
		return ResponseEntity.ok(recipeService.findByOwner(id));
	}

	@PostMapping
	public ResponseEntity<RecipeDto> create(@Valid @RequestBody RecipePersistentDto recipe)
			throws BadRequestException, ObjectNotFoundException {
		return ResponseEntity.ok(recipeService.create(recipe));
	}

	@PutMapping("/{id}")
	public ResponseEntity<RecipeDto> update(@PathVariable("id") String id,
			@Valid @RequestBody RecipePersistentDto recipe) throws BadRequestException, ObjectNotFoundException {
		return ResponseEntity.ok(recipeService.update(id, recipe));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> remove(@PathVariable("id") String id) throws ObjectNotFoundException {
		recipeService.remove(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("/upload")
	public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file, @RequestParam("id") String id)
			throws ObjectNotFoundException, BadRequestException {
		Map<String, Object> response = new HashMap<>();

		RecipeDto recipe = recipeService.findById(id);

		if (!file.isEmpty()) {
			String nombreFile = UUID.randomUUID().toString() + "_" + file.getOriginalFilename().replace(" ", "");

			Path rutaFile = Paths.get("uploads").resolve(nombreFile).toAbsolutePath();

			try {
				Files.copy(file.getInputStream(), rutaFile);
			} catch (IOException e) {
				response.put("message", "Error al subir la imagen: " + nombreFile);
				response.put("error", e.getMessage().concat(" : ").concat(e.getCause().getMessage()));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}

			String fotoAnterior = recipe.getImg();

			if (fotoAnterior != null && fotoAnterior.length() > 0) {
				Path rutaAnterio = Paths.get("uploads").resolve(fotoAnterior).toAbsolutePath();
				File archivoAnterior = rutaAnterio.toFile();

				if (archivoAnterior.exists() && archivoAnterior.canRead()) {
					archivoAnterior.delete();
				}
			}

			recipe.setImg(nombreFile);

			recipeService.update(id, recipe);

			response.put("recipe", recipe);
		}

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);

	}

	@GetMapping("/day")
	public ResponseEntity<List<RecipeDto>> findLastRecipes() throws ParseException {
		return ResponseEntity.ok(recipeService.findLastRecipes());
	}

	@GetMapping("/uploads/img/{namePicture:.+}")
	public ResponseEntity<Resource> watchPicture(@PathVariable String namePicture) {
		Path rutaFile = Paths.get("uploads").resolve(namePicture).toAbsolutePath();
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
