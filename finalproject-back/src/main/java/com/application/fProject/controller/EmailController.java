package com.application.fProject.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.fProject.dtos.EmailBody;
import com.application.fProject.services.EmailService;

/**
 * Controller for email entity
 * 
 * @author Rocío García
 *
 */
@RestController
@RequestMapping("/email")
public class EmailController {

	private EmailService emailService;

	@Autowired
	public EmailController(EmailService emailService) {
		this.emailService = emailService;
	}

	/**
	 * Create a new email 
	 * 
	 * @param emailBody Email to create
	 * @return
	 */
	@PostMapping("/send")
	public ResponseEntity<Boolean> create(@Valid @RequestBody EmailBody emailBody) {
		return ResponseEntity.ok(emailService.sendEmail(emailBody));
	}

}
