package com.application.fProject.services;

import java.util.List;

import com.application.fProject.dtos.SavedRecipeDto;
import com.application.fProject.dtos.SavedRecipePersistentDto;
import com.application.fProject.exceptions.BadRequestException;
import com.application.fProject.exceptions.ObjectNotFoundException;

public interface SaveRecipeService {

	/**
	 * Get All saveRecipes
	 * 
	 * @return List of saveRecipes
	 */
	List<SavedRecipeDto> findAll();

	/**
	 * Get saveRecipe by id
	 * 
	 * @param id SaveRecipe's id
	 * @return SaveRecipe found
	 * @throws ObjectNotFoundException If saveRecipe wasn't found
	 */
	SavedRecipeDto findById(String id) throws ObjectNotFoundException;

	/**
	 * Get saveRecipe by id User and Id recipe
	 * @param idUser user's id
	 * @param isRecipe recipe's id
	 * @return User found
	 * @throws ObjectNotFoundException If saveRecipe wasn't found
	 */
	SavedRecipeDto findByIdRecipeIdUser(String idUser, String isRecipe) throws ObjectNotFoundException ;

	/**
	 * Create a saveRecipe
	 * 
	 * @param sRecipe the saveRecipe
	 * @return Persisted saveRecipe
	 * @throws BadRequestException if the saveRecipe is repeat
	 */
	SavedRecipeDto create(SavedRecipePersistentDto sRecipe) throws BadRequestException, ObjectNotFoundException;

	/**
	 * Update a saveRecipe
	 * @param id saveRecipe's id
	 * @param sRecipe the saveRecipe
	 * @return Persisted saveRecipe
	 * @throws BadRequestException if the saveRecipe is repeat
	 * @throws ObjectNotFoundException if user and recipe doesn't exist
	 */
	SavedRecipeDto update(String id, SavedRecipePersistentDto sRecipe)
			throws BadRequestException, ObjectNotFoundException;

	/**
	 * Removes saveRecipe
	 * 
	 * @param id saveRecipe's id
	 * @throws ObjectNotFoundException if saveRecipe wasn't found
	 */
	void remove(String id) throws ObjectNotFoundException;

	/**
	 * Get SaveRecipe by id User
	 * 
	 * @param idUser the id user
	 * @return List of SaveRecipe
	 */
	List<SavedRecipeDto> findByUser(String idUser);

}
