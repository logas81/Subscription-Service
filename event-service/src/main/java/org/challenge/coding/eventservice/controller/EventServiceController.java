package org.challenge.coding.eventservice.controller;

import org.challenge.coding.eventservice.data.EventServiceRequest;
import org.challenge.coding.eventservice.data.EventServiceResponse;
import org.challenge.coding.eventservice.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventServiceController {
	
	private final EventService eventService;
	
    @Autowired
    public EventServiceController(EventService eventService) {
        this.eventService = eventService;
    }
    
    @RequestMapping(value = "/sendEvent", method = {RequestMethod.POST})
    public @ResponseBody EventServiceResponse sendEvent(@RequestBody EventServiceRequest eventServiceRequest) {
        return this.eventService.sendEvent(eventServiceRequest);
    }    

}
