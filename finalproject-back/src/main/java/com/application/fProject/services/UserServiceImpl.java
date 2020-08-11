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
import com.application.fProject.exceptions.ObjectNotFoundException;
import com.application.fProject.models.User;
import com.application.fProject.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	private static final String CACHE = "userData";

	private final UserRepository userRepository;

	private final ModelMapper modelMapper;

	@Autowired
	public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
		super();
		this.userRepository = userRepository;
		this.modelMapper = modelMapper;
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
	public UserDto create(UserPersistentDto user) {

		return null;
	}

	@Override
	public UserDto update(String id, UserPersistentDto user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(String id) {
		// TODO Auto-generated method stub

	}

}
