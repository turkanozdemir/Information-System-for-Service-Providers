package project;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;

public class CableProviderTest {
	CableProvider cableProvider;
    SubscriptionPlan subscriptionPlan1, subscriptionPlan2;
    
	public CableProviderTest() {
		cableProvider= new CableProvider("Local");
        subscriptionPlan1 = new SubscriptionPlan("4GB",cableProvider);
        subscriptionPlan2 = new SubscriptionPlan("5GB",cableProvider);
	}

	@Test
	public void testAddSubscriptionPlan() {
		System.out.println("addSubscriptionPlan Test");
        SubscriptionPlan subscriptionPlan = subscriptionPlan1;
        cableProvider.addSubscriptionPlan(subscriptionPlan);
        String expected = cableProvider.findSubscriptionPlan("4GB").getName();
        assertEquals(expected,"4GB");
	}

	@Test
	public void testFindSubscriptionPlan() {
		System.out.println("findSubscriptionPlan Test");
        cableProvider.addSubscriptionPlan(subscriptionPlan1);
        SubscriptionPlan expResult = subscriptionPlan1;
        SubscriptionPlan result = cableProvider.findSubscriptionPlan("4GB");
        assertEquals(expResult, result);
	}

	@Test
	public void testNotExistingFindSubscriptionPlan() {
		System.out.println("findSubscriptionPlan");
        cableProvider.addSubscriptionPlan(subscriptionPlan1);   
        SubscriptionPlan expResult = null;
        SubscriptionPlan result = cableProvider.findSubscriptionPlan("5GB");
        assertEquals(expResult, result);
	}
	
	@Test
	public void testGetName() {
		System.out.println("getName Test");
        assertEquals(cableProvider.getName(), "Local");
	}
}
