package org.challenge.coding.emailservice.service;

import org.challenge.coding.emailservice.data.EmailServiceRequest;
import org.challenge.coding.emailservice.data.EmailServiceResponse;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImp implements EmailService{

	@Override
	public EmailServiceResponse sendConfirmationEmail(EmailServiceRequest emailServiceRequest) {
		return new EmailServiceResponse("OK");
	}
	
}
