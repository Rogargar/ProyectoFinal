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

import com.application.fProject.dtos.SavedRecipeDto;
import com.application.fProject.dtos.SavedRecipePersistentDto;
import com.application.fProject.exceptions.BadRequestException;
import com.application.fProject.exceptions.ObjectNotFoundException;
import com.application.fProject.services.SaveRecipeService;

/**
 * Controller for saveRecipe entity
 * 
 * @author Rocío García
 *
 */
@RestController
@RequestMapping("/savedRecipes")
public class SaveRecipeController {

	private final SaveRecipeService saveRecipe;

	@Autowired
	public SaveRecipeController(SaveRecipeService saveRecipe) {
		this.saveRecipe = saveRecipe;
	}

	/**
	 * Get All saveRecipes
	 * 
	 * @return List of saveRecipes
	 */
	@GetMapping
	public ResponseEntity<List<SavedRecipeDto>> findAll() {
		return ResponseEntity.ok(saveRecipe.findAll());
	}

	/**
	 * Get saveRecipe by id
	 * 
	 * @param id SaveRecipe's id
	 * @return SaveRecipe found
	 * @throws ObjectNotFoundException If saveRecipe wasn't found
	 */
	@GetMapping("/{id}")
	public ResponseEntity<SavedRecipeDto> findById(@PathVariable("id") String id) throws ObjectNotFoundException {
		return ResponseEntity.ok(saveRecipe.findById(id));
	}

	/**
	 * Get SaveRecipe by id User
	 * 
	 * @param id  user's id
	 * @return List of savedRecipes
	 */
	@GetMapping("/user/{id}")
	public ResponseEntity<List<SavedRecipeDto>> findByUser(@PathVariable("id") String id) {
		return ResponseEntity.ok(saveRecipe.findByUser(id));
	}

	/**
	 *  Get saveRecipe by id User and Id recipe
	 * 
	 * @param idUser   user's id
	 * @param isRecipe recipe's id
	 * @return SavedRecipe
	 * @throws ObjectNotFoundException If saveRecipe wasn't found
	 */
	@GetMapping("/user/{idUser}/recipes/{idRecipe}")
	public ResponseEntity<SavedRecipeDto> findByUserAndRecipe(@PathVariable("idUser") String idUser,
			@PathVariable("idRecipe") String idRecipe) throws ObjectNotFoundException {
		return ResponseEntity.ok(saveRecipe.findByIdRecipeIdUser(idUser, idRecipe));
	}

	/***
	 * Create a saveRecipe
	 * 
	 * @param sRecipe the saveRecipe
	 * @return Persisted saveRecipe
	 * @throws BadRequestException if the saveRecipe is repeat
	 */
	@PostMapping
	public ResponseEntity<SavedRecipeDto> create(@Valid @RequestBody SavedRecipePersistentDto sRecipe)
			throws BadRequestException, ObjectNotFoundException {
		System.out.println(sRecipe);
		return ResponseEntity.ok(saveRecipe.create(sRecipe));
	}

	/**
	 * Update a saveRecipe
	 * 
	 * @param id      saveRecipe's id
	 * @param sRecipe the saveRecipe
	 * @return Persisted saveRecipe
	 * @throws BadRequestException     if the saveRecipe is repeat
	 * @throws ObjectNotFoundException if user and recipe doesn't exist
	 */
	@PutMapping("/{id}")
	public ResponseEntity<SavedRecipeDto> update(@PathVariable("id") String id,
			@Valid @RequestBody SavedRecipePersistentDto sRecipe) throws BadRequestException, ObjectNotFoundException {
		return ResponseEntity.ok(saveRecipe.update(id, sRecipe));
	}

	/**
	 * Removes saveRecipe
	 * 
	 * @param id saveRecipe's id
	 * @throws ObjectNotFoundException if saveRecipe wasn't found
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> remove(@PathVariable("id") String id) throws ObjectNotFoundException {
		saveRecipe.remove(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
