package com.application.fProject.services;

import java.util.List;

import com.application.fProject.dtos.SavedRecipeDto;
import com.application.fProject.dtos.SavedRecipePersistentDto;
import com.application.fProject.exceptions.BadRequestException;
import com.application.fProject.exceptions.ObjectNotFoundException;

public interface SaveRecipeService {

	List<SavedRecipeDto> findAll();

	SavedRecipeDto findById(String id) throws ObjectNotFoundException;

	SavedRecipeDto findByIdRecipeIdUser(String idUser, String isRecipe) throws ObjectNotFoundException ;

	SavedRecipeDto create(SavedRecipePersistentDto sRecipe) throws BadRequestException, ObjectNotFoundException;

	SavedRecipeDto update(String id, SavedRecipePersistentDto sRecipe)
			throws BadRequestException, ObjectNotFoundException;

	void remove(String id) throws ObjectNotFoundException;

	List<SavedRecipeDto> findByUser(String idUser);

}
