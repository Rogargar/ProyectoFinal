package com.application.fProject.services;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
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

	private static String getMD5(String input) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] messageDigest = md.digest(input.getBytes());
			BigInteger number = new BigInteger(1, messageDigest);
			String hashtext = number.toString(16);

			while (hashtext.length() < 32) {
				hashtext = "0" + hashtext;
			}
			return hashtext;
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	@Transactional
	@CacheEvict(cacheNames = CACHE, allEntries = true)
	public UserDto create(UserPersistentDto user) throws BadRequestException {

		Optional<User> checkUser = userRepository.findByEmail(user.getEmail());

		user.setPass(getMD5(user.getPass()));

		if (checkUser.isPresent()) {
			throw new BadRequestException("user.email.repeated");
		}

		return modelMapper.map(userRepository.save(modelMapper.map(user, User.class)), UserDto.class);
	}

	@Override
	@Transactional
	@CacheEvict(cacheNames = CACHE, allEntries = true)
	public UserDto update(String id, UserPersistentDto user) throws BadRequestException, ObjectNotFoundException {
		UserDto existingUser = findById(id);

		Optional<User> checkUser = userRepository.findByEmail(user.getEmail());

		user.setPass(getMD5(user.getPass()));

		if (!existingUser.getEmail().equalsIgnoreCase(user.getEmail())) {
			if (checkUser.isPresent()) {
				throw new BadRequestException("user.email.repeated");
			}
		}

		modelMapper.map(user, existingUser);

		return modelMapper.map(userRepository.save(modelMapper.map(existingUser, User.class)), UserDto.class);
	}

	@Override
	@Transactional
	@CacheEvict(cacheNames = CACHE, allEntries = true)
	public void remove(String id) throws ObjectNotFoundException {
		userRepository.deleteById(findById(id).getId());
	}

	@Override
	@Transactional
	@CacheEvict(cacheNames = CACHE, allEntries = true)
	public String findByEmailAndPass(UserPersistentDto user) {
		Optional<User> checkUser = userRepository.findByEmail(user.getEmail());
		//checkUser.get().setPass(getMD5(checkUser.get().getPass()));
		if (!checkUser.isPresent()) {
			return "-1";
		} else {
			String passTrue = checkUser.get().getPass();
			if (passTrue.compareTo(user.getPass()) == 0) {
				return "1";
			} else {
				return "-2";
			}
		}
	}

	@Override
	@Transactional
	@CacheEvict(cacheNames = CACHE, allEntries = true)
	public UserDto findByEmail(String email) {
		Optional<User> checkUser = userRepository.findByEmail(email);

		return modelMapper.map(checkUser.get(), UserDto.class);
	}

}
