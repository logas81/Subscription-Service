package org.challenge.coding.subscriptionservice.service.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.Date;

import org.challenge.coding.subscriptionservice.data.Subscription;
import org.challenge.coding.subscriptionservice.service.SubscriptionRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class SubscriptionRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private SubscriptionRepository subscriptionRepository;
    
    Subscription testSub1 = new Subscription("test1@test.com", "name", "male",
    		new Date(), true, "news1");
    
    Subscription testSub2 = new Subscription("test2@test.com", "name", "male",
    		new Date(), true, "news1");    

    /**
     * Test Find method
     */
    @Test
    public void testFindByEmail() {
        entityManager.persist(testSub1);
        Subscription subscription = subscriptionRepository.findByEmail("test1@test.com");
        assertEquals("test1@test.com", subscription.getEmail());
    }
    
    /**
     * Test Find method
     */    
    @Test
    public void testFindByNoExistingEmail() {
        entityManager.persist(testSub1);
        Subscription subscription = subscriptionRepository.findByEmail("test1@test.com");
        assertNotEquals("test2@test.com", subscription.getEmail());
    }
    
    /**
     * Test Save method
     */    
    @Test
    public void testSave() {
        entityManager.persist(testSub1);
        Subscription subscription = subscriptionRepository.save(testSub2);
        assertNotEquals("test1@test.com", subscription.getEmail());
        assertEquals("test2@test.com", subscription.getEmail());
    }
}