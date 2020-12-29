package com.application.fProject.services;

import java.util.List;

import com.application.fProject.dtos.LabelDto;
import com.application.fProject.dtos.LabelPersistentDto;
import com.application.fProject.exceptions.BadRequestException;
import com.application.fProject.exceptions.ObjectNotFoundException;

public interface LabelService {

	/**
	 * Get All labels
	 * 
	 * @return List of labels
	 */
	List<LabelDto> findAll();

	/**
	 * Get label by id
	 * 
	 * @param id Label's id
	 * @return Label found
	 * @throws ObjectNotFoundException If label wasn't found
	 */
	LabelDto findById(String id) throws ObjectNotFoundException;

	/**
	 * Create a label 
	 * 
	 * @param label the label
	 * @return Persisted label
	 * @throws BadRequestException if label name is repeat
	 */
	LabelDto create(LabelPersistentDto label) throws BadRequestException, ObjectNotFoundException;

	/**
	 * Update a label
	 * 
	 * @param id Label's id
	 * @param label Label data to update
	 * @return Persisted label
	 * @throws BadRequestException if label name is repeat
	 * @throws ObjectNotFoundException if label wasn't found
	 */
	LabelDto update(String id, LabelPersistentDto label) throws BadRequestException, ObjectNotFoundException;

	/**
	 * Removes label from database
	 * 
	 * @param id Label's id
	 * @throws ObjectNotFoundException if label wasn't found
	 */
	void remove(String id) throws ObjectNotFoundException;
}
