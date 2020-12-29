package com.application.fProject.services;

import com.application.fProject.dtos.EmailBody;

public interface EmailService {

	/**
	 * Send email
	 * 
	 * @param emailBody email data to send
	 * @return boolean true if is true or false if is false
	 */
	public boolean sendEmail(EmailBody emailBody);

}
