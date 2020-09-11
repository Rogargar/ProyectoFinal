package com.application.fProject.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.fProject.repositories.MenuRepository;
import com.application.fProject.repositories.SaveRecipeRepository;

@Service
public class MenuServiceImpl {

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

}
