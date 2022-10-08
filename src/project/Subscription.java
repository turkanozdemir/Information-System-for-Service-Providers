package project;

import java.io.Serializable;
import java.util.Date;

public class Subscription implements Serializable{
	private Date subscriptionStartDate;
    private SubscriptionPlan subscriptionPlan;

    public Subscription(Date subscriptionStartDate, SubscriptionPlan subscriptionPlan) {
        this.subscriptionStartDate = subscriptionStartDate;
        this.subscriptionPlan = subscriptionPlan;
    }

    public Date getSubscriptionStartDate() {
        return subscriptionStartDate;
    }

    public SubscriptionPlan getSubscriptionPlan() {
        return subscriptionPlan;
    }

    public void setSubscriptionStartDate(Date subscriptionStartDate) {
        this.subscriptionStartDate = subscriptionStartDate;
    }

    public void setSubscriptionPlan(SubscriptionPlan subscriptionPlan) {
        this.subscriptionPlan = subscriptionPlan;
    }
}
