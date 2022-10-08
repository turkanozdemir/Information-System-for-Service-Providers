package project;

import static org.junit.Assert.assertEquals;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.jupiter.api.Test;

public class SubscriptionTest {
	Date startDate;
    SubscriptionPlan plan1, plan2;
    GSMProvider gsmProvider;
    Subscription subscription;
    
    public SubscriptionTest() throws ParseException {
        startDate = new SimpleDateFormat("MM/dd/yyyy").parse("06/15/2021");
        gsmProvider= new GSMProvider("TURKCELL");
        plan1 = new SubscriptionPlan("4GB", gsmProvider);
        plan2 = new SubscriptionPlan("5GB", gsmProvider);
        subscription = new Subscription(startDate,plan1);
    }
    
    @Test
    public void testGetSubscriptionStartDate() throws ParseException {
        System.out.println("getSubscriptionStartDate Test");
        assertEquals(new SimpleDateFormat("MM/dd/yyyy").parse("06/15/2021"), subscription.getSubscriptionStartDate());
    }

    @Test
    public void testGetSubscriptionPlan() {
        System.out.println("getSubscriptionPlan Test");
        assertEquals(plan1, subscription.getSubscriptionPlan());
    }

    @Test
    public void testSetSubscriptionStartDate() throws ParseException {
        System.out.println("setSubscriptionStartDate Test");
        startDate = new SimpleDateFormat("MM/dd/yyyy").parse("08/15/2021");
        subscription.setSubscriptionStartDate(startDate);
        assertEquals(startDate, subscription.getSubscriptionStartDate());     
    }

    @Test
    public void testSetSubscriptionPlan() {
        System.out.println("setSubscriptionPlan Test");
        subscription.setSubscriptionPlan(plan2);
        assertEquals(plan2, subscription.getSubscriptionPlan());       
    }
}
