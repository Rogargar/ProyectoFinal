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
import com.application.fProject.dtos.SavedRecipeDto;
import com.application.fProject.dtos.SavedRecipePersistentDto;
import com.application.fProject.dtos.UserDto;
import com.application.fProject.exceptions.BadRequestException;
import com.application.fProject.exceptions.ObjectNotFoundException;
import com.application.fProject.models.Recipe;
import com.application.fProject.models.SavedRecipe;
import com.application.fProject.models.User;
import com.application.fProject.repositories.RecipeRepository;
import com.application.fProject.repositories.SaveRecipeRepository;
import com.application.fProject.repositories.UserRepository;

@Service
public class SaveRecipeServiceImpl implements SaveRecipeService {

	private static final String CACHE = "sRecipeData";

	private final SaveRecipeRepository sRecipeRepository;

	private final UserRepository userRepository;

	private final RecipeRepository recipeRepository;

	private final ModelMapper modelMapper;

	@Autowired
	public SaveRecipeServiceImpl(SaveRecipeRepository sRecipeRepository, UserRepository userRepository,
			RecipeRepository recipeRepository) {
		super();
		this.modelMapper = new ModelMapper();
		this.sRecipeRepository = sRecipeRepository;
		this.userRepository = userRepository;
		this.recipeRepository = recipeRepository;
	}

	@Override
	@Transactional
	@Cacheable(CACHE)
	public List<SavedRecipeDto> findAll() {
		return sRecipeRepository.findAll().stream().map(sRecipe -> modelMapper.map(sRecipe, SavedRecipeDto.class))
				.collect(Collectors.toList());
	}

	@Override
	@Transactional
	@Cacheable(CACHE)
	public SavedRecipeDto findById(String id) throws ObjectNotFoundException {
		Optional<SavedRecipe> sRecipe = sRecipeRepository.findById(id);

		if (!sRecipe.isPresent()) {
			throw new ObjectNotFoundException("Save Recipe not found");
		}

		return modelMapper.map(sRecipe.get(), SavedRecipeDto.class);
	}

	@Override
	@Transactional
	@CacheEvict(cacheNames = CACHE, allEntries = true)
	public SavedRecipeDto create(SavedRecipePersistentDto sRecipe) throws BadRequestException, ObjectNotFoundException {
		/*
		 * UserDto userInSrecipe = sRecipe.getUser(); Optional<User> user =
		 * userRepository.findById(userInSrecipe.getId());
		 */
		/*
		 * if (!user.isPresent()) { throw new ObjectNotFoundException("User not found");
		 * }
		 */

		// RecipeDto recipeInSrecipe = sRecipe.getRecipes();
		// Optional<Recipe> recipe = recipeRepository.findById(recipeInSrecipe.getId());

		/*
		 * if (!recipe.isPresent()) { throw new
		 * ObjectNotFoundException("Recipe not found"); }
		 */


		return modelMapper.map(sRecipeRepository.save(modelMapper.map(sRecipe, SavedRecipe.class)),
				SavedRecipeDto.class);
	}

	@Override
	@Transactional
	@CacheEvict(cacheNames = CACHE, allEntries = true)
	public SavedRecipeDto update(String id, SavedRecipePersistentDto sRecipe)
			throws BadRequestException, ObjectNotFoundException {
		SavedRecipeDto existingSRecipe = findById(id);

		UserDto userInSrecipe = sRecipe.getUser();
		Optional<User> user = userRepository.findById(userInSrecipe.getId());

		if (!user.isPresent()) {
			throw new ObjectNotFoundException("User not found");
		}

		RecipeDto recipeInSrecipe = sRecipe.getRecipes();
		Optional<Recipe> recipe = recipeRepository.findById(recipeInSrecipe.getId());

		if (!recipe.isPresent()) {
			throw new ObjectNotFoundException("Recipe not found");
		}

		modelMapper.map(sRecipe, existingSRecipe);

		return modelMapper.map(sRecipeRepository.save(modelMapper.map(existingSRecipe, SavedRecipe.class)),
				SavedRecipeDto.class);
	}

	@Override
	@Transactional
	@CacheEvict(cacheNames = CACHE, allEntries = true)
	public void remove(String id) throws ObjectNotFoundException {
		sRecipeRepository.deleteById(findById(id).getId());
	}

	@Override
	@Transactional
	@Cacheable(CACHE)
	public List<SavedRecipeDto> findByUser(String idUser) {

		Optional<User> user = userRepository.findById(idUser);
		return sRecipeRepository.findByUser(modelMapper.map(user.get(), User.class)).stream()
				.map(sRecipe -> modelMapper.map(sRecipe, SavedRecipeDto.class)).collect(Collectors.toList());
	}

	@Override
	@Transactional
	@Cacheable(CACHE)
	public SavedRecipeDto findByIdRecipeIdUser(String idUser, String isRecipe) throws ObjectNotFoundException {
		Optional<User> user = userRepository.findById(idUser);

		if (!user.isPresent()) {
			throw new ObjectNotFoundException("User not found");
		}

		Optional<Recipe> recipe = recipeRepository.findById(isRecipe);

		if (!recipe.isPresent()) {
			throw new ObjectNotFoundException("Recipe not found");
		}

		SavedRecipe sr = sRecipeRepository.findByUserAndRecipes(modelMapper.map(user.get(), User.class),
				modelMapper.map(recipe.get(), Recipe.class));

		if (sr == null) {
			return new SavedRecipeDto();
		}

		return modelMapper.map(sr, SavedRecipeDto.class);

	}

}
