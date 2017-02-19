package org.challenge.coding.subscriptionservice.service;

import org.challenge.coding.subscriptionservice.model.entity.Subscription;
import org.challenge.coding.subscriptionservice.model.entity.SubscriptionResponse;

/**
 * Subscription service interface
 */
public interface SubscriptionService {

	/**
	 * Method that creates a new subscription
	 * @param subscription subscriptor's data
	 * @return the subscription response
	 */
	SubscriptionResponse addSubscription(Subscription subscription);
	
}
