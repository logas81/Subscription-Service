package org.challenge.coding.subscriptionservice.service.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Date;

import org.challenge.coding.subscriptionservice.model.entity.Subscription;
import org.challenge.coding.subscriptionservice.model.entity.SubscriptionResponse;
import org.challenge.coding.subscriptionservice.model.repository.SubscriptionRepository;
import org.challenge.coding.subscriptionservice.service.impl.SubscriptionServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest 
public class SubscriptionServiceTest {
	
    Subscription testSub1 = new Subscription("test1@test.com", "name", "male",
    		new Date(), true, "news1");	
	
    @InjectMocks
    private SubscriptionServiceImpl subscriptionService;
    
    @Mock
    private SubscriptionRepository subscriptionRepositoryMock;
    
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        Mockito.when(subscriptionRepositoryMock.save(testSub1)).thenReturn(testSub1);
    	Mockito.when(subscriptionRepositoryMock.findByEmail("test1@test.com")).thenReturn(testSub1);
    }
	
    /**
     * Create new Subscription
     * @throws Exception
     */
    @Test
    public void createSubscriptionSuccessfully() throws Exception {
    	testSub1.setId(new Long(1));
    	Mockito.when(subscriptionRepositoryMock.findByEmail("test1@test.com")).thenReturn(null);
        SubscriptionResponse subscriptionResponse = subscriptionService.addSubscription(testSub1);
        assertNotNull(subscriptionResponse);
        assertEquals("OK", subscriptionResponse.getStatus());
    }
	
    /**
     * Create new Subscription (email previously subscribed)
     * @throws Exception
     */    
    @Test
    public void createSubscriptionSuccessfullyExistingSubscriptor() throws Exception {
    	testSub1.setId(new Long(1));
        SubscriptionResponse subscriptionResponse = subscriptionService.addSubscription(testSub1);
        assertNotNull(subscriptionResponse);
        assertEquals("OK. Email already subscribed.", subscriptionResponse.getStatus());
    }   
    
    /**
     * Create new Subscription without one mandatory param.
     * @throws Exception
     */    
    @Test
    public void createSubscriptionWrongParameters() throws Exception {
    	testSub1.setId(new Long(1));
    	testSub1.setNewsletterId(null);
        SubscriptionResponse subscriptionResponse = subscriptionService.addSubscription(testSub1);
        assertNotNull(subscriptionResponse);
        assertEquals("ERROR. Mandatory data not available.", subscriptionResponse.getStatus());
    }       

}
