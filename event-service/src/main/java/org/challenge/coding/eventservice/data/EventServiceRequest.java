package org.challenge.coding.eventservice.data;

import java.util.Date;

public class EventServiceRequest {
	
	private String email;
	private String firstName;
	private String gender;
	private Date dateOfBirth;
	private Boolean consent;
	private String newsletterId;
	
	/**
	 * Empty constructor
	 */
	public EventServiceRequest() {
		
	}
	
	public EventServiceRequest(String email, String firstName, String gender, Date dateOfBirth, 
			Boolean consent, String newsletterId) {
		super();
		this.email = email;
		this.firstName = firstName;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.consent = consent;
		this.newsletterId = newsletterId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Boolean getConsent() {
		return consent;
	}

	public void setConsent(Boolean consent) {
		this.consent = consent;
	}

	public String getNewsletterId() {
		return newsletterId;
	}

	public void setNewsletterId(String newsletterId) {
		this.newsletterId = newsletterId;
	}
	
}
