package project;

import java.io.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class AddSubscriptionPlan extends javax.swing.JFrame{
    ArrayList<GSMProvider> gsmProviders;	//for all previous GSM Providers
    ArrayList<CableProvider> cableProviders;		//for all previous Cable Providers
    ArrayList<SubscriptionPlan> subscriptionPlan;	    //for all previous subscription plans
    String [] cableTypes, gsmTypes;
    
    public AddSubscriptionPlan() {
        initComponents();
        gsmProviders = new ArrayList<GSMProvider>();
        cableProviders= new ArrayList<CableProvider>();
        subscriptionPlan =  new ArrayList<SubscriptionPlan>();
        
        populateArrayList();
        
        if(cableProviders.isEmpty() && gsmProviders.isEmpty()){
            JOptionPane.showMessageDialog(null, "Please first add some service Providers");
        }
        else{
            cableTypes = new String[cableProviders.size()];
            gsmTypes = new String[gsmProviders.size()];
            
            for(int i=0; i< cableProviders.size(); i++){
                cableTypes[i]= cableProviders.get(i).getName();
            }
            
            for(int i=0; i< gsmProviders.size(); i++){
                gsmTypes[i]= gsmProviders.get(i).getName();
            }
        }
    }
    
    public void populateArrayList(){
        //To read all previous Cable Providers from the file cable.dat 
        try{
            FileInputStream file =  new FileInputStream("cable.dat");
            ObjectInputStream inputFile = new ObjectInputStream(file);
            boolean EOF = false;
            
            while(!EOF){
                try{
                    cableProviders.add( (CableProvider)inputFile.readObject());
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
        
        //To read all previous GSM Providers from the file GSM.dat 
        try{
            FileInputStream file =  new FileInputStream("gsm.dat");
            ObjectInputStream inputFile = new ObjectInputStream(file);
            boolean EOF = false;
            
            while(!EOF){
                try{
                    gsmProviders.add( (GSMProvider)inputFile.readObject());
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
        
        //To read all previous Subscription Plans from the file subscriptionPlans.dat 
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
    }
    
    //to save all Subscription Plans into subscriptionPlans.dat
    public void saveTOFile(){
        try{
            FileOutputStream file= new FileOutputStream("subscriptionPlans.dat");
            ObjectOutputStream outputFile =  new ObjectOutputStream(file);
            
            for(int i=0; i< subscriptionPlan.size(); i++){
                outputFile.writeObject(subscriptionPlan.get(i));
            }
            
            outputFile.close();
            JOptionPane.showMessageDialog(null, "Successfully Saved");
            this.dispose();
        }
        catch(IOException e){
            JOptionPane.showMessageDialog(null, e.getStackTrace());
            
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
        providerType = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        providerName = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        planName = new javax.swing.JTextField();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add Subscription plan");

        jLabel1.setFont(new java.awt.Font("Perpetua Titling MT", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setText("Add a new SubscrIptIon plan");

        jLabel2.setText("Please select the type of the Service Provider");

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Submit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        providerType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "GSM Provider", "Cable Provider" }));
        providerType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                providerTypeActionPerformed(evt);
            }
        });

        jLabel3.setText("Please enter the name of the Service  Provider");

        providerName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));
        providerName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                providerNameActionPerformed(evt);
            }
        });

        jLabel4.setText("Please enter the name of the Subscription Plan");

        planName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                planNameActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(126, 126, 126))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(171, 171, 171)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(planName))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(providerName, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(providerType, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(providerType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(providerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(planName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(23, 23, 23))
        );

        pack();
        setLocationRelativeTo(null);
    }
    
    // When clicking Submit Button
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(providerType.getSelectedIndex()==0 || planName.getText().isEmpty()){ //check if the user entered all the fields
            JOptionPane.showMessageDialog(null, "Please enter all fields");
        }
        else{
            SubscriptionPlan plan;
            if(providerType.getSelectedIndex()==1){
                GSMProvider gsmProvider = new GSMProvider(gsmTypes[providerName.getSelectedIndex()]);
                plan = new SubscriptionPlan (planName.getText(), gsmProvider);
            }
            else{ 
                CableProvider cableProvider = new CableProvider(gsmTypes[providerName.getSelectedIndex()]);
               plan = new SubscriptionPlan (planName.getText(), cableProvider);
            }
            
            try{
                subscriptionPlan.add(plan);
            }
            catch(NullPointerException e){
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
            saveTOFile();
        }
    }

    private void providerTypeActionPerformed(java.awt.event.ActionEvent evt) {
        if(providerType.getSelectedIndex()==1){
            //When selecting GSM Provider
            providerName.setModel(new javax.swing.DefaultComboBoxModel<>(gsmTypes));
        }
        else if(providerType.getSelectedIndex()==2){
            //When selecting Cable Provider
        	providerName.setModel(new javax.swing.DefaultComboBoxModel<>(cableTypes));
        }
        else if(providerType.getSelectedIndex()==0){
             providerName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"Select"}));
        }
    }

    private void providerNameActionPerformed(java.awt.event.ActionEvent evt) {
    	
    }

    private void planNameActionPerformed(java.awt.event.ActionEvent evt) {

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
            java.util.logging.Logger.getLogger(AddSubscriptionPlan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } 
        catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddSubscriptionPlan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } 
        catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddSubscriptionPlan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } 
        catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddSubscriptionPlan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        //Creating and displaying the form
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddSubscriptionPlan().setVisible(true);
            }
        });
    }

    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField planName;
    private javax.swing.JComboBox<String> providerName;
    private javax.swing.JComboBox<String> providerType;
}
