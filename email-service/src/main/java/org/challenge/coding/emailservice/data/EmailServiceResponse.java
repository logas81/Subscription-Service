package org.challenge.coding.emailservice.data;

public class EmailServiceResponse {
	
	private String status;
	
	public EmailServiceResponse() {
		 
	}

	public EmailServiceResponse(String status) {
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
        return "EmailServiceResponse{" +
                "status='" + status + '\'' +
                '}';
	}	

}
