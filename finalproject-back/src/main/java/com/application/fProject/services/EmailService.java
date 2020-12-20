package com.application.fProject.services;

import com.application.fProject.dtos.EmailBody;

public interface EmailService {

	public boolean sendEmail(EmailBody emailBody);

}
