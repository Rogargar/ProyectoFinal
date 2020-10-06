package com.application.fProject.services;

import java.util.List;

import com.application.fProject.dtos.UserDto;
import com.application.fProject.dtos.UserPersistentDto;
import com.application.fProject.exceptions.BadRequestException;
import com.application.fProject.exceptions.ObjectNotFoundException;

public interface UserService {

	List<UserDto> findAll();

	UserDto findById(String id) throws ObjectNotFoundException;

	String findByEmailAndPass(UserPersistentDto user);

	UserDto findByEmail(String email);

	UserDto create(UserPersistentDto user) throws BadRequestException;

	UserDto update(String id, UserPersistentDto user) throws BadRequestException, ObjectNotFoundException;

	void remove(String id) throws ObjectNotFoundException;

}
