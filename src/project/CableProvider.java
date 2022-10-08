package project;

import java.io.Serializable;
import java.util.ArrayList;

public class CableProvider implements ServiceProvider, Serializable{
	private String Name;
    private ArrayList<SubscriptionPlan> subscriptionPlans = new ArrayList<SubscriptionPlan>();

    public CableProvider(String Name) {
        this.Name = Name;
        this.subscriptionPlans= new ArrayList<SubscriptionPlan>();
    }

    public void addSubscriptionPlan(SubscriptionPlan subscriptionPlan) {
        this.subscriptionPlans.add(subscriptionPlan);
    }

    public SubscriptionPlan findSubscriptionPlan(String name) {
        try{
            for( SubscriptionPlan plan : this.subscriptionPlans){
                if(plan.getName().equals(name)){
                    return plan;
                }
            }
        }
        catch(NullPointerException e)
        {
            System.out.print("NullPointerException Caught");
        }
       return null;
    }

    public String getName() {
        return this.Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }
}
