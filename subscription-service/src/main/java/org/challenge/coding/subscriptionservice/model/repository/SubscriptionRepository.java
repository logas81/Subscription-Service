package org.challenge.coding.subscriptionservice.model.repository;

import org.challenge.coding.subscriptionservice.model.entity.Subscription;
import org.springframework.data.repository.Repository;

/**
 * JPA Repository interface
 * 
 */
public interface SubscriptionRepository extends Repository<Subscription, Long> {

	/**
	 * Find subscriptions by email
	 * @param email the email to find in DB
	 * @return subscription if exists
	 */
	Subscription findByEmail(String email);
	
	/**
	 * Save subscriptions in database
	 * @param subscription subscription to save in DB
	 * @return saved subscription
	 */
	Subscription save(Subscription subscription);
	
}
