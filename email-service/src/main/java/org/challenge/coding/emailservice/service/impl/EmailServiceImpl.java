package org.challenge.coding.emailservice.service.impl;

import org.challenge.coding.emailservice.data.EmailServiceRequest;
import org.challenge.coding.emailservice.data.EmailServiceResponse;
import org.challenge.coding.emailservice.service.EmailService;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService{

	@Override
	public EmailServiceResponse sendConfirmationEmail(EmailServiceRequest emailServiceRequest) {
		return new EmailServiceResponse("OK");
	}
	
}
