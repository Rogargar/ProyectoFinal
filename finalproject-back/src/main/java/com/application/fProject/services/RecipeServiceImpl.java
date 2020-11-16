package com.application.fProject.services;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
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
import com.application.fProject.models.Label;
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
		if (recipe.getState().compareToIgnoreCase("publicada") == 0) {
			recipe.setPublicationDate((java.sql.Date) getDateNow());
		}

		return modelMapper.map(recipeRepository.save(modelMapper.map(recipe, Recipe.class)), RecipeDto.class);
	}

	private Date getDateNow() {
		return new Date();
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
		if (recipe.getState().compareToIgnoreCase("publicada") == 0) {
			recipe.setPublicationDate((java.sql.Date) getDateNow());
		}
		modelMapper.map(recipe, existingRecipe);

		return modelMapper.map(recipeRepository.save(modelMapper.map(existingRecipe, Recipe.class)), RecipeDto.class);
	}

	@Override
	@Transactional
	@CacheEvict(cacheNames = CACHE, allEntries = true)
	public void remove(String id) throws ObjectNotFoundException {

		RecipeDto recipe = findById(id);

		String fotoAnterior = recipe.getImg();

		if (fotoAnterior != null && fotoAnterior.length() > 0) {
			Path rutaAnterio = Paths.get("uploads").resolve(fotoAnterior).toAbsolutePath();
			File archivoAnterior = rutaAnterio.toFile();

			if (archivoAnterior.exists() && archivoAnterior.canRead()) {
				archivoAnterior.delete();
			}
		}
		recipeRepository.deleteById(findById(id).getId());
	}

	@Override
	@Transactional
	@Cacheable(CACHE)
	public List<RecipeDto> findByIdLabel(String idLabel) {
		List<Recipe> recipes = recipeRepository.findAll();
		List<RecipeDto> newRecipes = new ArrayList<RecipeDto>();

		for (Recipe recipe : recipes) {
			List<Label> labels = recipe.getLabel();
			for (Label label : labels) {
				if (label.getId().compareToIgnoreCase(idLabel) == 0) {
					newRecipes.add(modelMapper.map(recipe, RecipeDto.class));
				}
			}
		}
		return newRecipes;
	}

	@Override
	@Transactional
	@Cacheable(CACHE)
	public List<RecipeDto> findLastRecipes() {
		/*
		 * List<RecipeDto> recipes = recipeRepository.findAll().stream() .map(recipe ->
		 * modelMapper.map(recipe, RecipeDto.class)).collect(Collectors.toList());
		 * SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); Date dateNow
		 * =sdf.parse(getDateNow().toString());
		 * 
		 * for (RecipeDto recipe : recipes) { Date
		 * dateRecipe=sdf.parse(recipe.getPublicationDate().toString()); }
		 */

		return null;
	}

	@Override
	@Transactional
	@Cacheable(CACHE)
	public List<RecipeDto> findByOwner(String idUser) {
		Optional<User> user = userRepository.findById(idUser);
		return recipeRepository.findByOwner(modelMapper.map(user.get(), User.class)).stream()
				.map(recipe -> modelMapper.map(recipe, RecipeDto.class)).collect(Collectors.toList());
	}

}
