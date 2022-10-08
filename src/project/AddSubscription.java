package project;

import java.io.*;
import java.text.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class AddSubscription extends javax.swing.JFrame{
	ArrayList<SubscriptionPlan> subscriptionPlan;
    ArrayList<Subscription> subscriptions;
    String [] subscriptionPlans;
    ArrayList<ExistingCustomer> customers;

    public AddSubscription(){
        initComponents();
        
        subscriptionPlan = new ArrayList<SubscriptionPlan>();
        subscriptions =  new ArrayList<Subscription>();
        customers = new ArrayList<ExistingCustomer>(); 
        
        populateArrayList();
        
        if(subscriptionPlan.isEmpty()){
            JOptionPane.showMessageDialog(null, "Please first add some Subscriptions Plans");
        }
        else{
            subscriptionPlans = new String[subscriptionPlan.size()];
            for(int i=0; i< subscriptionPlan.size(); i++){
                subscriptionPlans[i]= subscriptionPlan.get(i).getName();
            }
            plan.setModel(new javax.swing.DefaultComboBoxModel<>(subscriptionPlans));
        }
    }

    public void populateArrayList(){
        try{
            FileInputStream file =  new FileInputStream("subscriptions.dat");
            ObjectInputStream inputFile = new ObjectInputStream(file);
            boolean EOF = false;
            
            while(!EOF){
                try{
                    subscriptions.add( (Subscription)inputFile.readObject());
                }
                catch(EOFException e){
                    EOF = true;
                }
                catch(Exception f){
                    
                }
            }
            
            inputFile.close();
        }
        catch(IOException e){
           JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
		try{
		    FileInputStream file =  new FileInputStream("subscriptionPlans.dat");
		    ObjectInputStream inputFile = new ObjectInputStream(file);
		    boolean EOF = false;
		    
		    while(!EOF){
		        try{
		            subscriptionPlan.add( (SubscriptionPlan)inputFile.readObject());
		        }
		        catch(EOFException e){
		            EOF = true;
		        }
		        catch(Exception f){
		            
		        }
		    }
		    
		    inputFile.close();
		}
        catch(IOException e){
           JOptionPane.showMessageDialog(null, e.getMessage());
        }
         
		try{
		    FileInputStream file =  new FileInputStream("customers.dat");
		    ObjectInputStream inputFile = new ObjectInputStream(file);
		    boolean EOF = false;
		    
		    while(!EOF){
		        try{
		            customers.add( (ExistingCustomer)inputFile.readObject());
		        }
		        catch(EOFException e){
		            EOF = true;
		        }
		        catch(Exception f){
		            
		        }
		    }
		    
		    inputFile.close();
		}
		catch(IOException e){
		   JOptionPane.showMessageDialog(null, e.getMessage());
		}
    }
    
    public void saveTOFile(){
        try{
            FileOutputStream file= new FileOutputStream("subscriptions.dat");
            ObjectOutputStream outputFile =  new ObjectOutputStream(file);
            
            for(int i=0; i< subscriptions.size(); i++){
                outputFile.writeObject(subscriptions.get(i));
            }
            
            outputFile.close();
            JOptionPane.showMessageDialog(null, "New Subscription Successfully Saved ");
            this.dispose();
        }
        catch(IOException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        try{
            FileOutputStream file= new FileOutputStream("customers.dat");
            ObjectOutputStream outputFile =  new ObjectOutputStream(file);
            
            for(int i=0; i< customers.size(); i++){
                outputFile.writeObject(customers.get(i));
            }
            
            outputFile.close();
            JOptionPane.showMessageDialog(null, "Customer Information Saved");
            this.dispose();
        }
        catch(IOException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    /** to initialize the form.
     * WARNING: Do NOT modify this code.
     */
    private void initComponents() {
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        plan = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        date = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        nameSurname = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        telephone = new javax.swing.JTextField();
        TC = new javax.swing.JTextField();
        email = new javax.swing.JTextField();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add Subscription");

        jLabel1.setFont(new java.awt.Font("Perpetua Titling MT", 0, 14)); 
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setText("Add a new Subscription");

        jLabel2.setText("Please select the Subscription Plan");

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Submit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        plan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));
        plan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                planActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); 
        jLabel4.setText("Personal Information of the Customer");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); 
        jLabel5.setText("Subscription Information");

        jLabel6.setText("Please enter the date of the Subscription");

        date.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateActionPerformed(evt);
            }
        });

        jLabel7.setText("Name and Surname");

        jLabel8.setText("TC Number");

        jLabel9.setText("Telephone Nmuber");

        jLabel10.setText("Email");

        jLabel11.setText("in the format: MM/DD/YYYY");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(267, 267, 267)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jLabel4))
                            .addComponent(jLabel9)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel10))
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(telephone, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nameSurname, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TC, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addGap(94, 94, 94)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(plan, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(jLabel11))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(358, 358, 358)
                        .addComponent(jButton1)))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(99, 99, 99)
                                .addComponent(jLabel3))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(jLabel4)
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(nameSurname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(TC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(25, 25, 25)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel9)
                                            .addComponent(telephone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(31, 31, 31)
                                        .addComponent(jLabel10))
                                    .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(jLabel5)
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(plan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(105, 105, 105))
        );

        pack();
        setLocationRelativeTo(null);
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        if(nameSurname.getText().isEmpty() || TC.getText().isEmpty() || email.getText().isEmpty() || 
                telephone.getText().isEmpty() || date.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Please Enter All Fields!");
        }
        else{
            Subscription subscription= null;
            try {
                subscription= new Subscription(new SimpleDateFormat("MM/dd/yyyy").parse(date.getText().trim()), subscriptionPlan.get(plan.getSelectedIndex()));
            } 
            catch (ParseException ex) {
                Logger.getLogger(AddSubscription.class.getName()).log(Level.SEVERE, null, ex);
            }
            subscriptions.add(subscription);
            ExistingCustomer customer= new ExistingCustomer(subscription,TC.getText().trim());
            customer.setName(nameSurname.getText().trim());
            customer.setMail(email.getText().trim());
            customer.setTel(telephone.getText().trim());
            customers.add(customer);
            
            saveTOFile();
        }
    }

    private void planActionPerformed(java.awt.event.ActionEvent evt) {
        
    }

    private void dateActionPerformed(java.awt.event.ActionEvent evt) {

    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } 
        catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AddSubscription.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } 
        catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddSubscription.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } 
        catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddSubscription.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } 
        catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddSubscription.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        //Creating and displaying the form
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddSubscription().setVisible(true);
            }
        });
    }

    private javax.swing.JTextField TC;
    private javax.swing.JTextField date;
    private javax.swing.JTextField email;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField nameSurname;
    private javax.swing.JComboBox<String> plan;
    private javax.swing.JTextField telephone;
}
