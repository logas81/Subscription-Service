package org.challenge.coding.subscriptionservice.data;

/**
 * Subscription output data type definition
 */
public class SubscriptionResponse {
	
	private String status;
	private String id;
	
	public SubscriptionResponse() { 
	}

	public SubscriptionResponse(String status, String id) {
		this.id = id;
		this.status = status;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	@Override
    public String toString() {
        return "SubscriptionResponse{" +
                "id='" + id + '\'' +
                ", status='" + status + '\'' +
                '}';
	}

}
