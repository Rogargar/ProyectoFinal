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

	@GetMapping("/{id}")
	public ResponseEntity<RecipeDto> findById(@PathVariable("id") String id) throws ObjectNotFoundException {
		return ResponseEntity.ok(recipeService.findById(id));
	}

	@PostMapping
	public ResponseEntity<RecipeDto> create(@Valid @RequestBody RecipePersistentDto recipe)
			throws BadRequestException, ObjectNotFoundException {
		return ResponseEntity.ok(recipeService.create(recipe));
	}

	@PutMapping("/{id}")
	public ResponseEntity<RecipeDto> update(@PathVariable("id") String id,
			@Valid @RequestBody RecipePersistentDto recipe)
			throws BadRequestException, ObjectNotFoundException {
		return ResponseEntity.ok(recipeService.update(id, recipe));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> remove(@PathVariable("id") String id) throws ObjectNotFoundException {
		recipeService.remove(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
