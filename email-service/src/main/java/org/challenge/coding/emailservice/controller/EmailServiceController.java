package org.challenge.coding.emailservice.controller;

import org.challenge.coding.emailservice.data.EmailServiceRequest;
import org.challenge.coding.emailservice.data.EmailServiceResponse;
import org.challenge.coding.emailservice.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailServiceController {
	
	private final EmailService emailService;
	
    @Autowired
    public EmailServiceController(EmailService emailService) {
        this.emailService = emailService;
    }
    
    @RequestMapping(value = "/sendConfirmationMail", method = {RequestMethod.POST})
    public @ResponseBody EmailServiceResponse addSubscription(@RequestBody EmailServiceRequest emailServiceRequest) {
        return this.emailService.sendConfirmationEmail(emailServiceRequest);
    }    

}
