package com.application.fProject.services;

import java.util.List;

import com.application.fProject.dtos.RoleDto;
import com.application.fProject.exceptions.ObjectNotFoundException;

public interface RoleService {

	/**
	 * Get All roles
	 * 
	 * @return List of roles
	 */
	List<RoleDto> findAll();

	/**
	 * Get role by id
	 * 
	 * @param id Role's id
	 * @return Role found
	 * @throws ObjectNotFoundException If role wasn't found
	 */
	RoleDto findById(String id) throws ObjectNotFoundException;
}
