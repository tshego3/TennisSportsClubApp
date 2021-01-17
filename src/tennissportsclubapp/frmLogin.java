/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tennissportsclubapp;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;


/**
 *
 * @author TXG
 */
public class frmLogin extends javax.swing.JFrame {

    /**
     * Creates new form frmLogin
     */
    public frmLogin() {
        initComponents();
    }

String strUsername;
String strPassword;
String strRole;

CaesarsChiper clsCC= new CaesarsChiper();

private void mFetchMemberDetails()
{
String strDBConnectionString="jdbc:mysql://localhost:3306/tennissportsclubapp"; 
String strDBUser="root"; 
String strDBPassword="Password";
java.sql.Connection conMySQLConnectionString;
Statement stStatement=null; 
ResultSet rs= null;  

try
{
conMySQLConnectionString=DriverManager.getConnection(strDBConnectionString,strDBUser,strDBPassword);
stStatement = conMySQLConnectionString.createStatement(); 
String strQuery = "Select ID,Username,UsernamePassword,Role from Users where Username = '"+ txtPassword.getText().toUpperCase()+"'";
stStatement.execute(strQuery); 
rs=stStatement.getResultSet();

while(rs.next())
{
strUsername=rs.getString(2); 
strPassword=rs.getString(3); 
strRole =rs.getString(4);  

}
}
catch(Exception e) 
{
JOptionPane.showMessageDialog(null, e); 
}
finally 
{
try 
{
stStatement.close(); 
}
catch (Exception e) 
{  
JOptionPane.showMessageDialog(null,"Connection String not Closed"+""+e);
}
}
}
    
private void mEncryptPassword()
{
    strPassword=clsCC.mEncrypt(txtPassword.getText().toUpperCase(), 5);
}

private void mDecryptPassword()
{
    strPassword=clsCC.mDecrypt(strPassword.toLowerCase(), 5);
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */                                                                                   
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpBackground = new javax.swing.JPanel();
        jpAppTitle = new javax.swing.JPanel();
        lblUserIcon = new javax.swing.JLabel();
        lblTSC = new javax.swing.JLabel();
        lblML = new javax.swing.JLabel();
        jpExit = new javax.swing.JPanel();
        lblX = new javax.swing.JLabel();
        lblLogin = new javax.swing.JLabel();
        lblUsername = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        txtUsername3 = new javax.swing.JTextField();
        lblUsername3 = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        lblCreateAccount = new javax.swing.JLabel();
        jpLogin = new javax.swing.JPanel();
        lblLoginBTN = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setUndecorated(true);
        setResizable(false);

        jpBackground.setBackground(new java.awt.Color(255, 255, 255));
        jpBackground.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jpBackground.setLayout(null);

        jpAppTitle.setBackground(new java.awt.Color(0, 204, 0));
        jpAppTitle.setPreferredSize(new java.awt.Dimension(300, 501));

        lblUserIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUserIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tennissportsclubapp/app-icons/user.png"))); // NOI18N
        lblUserIcon.setToolTipText("");

        lblTSC.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        lblTSC.setForeground(new java.awt.Color(255, 255, 255));
        lblTSC.setText("Tennis Sports Club");

        lblML.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        lblML.setForeground(new java.awt.Color(255, 255, 255));
        lblML.setText("Members Login");
        lblML.setToolTipText("");

        javax.swing.GroupLayout jpAppTitleLayout = new javax.swing.GroupLayout(jpAppTitle);
        jpAppTitle.setLayout(jpAppTitleLayout);
        jpAppTitleLayout.setHorizontalGroup(
            jpAppTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpAppTitleLayout.createSequentialGroup()
                .addGroup(jpAppTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpAppTitleLayout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(lblUserIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpAppTitleLayout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(lblTSC))
                    .addGroup(jpAppTitleLayout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(lblML)))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        jpAppTitleLayout.setVerticalGroup(
            jpAppTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpAppTitleLayout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addComponent(lblUserIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTSC)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblML)
                .addContainerGap(176, Short.MAX_VALUE))
        );

        jpBackground.add(jpAppTitle);
        jpAppTitle.setBounds(0, 0, 300, 501);

        jpExit.setBackground(new java.awt.Color(0, 204, 0));
        jpExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jpExitMousePressed(evt);
            }
        });

        lblX.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        lblX.setForeground(new java.awt.Color(255, 255, 255));
        lblX.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblX.setText("X");

        javax.swing.GroupLayout jpExitLayout = new javax.swing.GroupLayout(jpExit);
        jpExit.setLayout(jpExitLayout);
        jpExitLayout.setHorizontalGroup(
            jpExitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpExitLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblX, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jpExitLayout.setVerticalGroup(
            jpExitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblX, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        jpBackground.add(jpExit);
        jpExit.setBounds(564, 0, 36, 36);

        lblLogin.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        lblLogin.setForeground(new java.awt.Color(102, 102, 102));
        lblLogin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLogin.setText("Login");
        jpBackground.add(lblLogin);
        lblLogin.setBounds(380, 40, 130, 80);

        lblUsername.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        lblUsername.setText("Username");
        jpBackground.add(lblUsername);
        lblUsername.setBounds(330, 123, 90, 30);

        txtUsername.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtUsername.setForeground(new java.awt.Color(51, 51, 51));
        txtUsername.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtUsername.setToolTipText("");
        txtUsername.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        jpBackground.add(txtUsername);
        txtUsername.setBounds(330, 160, 240, 40);

        txtUsername3.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtUsername3.setForeground(new java.awt.Color(51, 51, 51));
        txtUsername3.setToolTipText("");
        txtUsername3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        jpBackground.add(txtUsername3);
        txtUsername3.setBounds(330, 160, 240, 40);

        lblUsername3.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        lblUsername3.setText("Username");
        jpBackground.add(lblUsername3);
        lblUsername3.setBounds(330, 123, 90, 30);

        lblPassword.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        lblPassword.setText("Password");
        jpBackground.add(lblPassword);
        lblPassword.setBounds(330, 230, 90, 30);

        txtPassword.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtPassword.setForeground(new java.awt.Color(51, 51, 51));
        txtPassword.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPassword.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        jpBackground.add(txtPassword);
        txtPassword.setBounds(330, 270, 240, 40);

        lblCreateAccount.setFont(new java.awt.Font("Calibri", 0, 13)); // NOI18N
        lblCreateAccount.setForeground(new java.awt.Color(0, 102, 204));
        lblCreateAccount.setText("Not a member? Click here to create account.");
        lblCreateAccount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblCreateAccountMousePressed(evt);
            }
        });
        jpBackground.add(lblCreateAccount);
        lblCreateAccount.setBounds(330, 410, 240, 17);

        jpLogin.setBackground(new java.awt.Color(0, 204, 0));
        jpLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jpLoginMousePressed(evt);
            }
        });

        lblLoginBTN.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        lblLoginBTN.setForeground(new java.awt.Color(255, 255, 255));
        lblLoginBTN.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLoginBTN.setText("Login");

        javax.swing.GroupLayout jpLoginLayout = new javax.swing.GroupLayout(jpLogin);
        jpLogin.setLayout(jpLoginLayout);
        jpLoginLayout.setHorizontalGroup(
            jpLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblLoginBTN, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
        );
        jpLoginLayout.setVerticalGroup(
            jpLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblLoginBTN, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jpBackground.add(jpLogin);
        jpLogin.setBounds(390, 360, 120, 40);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpBackground, javax.swing.GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(600, 501));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jpExitMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpExitMousePressed
        // TODO add your handling code here:
        
        System.exit(0);
    }//GEN-LAST:event_jpExitMousePressed

    private void jpLoginMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpLoginMousePressed
        // TODO add your handling code here:
        
        frmMain frmM = new frmMain();
        if(txtUsername.getText().equals("admin") && txtPassword.getText().equals("admin"))
        {
            frmM.strRole = "ADMIN";
            frmM.mSetRoleRights();
            frmM.setVisible(true);
            this.setVisible(false);
            frmM.setExtendedState(MAXIMIZED_BOTH);
        }
        else
        mEncryptPassword();
        mFetchMemberDetails();
        mDecryptPassword();
        if(txtUsername.getText().toUpperCase().equals(strUsername)&& txtPassword.getText().toUpperCase().equals(strPassword.toUpperCase()))
        {
            frmM.strRole = strRole;
            frmM.mSetRoleRights();
            frmM.setVisible(true);
            this.setVisible(false);
            frmM.setExtendedState(MAXIMIZED_BOTH);
        }
        else
        {
            javax.swing.JOptionPane.showMessageDialog(null,"Check Username and Password");
        }
        
    }//GEN-LAST:event_jpLoginMousePressed

    private void lblCreateAccountMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCreateAccountMousePressed
        // TODO add your handling code here:
        
        frmRegister frmR = new frmRegister();

        frmR.setVisible(true);
        
    }//GEN-LAST:event_lblCreateAccountMousePressed

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
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jpAppTitle;
    private javax.swing.JPanel jpBackground;
    private javax.swing.JPanel jpExit;
    private javax.swing.JPanel jpLogin;
    private javax.swing.JLabel lblCreateAccount;
    private javax.swing.JLabel lblLogin;
    private javax.swing.JLabel lblLoginBTN;
    private javax.swing.JLabel lblML;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblTSC;
    private javax.swing.JLabel lblUserIcon;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JLabel lblUsername3;
    private javax.swing.JLabel lblX;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    private javax.swing.JTextField txtUsername3;
    // End of variables declaration//GEN-END:variables
}