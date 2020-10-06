package com.application.fProject.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.fProject.dtos.UserDto;
import com.application.fProject.dtos.UserPersistentDto;
import com.application.fProject.exceptions.BadRequestException;
import com.application.fProject.exceptions.ObjectNotFoundException;
import com.application.fProject.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	private final UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping
	public ResponseEntity<List<UserDto>> findAll() {
		return ResponseEntity.ok(userService.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<UserDto> findById(@PathVariable("id") String id) throws ObjectNotFoundException {
		return ResponseEntity.ok(userService.findById(id));
	}

	@PostMapping("/emailPass")
	public String trueEmailAndPass(@Valid @RequestBody UserPersistentDto user) {
		System.out.println(user);
		return userService.findByEmailAndPass(user);
	}

	@GetMapping("/email/{email}")
	public ResponseEntity<UserDto> findEmail(@PathVariable("email") String email) {
		return ResponseEntity.ok(userService.findByEmail(email));
	}

	@PostMapping
	public ResponseEntity<UserDto> create(@Valid @RequestBody UserPersistentDto user) throws BadRequestException {
		return ResponseEntity.ok(userService.create(user));
	}

	@PutMapping("/{id}")
	public ResponseEntity<UserDto> update(@PathVariable("id") String id, @Valid @RequestBody UserPersistentDto user)
			throws BadRequestException, ObjectNotFoundException {
		return ResponseEntity.ok(userService.update(id, user));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> remove(@PathVariable("id") String id) throws ObjectNotFoundException {
		userService.remove(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
