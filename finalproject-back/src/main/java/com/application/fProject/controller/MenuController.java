package com.application.fProject.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.fProject.dtos.MenuDto;
import com.application.fProject.dtos.MenuPersistentDto;
import com.application.fProject.exceptions.BadRequestException;
import com.application.fProject.exceptions.ObjectNotFoundException;
import com.application.fProject.services.MenuService;

/**
 * Controller for menu entity
 * 
 * @author Rocío García
 *
 */
@RestController
@RequestMapping("/menus")
public class MenuController {

	private final MenuService menuService;

	@Autowired
	public MenuController(MenuService menuService) {
		this.menuService = menuService;
	}

	/**
	 * Get All menus
	 * 
	 * @return List of menus
	 */
	@GetMapping
	public ResponseEntity<List<MenuDto>> findAll() {
		return ResponseEntity.ok(menuService.findAll());
	}

	/**
	 * Get menu by id
	 * 
	 * @param id Menu's id
	 * @return Menu found
	 * @throws ObjectNotFoundException If menu wasn't found
	 */
	@GetMapping("/{id}")
	public ResponseEntity<MenuDto> findById(@PathVariable("id") String id) throws ObjectNotFoundException {
		return ResponseEntity.ok(menuService.findById(id));
	}

	/**
	 * Create a menu
	 * 
	 * @param menu the menu
	 * @return Persisted menu
	 * @throws BadRequestException if the saved recipe not found
	 */
	@PostMapping
	public ResponseEntity<MenuDto> create(@Valid @RequestBody MenuPersistentDto menu)
			throws BadRequestException, ObjectNotFoundException {
		return ResponseEntity.ok(menuService.create(menu));
	}

	/**
	 * Update a menu
	 * 
	 * @param id   Menu's id
	 * @param user Menu data to update
	 * @return Persisted menu
	 * @throws ObjectNotFoundException if the saved recipe not found
	 */
	@PutMapping("/{id}")
	public ResponseEntity<MenuDto> update(@PathVariable("id") String id, @Valid @RequestBody MenuPersistentDto menu)
			throws BadRequestException, ObjectNotFoundException {
		return ResponseEntity.ok(menuService.update(id, menu));
	}

	/**
	 * Removes menu from database
	 * 
	 * @param id Menu's id
	 * @throws ObjectNotFoundException if menu wasn't found
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> remove(@PathVariable("id") String id) throws ObjectNotFoundException {
		menuService.remove(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
