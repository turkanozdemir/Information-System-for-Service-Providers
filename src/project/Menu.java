package project;

import java.awt.Image;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.net.URL;

public class Menu extends javax.swing.JFrame{
	public Menu() {
        initComponents();
    }

    private void initComponents() {
        jMenuItem1 = new javax.swing.JMenuItem();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        
        Image image = null;
        try {
            image = ImageIO.read(new URL("https://cdn.backlinks.name/image.php?url=https://media.backlinks.name/contents/serif-ag-2018-12-30-02-47-00.jpg&width=900&height=450"));
        } 
        catch (IOException e) {
        	
        }
        jLabel1.setIcon(new javax.swing.ImageIcon(image)); 
        jLabel1.setText("jLabel1");

        jLabel2.setFont(new java.awt.Font("Trajan Pro", 0, 36)); 

        jLabel3.setFont(new java.awt.Font("Ariel", 0, 24)); 
        jLabel3.setText("Information System for Service Providers");
        
        try {
            image = ImageIO.read(new URL("https://cdn-icons-png.flaticon.com/512/760/760759.png"));
        } 
        catch (IOException e) {
        	
        }
        jMenu1.setIcon(new javax.swing.ImageIcon(image.getScaledInstance(40, 40, Image.SCALE_SMOOTH))); 
        jMenu1.setText("File");
        
        try {
            image = ImageIO.read(new URL("https://cdn-icons-png.flaticon.com/512/7479/7479439.png"));
        } 
        catch (IOException e) {
        	
        }
        jMenuItem2.setIcon(new javax.swing.ImageIcon(image.getScaledInstance(25, 25, Image.SCALE_SMOOTH)));
        jMenuItem2.setText("Exit");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);
        
        try {
            image = ImageIO.read(new URL("https://cdn-icons-png.flaticon.com/512/1828/1828817.png"));
        } 
        catch (IOException e) {
        	
        }
        jMenu2.setIcon(new javax.swing.ImageIcon(image.getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
        jMenu2.setText("Add");

        jMenuItem3.setText("Add GSM Provider");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evnt) {
                jMenuItem3ActionPerformed(evnt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuItem6.setText("Add Cable Provider");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evnt) {
                jMenuItem6ActionPerformed(evnt);
            }
        });
        jMenu2.add(jMenuItem6);

        jMenuItem4.setText("Add Subscription Plan");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evnt) {
                jMenuItem4ActionPerformed(evnt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuItem5.setText("Add Subscription");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evnt) {
                jMenuItem5ActionPerformed(evnt);
            }
        });
        jMenu2.add(jMenuItem5);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 618, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(336, 336, 336)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(165, 165, 165)
                        .addComponent(jLabel3)))
                .addContainerGap(99, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 59, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addComponent(jLabel1)
                .addGap(40, 40, 40))
        );
        pack();
    }
    
    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evnt) {
        System.exit(0);
    }

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evnt) {
        new AddGSMProvider().setVisible(true);
    }

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evnt) {
        new AddSubscriptionPlan().setVisible(true);
    }

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evnt) {
        new AddSubscription().setVisible(true);
    }

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evnt) {
        new AddCableProvider().setVisible(true);
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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } 
        catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } 
        catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } 
        catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        //Creating and displaying the form
		java.awt.EventQueue.invokeLater(new Runnable() {
	        public void run() {
	            new Menu().setVisible(true);
	        }
		});
}

    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
}