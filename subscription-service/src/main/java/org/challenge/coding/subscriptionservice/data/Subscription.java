package org.challenge.coding.subscriptionservice.data;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


/**
 * Subscription input data type definition
 */
@Entity
public class Subscription implements Serializable { 
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;	
	
	@Column(nullable = false)
	private String email;
	
	@Column
	private String firstName;
	
	@Column
	private String gender;
	
	@Column(nullable = false)
	private Date dateOfBirth;
	
	@Column(nullable = false)
	private Boolean consent;
	
	@Column(nullable = false)
	private String newsletterId;
	
	/**
	 * Empty constructor
	 */
	public Subscription() {
	}
	
	public Subscription(String email, String firstName, String gender, Date dateOfBirth, 
			Boolean consent, String newsletterId) {
		super();
		this.email = email;
		this.firstName = firstName;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.consent = consent;
		this.newsletterId = newsletterId;
	}

	
	public Long getId() {
		return id;
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
	
	@Override
    public String toString() {
        return "Subscription{" +
                "email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", gender='" + gender + '\'' +
                ", consent='" + consent + '\'' +
                ", newsletterId='" + newsletterId + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                '}';
	}
}
