package org.challenge.coding.subscriptionservice.service.impl;

import org.challenge.coding.subscriptionservice.service.SubscriptionService;
import org.challenge.coding.subscriptionservice.model.entity.Subscription;
import org.challenge.coding.subscriptionservice.model.entity.SubscriptionResponse;
import org.challenge.coding.subscriptionservice.model.repository.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

/**
 * Subscription service implementation
 *
 */
@Service
public class SubscriptionServiceImpl implements SubscriptionService {
	
	private static final String EMAIL_SERVICE_URL = "http://localhost:8081/sendConfirmationMail";
	
	private static final String EVENT_SERVICE_URL = "http://localhost:8082/sendEvent";
	
	@Autowired
	private SubscriptionRepository subscriptionRepository;

	
	/**
	 * Adds new subscription to database; Returns existing ID if email already exists
	 * @param subscription subscriptor's data
	 * @return the subscription response
	 */
	@Override
	public SubscriptionResponse addSubscription(Subscription subscription) {
		
		// Check mandatory parameters
    	if (subscription.getDateOfBirth() == null 
    			|| subscription.getConsent() == null
    			|| subscription.getEmail() == null
    			|| subscription.getNewsletterId() == null) {
    		return new SubscriptionResponse("ERROR. Mandatory data not available.", "-1");
    	}

		// Check if email already exists. Returns existing ID if exists
        Subscription auxSub = subscriptionRepository.findByEmail(subscription.getEmail());
        if (auxSub != null) {
           return new SubscriptionResponse("OK. Email already subscribed.", auxSub.getId().toString());
        }
        
		// Insert new email (create subscription)
        auxSub = subscriptionRepository.save(subscription);

		// Get new email's id
        String subId = auxSub.getId().toString();
		
		// Invoke email service
		invokeEmailService(subscription);
		
		// Invoke event service
		invokeEventService(subscription);

		return new SubscriptionResponse("OK", subId);
	}
	
	/**
	 * Email Service Rest Client
	 * @param subscription subscriptor's data
	 */
	private void invokeEmailService(Subscription subscription) {
		
		RestTemplate restTemplate = new RestTemplate();
		// Manage Connection refused problems
		try {
			ResponseEntity<String> response = 
				restTemplate.postForEntity(EMAIL_SERVICE_URL, subscription, String.class);
			System.out.println(response);
		} catch (final ResourceAccessException e) {
	        System.out.println(e);
	    }
		
	}
	
	/**
	 * Event Service Rest Client
	 * @param subscription subscriptor's data
	 */
	private void invokeEventService(Subscription subscription) {
		
		RestTemplate restTemplate = new RestTemplate();
		// Manage Connection refused problems
		try {
			ResponseEntity<String> response = 
				restTemplate.postForEntity(EVENT_SERVICE_URL, subscription, String.class);
			System.out.println(response);
		} catch (final ResourceAccessException e) {
	        System.out.println(e);
	    }
		
	}
	
	
	
	
	

}
