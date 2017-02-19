package org.challenge.coding.subscriptionservice.controller;

import javax.validation.Valid;

import org.challenge.coding.subscriptionservice.model.entity.Subscription;
import org.challenge.coding.subscriptionservice.model.entity.SubscriptionResponse;
import org.challenge.coding.subscriptionservice.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller class
 */
@RestController
public class SubscriptionController {
	
	private final SubscriptionService subscriptionService;
	
    @Autowired
    public SubscriptionController(SubscriptionService subscriptionService) {
        this.subscriptionService = subscriptionService;
    }
    
    /**
	 * Method that creates a new subscription
	 * @param subscription subscriptor's data
	 * @return the subscription response
     */
    @RequestMapping(value = "/createSubscription", method = {RequestMethod.POST})
    public @ResponseBody SubscriptionResponse addSubscription(@Valid @RequestBody Subscription subData) {
    	
        return this.subscriptionService.addSubscription(subData);
    }

}
