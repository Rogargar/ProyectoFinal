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

import com.application.fProject.dtos.MenuDto;
import com.application.fProject.dtos.MenuPersistentDto;
import com.application.fProject.dtos.SavedRecipeDto;
import com.application.fProject.exceptions.BadRequestException;
import com.application.fProject.exceptions.ObjectNotFoundException;
import com.application.fProject.models.Menu;
import com.application.fProject.models.SavedRecipe;
import com.application.fProject.repositories.MenuRepository;
import com.application.fProject.repositories.SaveRecipeRepository;

@Service
public class MenuServiceImpl implements MenuService {

	private static final String CACHE = "menuData";

	private final MenuRepository menuRepository;

	private final SaveRecipeRepository sRecipeRepository;

	private final ModelMapper modelMapper;

	@Autowired
	public MenuServiceImpl(MenuRepository menuRepository, SaveRecipeRepository sRecipeRepository) {
		super();
		this.modelMapper = new ModelMapper();
		this.menuRepository = menuRepository;
		this.sRecipeRepository = sRecipeRepository;
	}

	@Override
	@Transactional
	@Cacheable(CACHE)
	public List<MenuDto> findAll() {
		return menuRepository.findAll().stream().map(menu -> modelMapper.map(menu, MenuDto.class))
				.collect(Collectors.toList());
	}

	@Override
	@Transactional
	@Cacheable(CACHE)
	public MenuDto findById(String id) throws ObjectNotFoundException {
		Optional<Menu> menu = menuRepository.findById(id);

		if (!menu.isPresent()) {
			throw new ObjectNotFoundException("Menu not found");
		}

		return modelMapper.map(menu.get(), MenuDto.class);
	}

	@Override
	@Transactional
	@CacheEvict(cacheNames = CACHE, allEntries = true)
	public MenuDto create(MenuPersistentDto menu) throws BadRequestException, ObjectNotFoundException {

		SavedRecipeDto saveRecipeInMenu = menu.getSavedRecipes();
		Optional<SavedRecipe> savedRecipe = sRecipeRepository.findById(saveRecipeInMenu.getId());

		if (!savedRecipe.isPresent()) {
			throw new ObjectNotFoundException("Save Recipe not found");
		}

		return modelMapper.map(menuRepository.save(modelMapper.map(menu, Menu.class)), MenuDto.class);
	}

	@Override
	@Transactional
	@CacheEvict(cacheNames = CACHE, allEntries = true)
	public MenuDto update(String id, MenuPersistentDto menu) throws BadRequestException, ObjectNotFoundException {

		MenuDto existingMenu = findById(id);

		SavedRecipeDto saveRecipeInMenu = menu.getSavedRecipes();
		Optional<SavedRecipe> savedRecipe = sRecipeRepository.findById(saveRecipeInMenu.getId());

		if (!savedRecipe.isPresent()) {
			throw new ObjectNotFoundException("Save Recipe not found");
		}

		modelMapper.map(menu, existingMenu);

		return modelMapper.map(menuRepository.save(modelMapper.map(existingMenu, Menu.class)), MenuDto.class);
	}

	@Override
	@Transactional
	@CacheEvict(cacheNames = CACHE, allEntries = true)
	public void remove(String id) throws ObjectNotFoundException {
		menuRepository.deleteById(findById(id).getId());

	}

}
