package com.application.fProject.services;

import java.util.List;

import com.application.fProject.dtos.UserDto;
import com.application.fProject.dtos.UserPersistentDto;
import com.application.fProject.exceptions.BadRequestException;
import com.application.fProject.exceptions.ObjectNotFoundException;

public interface UserService {

	/**
	 * Get All users
	 * 
	 * @return List of users
	 */
	List<UserDto> findAll();

	/**
	 * Get user by id
	 * 
	 * @param id User's id
	 * @return User found
	 * @throws ObjectNotFoundException If user wasn't found
	 */
	UserDto findById(String id) throws ObjectNotFoundException;

	/**
	 * Confirm email and password
	 * 
	 * @param user User find
	 * @return number: 1 if email and password are true, -1 if email is false, -2 if
	 *         password is false and email is true
	 */
	String findByEmailAndPass(UserPersistentDto user);

	/**
	 * Find by email
	 * 
	 * @param email User's email
	 * @return User found
	 */
	UserDto findByEmail(String email);

	/**
	 * Create a user
	 * 
	 * @param user the user
	 * @return Persisted user
	 * @throws BadRequestException if the email is repeat
	 */
	UserDto create(UserPersistentDto user) throws BadRequestException;

	/**
	 * Update a user
	 * 
	 * @param id   User's id
	 * @param user User data to update
	 * @return Persisted user
	 * @throws BadRequestException     if the email is repeat
	 * @throws ObjectNotFoundException if user wasn't found
	 */
	UserDto update(String id, UserPersistentDto user) throws BadRequestException, ObjectNotFoundException;

	/**
	 * Removes user from database
	 * 
	 * @param id User's id
	 * @throws ObjectNotFoundException if user wasn't found
	 */
	void remove(String id) throws ObjectNotFoundException;

}
