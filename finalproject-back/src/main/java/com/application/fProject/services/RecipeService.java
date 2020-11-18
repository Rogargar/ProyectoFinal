package com.application.fProject.services;

import java.text.ParseException;
import java.util.List;

import com.application.fProject.dtos.RecipeDto;
import com.application.fProject.dtos.RecipePersistentDto;
import com.application.fProject.exceptions.BadRequestException;
import com.application.fProject.exceptions.ObjectNotFoundException;

public interface RecipeService {

	List<RecipeDto> findAll();

	RecipeDto findById(String id) throws ObjectNotFoundException;

	RecipeDto create(RecipePersistentDto recipe) throws BadRequestException, ObjectNotFoundException;

	RecipeDto update(String id, RecipePersistentDto recipe) throws BadRequestException, ObjectNotFoundException;

	void remove(String id) throws ObjectNotFoundException;

	List<RecipeDto> findByIdLabel(String idLabel);

	List<RecipeDto> findLastRecipes() throws ParseException;
	
	List<RecipeDto> findByOwner(String idUser);

}
