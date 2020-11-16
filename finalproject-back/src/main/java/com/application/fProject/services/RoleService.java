package com.application.fProject.services;

import java.util.List;

import com.application.fProject.dtos.RoleDto;
import com.application.fProject.exceptions.ObjectNotFoundException;

public interface RoleService {

	List<RoleDto> findAll();

	RoleDto findById(String id) throws ObjectNotFoundException;
}
