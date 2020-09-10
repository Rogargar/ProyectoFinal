package com.application.fProject.services;

import java.util.List;

import com.application.fProject.dtos.LabelDto;
import com.application.fProject.dtos.LabelPersistentDto;
import com.application.fProject.exceptions.BadRequestException;
import com.application.fProject.exceptions.ObjectNotFoundException;

public interface LabelService {

	List<LabelDto> findAll();

	LabelDto findById(String id) throws ObjectNotFoundException;

	LabelDto create(LabelPersistentDto label) throws BadRequestException, ObjectNotFoundException;

	LabelDto update(String id, LabelPersistentDto label) throws BadRequestException, ObjectNotFoundException;

	void remove(String id) throws ObjectNotFoundException;
}
