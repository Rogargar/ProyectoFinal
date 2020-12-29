package com.application.fProject.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.application.fProject.dtos.LabelDto;
import com.application.fProject.dtos.LabelPersistentDto;
import com.application.fProject.exceptions.BadRequestException;
import com.application.fProject.exceptions.ObjectNotFoundException;
import com.application.fProject.models.Label;
import com.application.fProject.repositories.LabelRepository;

/**
 * Implementation of label Service
 * 
 * @author Rocío García
 *
 */
@Service
public class LabelServiceImpl implements LabelService {

	private static final String CACHE = "labelData";

	private final LabelRepository labelRepository;

	private final ModelMapper modelMapper;

	@Autowired
	public LabelServiceImpl(LabelRepository labelRepository) {
		super();
		this.modelMapper = new ModelMapper();
		this.labelRepository = labelRepository;
	}

	@Override
	@Transactional
	@Cacheable(CACHE)
	public List<LabelDto> findAll() {
		return labelRepository.findAll().stream().map(label -> modelMapper.map(label, LabelDto.class))
				.collect(Collectors.toList());
	}

	@Override
	@Transactional
	@Cacheable(CACHE)
	public LabelDto findById(String id) throws ObjectNotFoundException {
		Optional<Label> label = labelRepository.findById(id);

		if (!label.isPresent()) {
			throw new ObjectNotFoundException("Label not found");
		}

		return modelMapper.map(label.get(), LabelDto.class);
	}

	@Override
	@Transactional
	@CacheEvict(cacheNames = CACHE, allEntries = true)
	public LabelDto create(LabelPersistentDto label) throws BadRequestException, ObjectNotFoundException {
		System.out.println();
		if(labelRepository.findByName(label.getName())!=null) {
			return null;
		}
		return modelMapper.map(labelRepository.save(modelMapper.map(label, Label.class)), LabelDto.class);
	}

	@Override
	@Transactional
	@CacheEvict(cacheNames = CACHE, allEntries = true)
	public LabelDto update(String id, LabelPersistentDto label) throws BadRequestException, ObjectNotFoundException {
		LabelDto existingLabel = findById(id);
		if(labelRepository.findByName(label.getName())!=null) {
			return null;
		}
		modelMapper.map(label, existingLabel);

		return modelMapper.map(labelRepository.save(modelMapper.map(existingLabel, Label.class)), LabelDto.class);
	}

	@Override
	@Transactional
	@CacheEvict(cacheNames = CACHE, allEntries = true)
	public void remove(String id) throws ObjectNotFoundException {
		labelRepository.deleteById(findById(id).getId());

	}

}
