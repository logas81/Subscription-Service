package org.challenge.coding.subscriptionservice.service;

import org.challenge.coding.subscriptionservice.data.Subscription;
import org.challenge.coding.subscriptionservice.data.SubscriptionResponse;

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
