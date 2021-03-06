/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tennissportsclubapp;
import tennissportsclubapp.viewmembers.frmBirthDays;
import tennissportsclubapp.viewmembers.frmClubs;
import tennissportsclubapp.viewmembers.frmTrainer;
import tennissportsclubapp.viewmembers.frmNoTrainer;


/**
 *
 * @author TXG
 */
public class frmMain extends javax.swing.JFrame {

    /**
     * Creates new form frmMain
     */
    public frmMain() {
        initComponents();
    }

    public String strRole;
    
    public void mSetRoleRights()
    {
if(null!= strRole) 
{
switch (strRole) 
{ 
case "ADMIN": 
mnuLogoff.setEnabled(true); 
mnuExit.setEnabled(true); 
mnuMemberProfile.setEnabled(true);
mnuModifyMembers.setEnabled(true); 
mnuUsers.setEnabled(true); 
mnuViewMembers.setEnabled(true);
mnuBirthDays.setEnabled(true);
mnuClubs.setEnabled(true);
mnuTrainer.setEnabled(true);
mnuNoTrainer.setEnabled(true);
break; 
case "SUPERVISOR": 
mnuLogoff.setEnabled(true); 
mnuExit.setEnabled(true); 
mnuMemberProfile.setEnabled(true); 
mnuModifyMembers.setEnabled(true); 
mnuUsers.setEnabled(false); 
mnuViewMembers.setEnabled(true);
mnuBirthDays.setEnabled(true);
mnuClubs.setEnabled(true);
mnuTrainer.setEnabled(true);
mnuNoTrainer.setEnabled(true);
break; 
case "STANDARD": 
mnuLogoff.setEnabled(true); 
mnuExit.setEnabled(true); 
mnuMemberProfile.setEnabled(true);
mnuModifyMembers.setEnabled(false); 
mnuUsers.setEnabled(false); 
mnuViewMembers.setEnabled(false);
mnuBirthDays.setEnabled(false);
mnuClubs.setEnabled(false);
mnuTrainer.setEnabled(false);
mnuNoTrainer.setEnabled(false);
break; 
default: 
break;
}
}
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dpMain = new javax.swing.JDesktopPane();
        mnuMenuBar = new javax.swing.JMenuBar();
        mnuFile = new javax.swing.JMenu();
        mnuLogoff = new javax.swing.JMenuItem();
        mnuExit = new javax.swing.JMenuItem();
        mnuForms = new javax.swing.JMenu();
        mnuMemberProfile = new javax.swing.JMenuItem();
        mnuModifyMembers = new javax.swing.JMenuItem();
        mnuViewMembers = new javax.swing.JMenuItem();
        mnuUsers = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        mnuBirthDays = new javax.swing.JMenuItem();
        mnuClubs = new javax.swing.JMenuItem();
        mnuTrainer = new javax.swing.JMenuItem();
        mnuNoTrainer = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Main");

        dpMain.setPreferredSize(new java.awt.Dimension(500, 500));

        javax.swing.GroupLayout dpMainLayout = new javax.swing.GroupLayout(dpMain);
        dpMain.setLayout(dpMainLayout);
        dpMainLayout.setHorizontalGroup(
            dpMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );
        dpMainLayout.setVerticalGroup(
            dpMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 479, Short.MAX_VALUE)
        );

        mnuFile.setText("File");

        mnuLogoff.setText("Logoff");
        mnuLogoff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuLogoffActionPerformed(evt);
            }
        });
        mnuFile.add(mnuLogoff);

        mnuExit.setText("Exit");
        mnuExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuExitActionPerformed(evt);
            }
        });
        mnuFile.add(mnuExit);

        mnuMenuBar.add(mnuFile);

        mnuForms.setText("Forms");

        mnuMemberProfile.setText("Member Profile");
        mnuMemberProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuMemberProfileActionPerformed(evt);
            }
        });
        mnuForms.add(mnuMemberProfile);

        mnuModifyMembers.setText("Modify Members");
        mnuModifyMembers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuModifyMembersActionPerformed(evt);
            }
        });
        mnuForms.add(mnuModifyMembers);

        mnuViewMembers.setText("View Members");
        mnuViewMembers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuViewMembersActionPerformed(evt);
            }
        });
        mnuForms.add(mnuViewMembers);

        mnuUsers.setText("Users");
        mnuUsers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuUsersActionPerformed(evt);
            }
        });
        mnuForms.add(mnuUsers);

        mnuMenuBar.add(mnuForms);

        jMenu1.setText("Reports");

        mnuBirthDays.setText("Members with birthdays this week");
        mnuBirthDays.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuBirthDaysActionPerformed(evt);
            }
        });
        jMenu1.add(mnuBirthDays);

        mnuClubs.setText("No. of members in each club");
        mnuClubs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuClubsActionPerformed(evt);
            }
        });
        jMenu1.add(mnuClubs);

        mnuTrainer.setText("Members with Personal Trainer’s");
        mnuTrainer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuTrainerActionPerformed(evt);
            }
        });
        jMenu1.add(mnuTrainer);

        mnuNoTrainer.setText("Members without Personal Trainer’s");
        mnuNoTrainer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuNoTrainerActionPerformed(evt);
            }
        });
        jMenu1.add(mnuNoTrainer);

        mnuMenuBar.add(jMenu1);

        setJMenuBar(mnuMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dpMain, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dpMain, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnuExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuExitActionPerformed
        // TODO add your handling code here:
        System.exit(0);
        
        
    }//GEN-LAST:event_mnuExitActionPerformed

    private void mnuLogoffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuLogoffActionPerformed
        // TODO add your handling code here:
        
         frmLogin frmL = new frmLogin();
       frmL.setVisible(true);
       this.setVisible(false);
        
    }//GEN-LAST:event_mnuLogoffActionPerformed

    private void mnuViewMembersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuViewMembersActionPerformed
        // TODO add your handling code here:
        frmViewMembers frmVMB = new frmViewMembers();
      dpMain.add(frmVMB);
       frmVMB.setVisible(true);
        
    }//GEN-LAST:event_mnuViewMembersActionPerformed

    private void mnuModifyMembersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuModifyMembersActionPerformed
        // TODO add your handling code here:
        
        frmModifyMembers frmMB = new frmModifyMembers();
      dpMain.add(frmMB);
       frmMB.setVisible(true);
    }//GEN-LAST:event_mnuModifyMembersActionPerformed

    private void mnuMemberProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuMemberProfileActionPerformed
        // TODO add your handling code here:
        
         frmMemberProfile frmMP = new frmMemberProfile();
      dpMain.add(frmMP);
       frmMP.setVisible(true);
    }//GEN-LAST:event_mnuMemberProfileActionPerformed

    private void mnuUsersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuUsersActionPerformed
        // TODO add your handling code here:
        
         frmUsers frmU = new frmUsers();
      dpMain.add(frmU);
       frmU.setVisible(true);
    }//GEN-LAST:event_mnuUsersActionPerformed

    private void mnuBirthDaysActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuBirthDaysActionPerformed
        // TODO add your handling code here:
        
        frmBirthDays frmBD = new frmBirthDays();
      dpMain.add(frmBD);
       frmBD.setVisible(true);
    }//GEN-LAST:event_mnuBirthDaysActionPerformed

    private void mnuClubsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuClubsActionPerformed
        // TODO add your handling code here:
        
          frmClubs frmC = new frmClubs();
      dpMain.add(frmC);
       frmC.setVisible(true);
    }//GEN-LAST:event_mnuClubsActionPerformed

    private void mnuTrainerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuTrainerActionPerformed
        // TODO add your handling code here:
        
          frmTrainer frmT = new frmTrainer();
      dpMain.add(frmT);
       frmT.setVisible(true);
    }//GEN-LAST:event_mnuTrainerActionPerformed

    private void mnuNoTrainerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuNoTrainerActionPerformed
        // TODO add your handling code here:
          frmNoTrainer frmNT = new frmNoTrainer();
      dpMain.add(frmNT);
       frmNT.setVisible(true);
    }//GEN-LAST:event_mnuNoTrainerActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane dpMain;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem mnuBirthDays;
    private javax.swing.JMenuItem mnuClubs;
    private javax.swing.JMenuItem mnuExit;
    private javax.swing.JMenu mnuFile;
    private javax.swing.JMenu mnuForms;
    private javax.swing.JMenuItem mnuLogoff;
    private javax.swing.JMenuItem mnuMemberProfile;
    private javax.swing.JMenuBar mnuMenuBar;
    private javax.swing.JMenuItem mnuModifyMembers;
    private javax.swing.JMenuItem mnuNoTrainer;
    private javax.swing.JMenuItem mnuTrainer;
    private javax.swing.JMenuItem mnuUsers;
    private javax.swing.JMenuItem mnuViewMembers;
    // End of variables declaration//GEN-END:variables
}
