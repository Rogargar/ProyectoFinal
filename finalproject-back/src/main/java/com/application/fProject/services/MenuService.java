package com.application.fProject.services;

import java.util.List;

import com.application.fProject.dtos.MenuDto;
import com.application.fProject.dtos.MenuPersistentDto;
import com.application.fProject.exceptions.BadRequestException;
import com.application.fProject.exceptions.ObjectNotFoundException;

public interface MenuService {

	List<MenuDto> findAll();

	MenuDto findById(String id) throws ObjectNotFoundException;

	MenuDto create(MenuPersistentDto menu) throws BadRequestException, ObjectNotFoundException;

	MenuDto update(String id, MenuPersistentDto menu) throws BadRequestException, ObjectNotFoundException;

	void remove(String id) throws ObjectNotFoundException;

}
