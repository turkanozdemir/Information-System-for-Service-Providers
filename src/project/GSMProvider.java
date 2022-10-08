package project;

import java.io.Serializable;
import java.util.ArrayList;

public class GSMProvider implements ServiceProvider, Serializable{
	private String Name;
    private ArrayList<SubscriptionPlan> subscriptionPlans = new ArrayList<SubscriptionPlan>();

    public GSMProvider(String Name) {
        this.Name = Name;
        this.subscriptionPlans = new ArrayList<SubscriptionPlan>();
    }

    public void addSubscriptionPlan(SubscriptionPlan subscriptionPlan) {
        this.subscriptionPlans.add(subscriptionPlan);
    }

    public SubscriptionPlan findSubscriptionPlan(String name) {
        for( SubscriptionPlan plan : this.subscriptionPlans){
            if(plan.getName().equals(name)){
                return plan;
            }
        }
       return null;
    }

    public String getName() {
        return this.Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void printSubscriptionPlans() {
        for(SubscriptionPlan plan: this.subscriptionPlans){
        	System.out.println(plan.getName());
        }
    }
}
