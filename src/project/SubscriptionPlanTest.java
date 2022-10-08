package project;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class SubscriptionPlanTest {
	String plan;
    GSMProvider gsmProvider;
    CableProvider cableProvider;
    SubscriptionPlan subscriptionPlan;
    
    public SubscriptionPlanTest() {
        plan= "4GB";
        gsmProvider = new GSMProvider(plan); 
        cableProvider = new CableProvider(plan);
        subscriptionPlan = new SubscriptionPlan(plan,gsmProvider );
    }

    @Test
    public void testGetName() {
        System.out.println("getName Test");
        assertEquals(plan,subscriptionPlan.getName() );
    }

    @Test
    public void testSetName() {
        System.out.println("setName Test");
        subscriptionPlan.setName("new Name");
        assertEquals("new Name",subscriptionPlan.getName() );
    }

    @Test
    public void testGetServiceProvider() {
        System.out.println("getServiceProvider Test");
        assertEquals(gsmProvider,subscriptionPlan.getServiceProvider());
    }

    @Test
    public void testSetServiceProvider() {
        System.out.println("SetServiceProvider Test");
        subscriptionPlan.setServiceProvider(cableProvider);
        assertEquals(cableProvider,subscriptionPlan.getServiceProvider() );
    }

}
