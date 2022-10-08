package project;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;

public class GSMProviderTest {
	GSMProvider gsmProvider;
    SubscriptionPlan subscriptionPlan1, subscriptionPlan2;
    
    public GSMProviderTest() {
        gsmProvider= new GSMProvider("TURKCELL");
        subscriptionPlan1 = new SubscriptionPlan("4GB",gsmProvider);
        subscriptionPlan2 = new SubscriptionPlan("5GB",gsmProvider);
    }
    
	@Test
	public void testAddSubscriptionPlan() {
		System.out.println("addSubscriptionPlan Test");
        SubscriptionPlan subscriptionPlan = subscriptionPlan1;
        gsmProvider.addSubscriptionPlan(subscriptionPlan);
        String expected = gsmProvider.findSubscriptionPlan("4GB").getName();
        assertEquals(expected,"4GB");
	}

	@Test
	public void testFindSubscriptionPlan() {
		System.out.println("findSubscriptionPlan Test");
        gsmProvider.addSubscriptionPlan(subscriptionPlan1);
        SubscriptionPlan expResult = subscriptionPlan1;
        SubscriptionPlan result = gsmProvider.findSubscriptionPlan("4GB");
        assertEquals(expResult, result);
	}
	
	@Test
	public void testNotExistFindSubscriptionPlan() {
		System.out.println("findSubscriptionPlan");
        gsmProvider.addSubscriptionPlan(subscriptionPlan1);    
        SubscriptionPlan expResult = null;
        SubscriptionPlan result = gsmProvider.findSubscriptionPlan("5GB");
        assertEquals(expResult, result);
	}

	@Test
	public void testGetName() {
		System.out.println("getName Test");
        assertEquals(gsmProvider.getName(), "TURKCELL");
	}
}
