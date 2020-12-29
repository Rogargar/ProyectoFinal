package com.application.fProject.services;

import java.text.ParseException;
import java.util.List;

import com.application.fProject.dtos.RecipeDto;
import com.application.fProject.dtos.RecipePersistentDto;
import com.application.fProject.exceptions.BadRequestException;
import com.application.fProject.exceptions.ObjectNotFoundException;

public interface RecipeService {

	/**
	 * Get All recipes
	 * 
	 * @return List of recipes
	 */
	List<RecipeDto> findAll();
	
	/**
	 * Get All recipes publicated
	 * 
	 * @return List of recipes
	 */
	List<RecipeDto> findAllByPublicated();
	
	/**
	 * Get recipe by id
	 * 
	 * @param id Recipe's id
	 * @return Recipe found
	 * @throws ObjectNotFoundException If recipe wasn't found
	 */
	RecipeDto findById(String id) throws ObjectNotFoundException;

	/**
	 * Create a recipe
	 * 
	 * @param user the recipe
	 * @return Persisted recipe
	 * @throws BadRequestException if the recipe is repeat
	 */
	RecipeDto create(RecipePersistentDto recipe) throws BadRequestException, ObjectNotFoundException;

	/**
	 * Update a recipe
	 * 
	 * @param id   Recipe's id
	 * @param user Recipe data to update
	 * @return Persisted recipe
	 * @throws ObjectNotFoundException if recipe wasn't found
	 */
	RecipeDto update(String id, RecipePersistentDto recipe) throws BadRequestException, ObjectNotFoundException;

	/**
	 * Removes recipe from database
	 * 
	 * @param id Recipe's id
	 * @throws ObjectNotFoundException if recipe wasn't found
	 */
	void remove(String id) throws ObjectNotFoundException;

	/**
	 * Get recipe by label
	 * 
	 * @param idLabel the id label
	 * 
	 * @return List of Recipes
	 */
	List<RecipeDto> findByIdLabel(String idLabel);

	/**
	 * Get Last Recipes
	 * 
	 * @return List of recipes
	 */
	List<RecipeDto> findLastRecipes() throws ParseException;
	
	/**
	 * Get recipes by owner
	 * 
	 * @param idUser the id owner
	 * @return List of recipes
	 */
	List<RecipeDto> findByOwner(String idUser);

}
