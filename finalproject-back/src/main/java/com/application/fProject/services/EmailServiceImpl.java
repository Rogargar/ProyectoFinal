package com.application.fProject.services;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.application.fProject.dtos.EmailBody;

/**
 * Implementation of Email Service
 * 
 * @author Rocío García
 *
 */
@Service
public class EmailServiceImpl implements EmailService {

	private static final String CACHE = "emailData";
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EmailService.class);

	@Autowired
	private JavaMailSender sender;

	@Override
	@Transactional
	@CacheEvict(cacheNames = CACHE, allEntries = true)
	public boolean sendEmail(EmailBody emailBody) {
		LOGGER.info("EmailBody: {}", emailBody.toString());
		return sendEmailTool(emailBody.getContent(), emailBody.getEmail(), emailBody.getSubject());
	}

	/**
	 * Send email
	 * 
	 * @param textMessage text of message
	 * @param email email what send
	 * @param subject subject
	 * @return true or false
	 */
	private boolean sendEmailTool(String textMessage, String email, String subject) {
		boolean send = false;
		MimeMessage message = sender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);
		try {
			helper.setFrom(email);
			helper.setTo("rociogg@alumnos.iesgalileo.es");
			helper.setText("email: "+email+" contenido:" + textMessage, true);
			helper.setSubject(subject);
			sender.send(message);
			send = true;
			LOGGER.info("Mail enviado!");
		} catch (MessagingException e) {
			LOGGER.error("Hubo un error al enviar el mail: {}", e);
		}
		return send;
	}

}
