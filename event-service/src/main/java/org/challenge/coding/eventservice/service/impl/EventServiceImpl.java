package org.challenge.coding.eventservice.service.impl;

import org.challenge.coding.eventservice.data.EventServiceRequest;
import org.challenge.coding.eventservice.data.EventServiceResponse;
import org.challenge.coding.eventservice.service.EventService;
import org.springframework.stereotype.Service;

@Service
public class EventServiceImpl implements EventService{

	@Override
	public EventServiceResponse sendEvent(EventServiceRequest eventServiceRequest) {
		return new EventServiceResponse("OK");
	}
	
}
