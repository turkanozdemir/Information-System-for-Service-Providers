package project;

import java.io.Serializable;

public class ExistingCustomer extends Customer implements Serializable{
	private Subscription subscription;

    public ExistingCustomer(String CitizenshipNr) {
        super(CitizenshipNr);
    }

    public ExistingCustomer(Subscription subscription, String CitizenshipNr) {
        super(CitizenshipNr);
        this.subscription = subscription;
    }

    public Subscription getSubscription() {
        return subscription;
    }

    public void setSubscription(Subscription subscription) {
        this.subscription = subscription;
    }
}
