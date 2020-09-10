package com.application.fProject.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.application.fProject.dtos.RecipeDto;
import com.application.fProject.dtos.RecipePersistentDto;
import com.application.fProject.dtos.UserDto;
import com.application.fProject.exceptions.BadRequestException;
import com.application.fProject.exceptions.ObjectNotFoundException;
import com.application.fProject.models.Recipe;
import com.application.fProject.models.User;
import com.application.fProject.repositories.RecipeRepository;
import com.application.fProject.repositories.UserRepository;

@Service
public class RecipeServiceImpl implements RecipeService {

	private static final String CACHE = "recipeData";

	private final RecipeRepository recipeRepository;

	private final UserRepository userRepository;

	private final ModelMapper modelMapper;

	@Autowired
	public RecipeServiceImpl(RecipeRepository recipeRepository, UserRepository userRepository) {
		super();
		this.modelMapper = new ModelMapper();
		this.recipeRepository = recipeRepository;
		this.userRepository = userRepository;
	}

	@Override
	@Transactional
	@Cacheable(CACHE)
	public List<RecipeDto> findAll() {
		return recipeRepository.findAll().stream().map(recipe -> modelMapper.map(recipe, RecipeDto.class))
				.collect(Collectors.toList());
	}

	@Override
	@Transactional
	@Cacheable(CACHE)
	public RecipeDto findById(String id) throws ObjectNotFoundException {
		Optional<Recipe> recipe = recipeRepository.findById(id);

		if (!recipe.isPresent()) {
			throw new ObjectNotFoundException("Recipe not found");
		}

		return modelMapper.map(recipe.get(), RecipeDto.class);
	}

	@Override
	@Transactional
	@CacheEvict(cacheNames = CACHE, allEntries = true)
	public RecipeDto create(RecipePersistentDto recipe) throws BadRequestException, ObjectNotFoundException {
		UserDto userInRecipes = recipe.getOwner();
		Optional<User> user = userRepository.findById(userInRecipes.getId());

		if (!user.isPresent()) {
			throw new ObjectNotFoundException("User not found");
		}

		return modelMapper.map(recipeRepository.save(modelMapper.map(recipe, Recipe.class)), RecipeDto.class);
	}

	@Override
	@Transactional
	@CacheEvict(cacheNames = CACHE, allEntries = true)
	public RecipeDto update(String id, RecipePersistentDto recipe) throws BadRequestException, ObjectNotFoundException {
		RecipeDto existingRecipe = findById(id);

		UserDto userInRecipes = recipe.getOwner();
		Optional<User> user = userRepository.findById(userInRecipes.getId());

		if (!user.isPresent()) {
			throw new ObjectNotFoundException("User not found");
		}

		modelMapper.map(recipe, existingRecipe);

		return modelMapper.map(recipeRepository.save(modelMapper.map(existingRecipe, Recipe.class)), RecipeDto.class);
	}

	@Override
	@Transactional
	@CacheEvict(cacheNames = CACHE, allEntries = true)
	public void remove(String id) throws ObjectNotFoundException {
		recipeRepository.deleteById(findById(id).getId());
	}

}
