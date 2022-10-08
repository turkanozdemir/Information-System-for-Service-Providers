package project;

import java.io.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class AddGSMProvider extends javax.swing.JFrame{
	GSMProvider GsmProvider;
    ArrayList<GSMProvider> GsmProviderList;	    //to keep track of all previous GSM providers
    
    public AddGSMProvider() {
        initComponents();
        GsmProviderList = new ArrayList<GSMProvider>();
        populateArrayList();
    }
    
    //to read all previous GSM providers from the file GSM.dat
    public void populateArrayList(){
        try{
            FileInputStream file =  new FileInputStream("gsm.dat");
            ObjectInputStream inputFile = new ObjectInputStream(file);
            boolean EOF = false;
            
            while(!EOF){
                try{
                    GsmProviderList.add( (GSMProvider)inputFile.readObject());
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
    
    //to save all GSM Providers into GSM.dat
    public void saveTOFile(){
        try{
            FileOutputStream file= new FileOutputStream("gsm.dat");
            ObjectOutputStream outputFile =  new ObjectOutputStream(file);
            
            for(int i=0; i< GsmProviderList.size(); i++){
                outputFile.writeObject(GsmProviderList.get(i));
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        gsmProvider = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add Service Provider");

        jLabel1.setFont(new java.awt.Font("Perpetua Titling MT", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setText("Add a new GSM Provider");

        jLabel2.setText("Please enter the name of the GSM Provider");

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Submit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
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
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(gsmProvider, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(171, 171, 171)
                        .addComponent(jButton1)))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(gsmProvider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addComponent(jButton1)
                .addContainerGap(62, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }
    
    //when clicking Submit Button
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if( gsmProvider.getText().isEmpty()){ 
            JOptionPane.showMessageDialog(null,"Please enter the GSM provider name!");
        }
        else{
            boolean exists =  false;
            String name = gsmProvider.getText().trim();
            
            for(GSMProvider item : GsmProviderList){
            	//Checking existing GSM Provider
                if(item.getName().equals(name)){
                    JOptionPane.showMessageDialog(null,"This type already exists! Please enter a new one!");
                    exists = true;
                }
            }
            
            //new GSM Provider
            if (!exists){
                //We add a new GSM Provider to the list and we update the gsm.dat file
                GsmProvider = new GSMProvider(name);
                GsmProviderList.add(GsmProvider);
                saveTOFile();
            }
        }
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
            java.util.logging.Logger.getLogger(AddGSMProvider.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } 
        catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddGSMProvider.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } 
        catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddGSMProvider.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } 
        catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddGSMProvider.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        //Creating and displaying the form
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddGSMProvider().setVisible(true);
            }
        });
    }

    private javax.swing.JTextField gsmProvider;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
}
