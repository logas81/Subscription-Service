package org.challenge.coding.eventservice.data;

public class EventServiceResponse {
	
	private String status;
	
	public EventServiceResponse() {
		 
	}

	public EventServiceResponse(String status) {
		this.status = status;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}

	@Override
    public String toString() {
        return "EventServiceResponse{" +
                "status='" + status + '\'' +
                '}';
	}	

}
