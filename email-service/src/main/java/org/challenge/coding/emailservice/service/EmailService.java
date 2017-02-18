package org.challenge.coding.emailservice.service;

import org.challenge.coding.emailservice.data.EmailServiceRequest;
import org.challenge.coding.emailservice.data.EmailServiceResponse;

public interface EmailService {
	
	EmailServiceResponse sendConfirmationEmail (EmailServiceRequest emailServiceRequest);

}