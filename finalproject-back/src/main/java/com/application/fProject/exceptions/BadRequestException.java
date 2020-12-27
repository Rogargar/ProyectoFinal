package com.application.fProject.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
/****
 * 
 * The Class ConflictException
 * 
 * @author Rocío García
 *
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestException extends Exception {

	private static final long serialVersionUID = 1144921283142330762L;

	/***
	 *  Instantiates a new conflict exception
	 * @param message the message
	 */
	public BadRequestException(String message) {
		super(message);
	}

	/***
	 *  Instantiates a new conflict exception
	 * @param message the message
	 * @param cause the cause
	 */
	public BadRequestException(String message, Throwable cause) {
		super(message, cause);
	}

}
