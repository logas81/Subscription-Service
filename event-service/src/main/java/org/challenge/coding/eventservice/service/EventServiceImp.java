package org.challenge.coding.eventservice.service;

import org.challenge.coding.eventservice.data.EventServiceRequest;
import org.challenge.coding.eventservice.data.EventServiceResponse;
import org.springframework.stereotype.Service;

@Service
public class EventServiceImp implements EventService{

	@Override
	public EventServiceResponse sendEvent(EventServiceRequest eventServiceRequest) {
		return new EventServiceResponse("OK");
	}
	
}
