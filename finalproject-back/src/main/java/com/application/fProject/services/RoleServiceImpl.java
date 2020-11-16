package com.application.fProject.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.application.fProject.dtos.RoleDto;
import com.application.fProject.exceptions.ObjectNotFoundException;
import com.application.fProject.models.Role;
import com.application.fProject.repositories.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService {

	private static final String CACHE = "roleData";

	private final RoleRepository roleRepository;

	private final ModelMapper modelMapper;

	@Autowired
	public RoleServiceImpl(RoleRepository roleRepository) {
		super();
		this.modelMapper = new ModelMapper();
		this.roleRepository = roleRepository;
	}

	@Override
	@Transactional
	@Cacheable(CACHE)
	public List<RoleDto> findAll() {
		return roleRepository.findAll().stream().map(role -> modelMapper.map(role, RoleDto.class))
				.collect(Collectors.toList());
	}

	@Override
	@Transactional
	@Cacheable(CACHE)
	public RoleDto findById(String id) throws ObjectNotFoundException {
		Optional<Role> role = roleRepository.findById(id);

		if (!role.isPresent()) {
			throw new ObjectNotFoundException("Role not found");
		}

		return modelMapper.map(role.get(), RoleDto.class);
	}

}
