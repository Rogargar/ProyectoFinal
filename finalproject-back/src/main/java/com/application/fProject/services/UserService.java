package com.application.fProject.services;

import java.util.List;

import com.application.fProject.dtos.UserDto;
import com.application.fProject.dtos.UserPersistentDto;
import com.application.fProject.exceptions.ObjectNotFoundException;

public interface UserService {

	List<UserDto> findAll();

	UserDto findById(String id) throws ObjectNotFoundException;

	UserDto create(UserPersistentDto user);

	UserDto update(String id, UserPersistentDto user);

	void remove(String id);

}
