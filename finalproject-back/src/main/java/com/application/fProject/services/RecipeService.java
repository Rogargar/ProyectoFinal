package com.application.fProject.services;

import java.util.List;

import com.application.fProject.dtos.RecipesDto;
import com.application.fProject.dtos.RecipesPersistentDto;
import com.application.fProject.exceptions.BadRequestException;
import com.application.fProject.exceptions.ObjectNotFoundException;

public interface RecipeService {

	List<RecipesDto> findAll();

	RecipesDto findById(String id) throws ObjectNotFoundException;

	RecipesDto create(RecipesPersistentDto recipes) throws BadRequestException;

	RecipesDto update(String id, RecipesPersistentDto recipes) throws BadRequestException, ObjectNotFoundException;

	void remove(String id) throws ObjectNotFoundException;

}
