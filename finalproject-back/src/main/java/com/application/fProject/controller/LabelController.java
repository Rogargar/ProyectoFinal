package com.application.fProject.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.fProject.dtos.LabelDto;
import com.application.fProject.dtos.LabelPersistentDto;
import com.application.fProject.exceptions.BadRequestException;
import com.application.fProject.exceptions.ObjectNotFoundException;
import com.application.fProject.services.LabelService;

@RestController
@RequestMapping("/labels")
public class LabelController {
	private final LabelService labelService;

	@Autowired
	public LabelController(LabelService labelService) {
		this.labelService = labelService;
	}

	@GetMapping
	public ResponseEntity<List<LabelDto>> findAll() {
		return ResponseEntity.ok(labelService.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<LabelDto> findById(@PathVariable("id") String id) throws ObjectNotFoundException {
		return ResponseEntity.ok(labelService.findById(id));
	}

	@PostMapping
	public ResponseEntity<LabelDto> create(@Valid @RequestBody LabelPersistentDto label)
			throws BadRequestException, ObjectNotFoundException {
		return ResponseEntity.ok(labelService.create(label));
	}

	@PutMapping("/{id}")
	public ResponseEntity<LabelDto> update(@PathVariable("id") String id,
			@Valid @RequestBody LabelPersistentDto label) throws BadRequestException, ObjectNotFoundException {
		return ResponseEntity.ok(labelService.update(id, label));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> remove(@PathVariable("id") String id) throws ObjectNotFoundException {
		labelService.remove(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
