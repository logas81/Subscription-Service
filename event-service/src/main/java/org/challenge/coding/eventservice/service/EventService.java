package org.challenge.coding.eventservice.service;

import org.challenge.coding.eventservice.data.EventServiceRequest;
import org.challenge.coding.eventservice.data.EventServiceResponse;

public interface EventService {
	
	EventServiceResponse sendEvent (EventServiceRequest eventServiceRequest);

}