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
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ObjectNotFoundException extends Exception {

	private static final long serialVersionUID = -8439283580876603578L;

	/***
	 *  Instantiates a new conflict exception
	 * @param message the message
	 */
	public ObjectNotFoundException(String message) {
		super(message);
	}

	/***
	 *  Instantiates a new conflict exception
	 * @param message the message
	 * @param cause the cause
	 */
	public ObjectNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

}
