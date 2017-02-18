package org.challenge.coding.subscriptionservice.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.challenge.coding.subscriptionservice.data.Subscription;
import org.challenge.coding.subscriptionservice.data.SubscriptionResponse;
import org.challenge.coding.subscriptionservice.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

/**
 * Subscription service implementation
 *
 */
@Service
public class SubscriptionServiceImpl implements SubscriptionService {
	
	private static final String SELECT_ID_SQL = "SELECT id FROM subscriptions WHERE email = ?";
	
	private static final String INSERT_SQL = "INSERT INTO subscriptions(email, firstName, gender, "
			+ "dateOfBirth, consent, newsletterId) values(?,?,?,?,?,?)";
	
	private static final String EMAIL_SERVICE_URL = "http://localhost:8081/sendConfirmationMail";
	
	private static final String EVENT_SERVICE_URL = "http://localhost:8082/sendEvent";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	
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
		
		String subId = "";
		
		RowMapper<String> idRowMapper = new RowMapper<String>() {
            public String mapRow(ResultSet rs, int rowNum) throws SQLException {
                return rs.getString("id");
            }
        };
		
		// Check if email already exists. Returns existing id if exists
		try {
			subId =	this.jdbcTemplate.queryForObject(
				SELECT_ID_SQL, new Object[] { subscription.getEmail() }, idRowMapper);
			return new SubscriptionResponse("OK. Email already subscribed.", subId);
		} catch (org.springframework.dao.EmptyResultDataAccessException ex) {	
		}

		
		// Insert new email
		this.jdbcTemplate.update(
				INSERT_SQL,
                subscription.getEmail(), subscription.getFirstName(), subscription.getGender(), 
                subscription.getDateOfBirth(), subscription.getConsent(), subscription.getNewsletterId()
        );
		
		// Get new email's id
		subId = this.jdbcTemplate.queryForObject(
				SELECT_ID_SQL , new Object[] { subscription.getEmail() }, idRowMapper);
		
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
