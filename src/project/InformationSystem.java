package project;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class InformationSystem {

	public static void main(String[] args) throws ParseException{
		new Menu().setVisible(true);
		
        Scanner input = new Scanner(System.in);
        System.out.println("GSM SERVICE PROVIDER ?");
        String name = input.nextLine();
        System.out.println("NUMBER OF SUBSCRIPTION PLANS");
        int number = input.nextInt();
        
        //Creating the service provider
        GSMProvider gsmProvider= new GSMProvider(name);
        for (int i=1; i<= number; i++){
            System.out.println("NAME OF THE Plan #"+ i+ "?");
            name= input.nextLine();
            
            while(gsmProvider.findSubscriptionPlan(name) != null){
                System.out.println("This plan already exists! Please try again");
                name= input.nextLine();
            }
            
            SubscriptionPlan subscriptionPlan = new SubscriptionPlan(name,gsmProvider);
            gsmProvider.addSubscriptionPlan(subscriptionPlan);
        }
        
        System.out.println("CUSTOMER CITIZENSHIP NUMBER ?");
        String TC= input.nextLine();
        System.out.println("CUSTOMER NAME ?");
        name= input.nextLine();
        ExistingCustomer customer= new ExistingCustomer(TC); 
        customer.setName(name);
        System.out.println("NAME OF THE PLAN TO BE SUBSCRIBED ?");
        name= input.nextLine();
        
        while(gsmProvider.findSubscriptionPlan(name)==null){
            System.out.println("Such plan is not provided by our Service Provider. The available plans are: ");
            gsmProvider.printSubscriptionPlans();
            System.out.println("Please enter your choice: ");
            name= input.nextLine();
        }
        
        System.out.println("START DATE FOR SUBSCRIPTION (MM/DD/YYYY)?");
        String date =input.nextLine();
        Date startDate = new SimpleDateFormat("MM/dd/yyyy").parse(date); 
        Subscription subscription = new Subscription(startDate,gsmProvider.findSubscriptionPlan(name));
        customer.setSubscription(subscription);
        System.out.println("CUSTOMER CITIZENSHIP NUMBER = "+ customer.getCitizenshipNr());
        System.out.println("CUSTOMER NAME = " + customer.getName());
        System.out.println("SERVICE PROVIDER : " + customer.getSubscription().getSubscriptionPlan().getServiceProvider().getName());
        System.out.println("SUBSCRIPTION START DATE : " + customer.getSubscription().getSubscriptionStartDate());
        System.out.println("SUBSCRIPTION PLAN NAME : "+ customer.getSubscription().getSubscriptionPlan().getName());
        
        input.close();
	}

}
