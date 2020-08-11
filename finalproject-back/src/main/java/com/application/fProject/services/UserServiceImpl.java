package com.application.fProject.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.application.fProject.dtos.UserDto;
import com.application.fProject.dtos.UserPersistentDto;
import com.application.fProject.exceptions.BadRequestException;
import com.application.fProject.exceptions.ObjectNotFoundException;
import com.application.fProject.models.User;
import com.application.fProject.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	private static final String CACHE = "userData";

	private final UserRepository userRepository;

	private final ModelMapper modelMapper;

	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.modelMapper = new ModelMapper();
		this.userRepository = userRepository;
		// this.modelMapper = modelMapper;
	}

	@Override
	@Transactional
	@Cacheable(CACHE)
	public List<UserDto> findAll() {
		return userRepository.findAll().stream().map(user -> modelMapper.map(user, UserDto.class))
				.collect(Collectors.toList());
	}

	@Override
	@Transactional
	@Cacheable(CACHE)
	public UserDto findById(String id) throws ObjectNotFoundException {
		Optional<User> user = userRepository.findById(id);

		if (!user.isPresent()) {
			throw new ObjectNotFoundException("User not found");
		}

		return modelMapper.map(user.get(), UserDto.class);
	}

	@Override
	@Transactional
	@Cacheable(cacheNames = CACHE)
	public UserDto create(UserPersistentDto user) throws BadRequestException {

		Optional<User> checkUser = userRepository.findByEmail(user.getEmail());

		if (checkUser.isPresent()) {
			throw new BadRequestException("user.email.repeated");
		}

		return modelMapper.map(userRepository.save(modelMapper.map(user, User.class)), UserDto.class);
	}

	@Override
	@Transactional
	@Cacheable(cacheNames = CACHE)
	public UserDto update(String id, UserPersistentDto user) throws BadRequestException, ObjectNotFoundException {
		UserDto existingUser = findById(id);

		Optional<User> checkUser = userRepository.findByEmail(user.getEmail());
		if (!existingUser.getEmail().equalsIgnoreCase(user.getEmail())) {
			if (checkUser.isPresent()) {
				throw new BadRequestException("user.email.repeated");
			}
		}

		modelMapper.map(user, existingUser);

		return modelMapper.map(userRepository.save(modelMapper.map(user, User.class)), UserDto.class);
	}

	@Override
	@Transactional
	@Cacheable(cacheNames = CACHE)
	public void remove(String id) throws ObjectNotFoundException {
		userRepository.deleteById(findById(id).getId());
	}

}
