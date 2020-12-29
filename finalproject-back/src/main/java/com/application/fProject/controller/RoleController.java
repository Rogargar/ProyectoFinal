package com.application.fProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.fProject.dtos.RoleDto;
import com.application.fProject.exceptions.ObjectNotFoundException;
import com.application.fProject.services.RoleService;

/**
 * Controller for role entity
 * 
 * @author Rocío García
 *
 */
@RestController
@RequestMapping("/roles")
public class RoleController {

	private final RoleService roleService;

	@Autowired
	public RoleController(RoleService roleService) {
		this.roleService = roleService;
	}

	/**
	 * Gets all roles
	 * @return List of roles
	 */
	@GetMapping
	public ResponseEntity<List<RoleDto>> findAll() {
		return ResponseEntity.ok(roleService.findAll());
	}

	/**
	 * Gets role by id
	 * 
	 * @param id the id role
	 * @return Role found
	 * @throws ObjectNotFoundException If role wasn't found
	 */
	@GetMapping("/{id}")
	public ResponseEntity<RoleDto> findById(@PathVariable("id") String id) throws ObjectNotFoundException {
		return ResponseEntity.ok(roleService.findById(id));
	}

}
