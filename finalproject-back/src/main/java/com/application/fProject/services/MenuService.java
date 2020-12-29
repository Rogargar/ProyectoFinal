package com.application.fProject.services;

import java.util.List;

import com.application.fProject.dtos.MenuDto;
import com.application.fProject.dtos.MenuPersistentDto;
import com.application.fProject.exceptions.BadRequestException;
import com.application.fProject.exceptions.ObjectNotFoundException;

public interface MenuService {

	/**
	 * Get All menus
	 * 
	 * @return List of menus
	 */
	List<MenuDto> findAll();

	/**
	 * Get menu by id
	 * 
	 * @param id Menu's id
	 * @return Menu found
	 * @throws ObjectNotFoundException If menu wasn't found
	 */
	MenuDto findById(String id) throws ObjectNotFoundException;

	/**
	 * Create a menu
	 * 
	 * @param menu the menu
	 * @return Persisted menu
	 * @throws BadRequestException if the saved recipe not found
	 */
	MenuDto create(MenuPersistentDto menu) throws BadRequestException, ObjectNotFoundException;

	/**
	 * Update a menu
	 * 
	 * @param id   Menu's id
	 * @param user Menu data to update
	 * @return Persisted menu
	 * @throws ObjectNotFoundException if the saved recipe not found
	 */
	MenuDto update(String id, MenuPersistentDto menu) throws BadRequestException, ObjectNotFoundException;

	/**
	 * Removes menu from database
	 * 
	 * @param id Menu's id
	 * @throws ObjectNotFoundException if menu wasn't found
	 */
	void remove(String id) throws ObjectNotFoundException;

}
