/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tennissportsclubapp;

//import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
//import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author Tshegofatso
 */
public class frmRegister extends javax.swing.JFrame {

    /**
     * Creates new form frmRegister
     */
    public frmRegister() {
        initComponents();
        mLoadGUIControls();
    }
//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    CaesarsChiper clsCC= new CaesarsChiper();    
    
Boolean boolRecordExists=false; 
Boolean boolCreate=true; 
String strName;
String strUsername;
String strPassword;
String strRole;
String strContactNumber;
String strAddress;
String strNextOfKin;
String strSex;
String strDateOfBirth;
String strMembership;
String strPersonalTrainer;
String strTime;
int intMemberID; 
    
private void mClearVariables()
{

strName=""; 
strUsername="";
strPassword=""; 
strRole="";
strContactNumber="";
strAddress="";
strNextOfKin="";
strSex="";
strDateOfBirth="";
strMembership="";
strPersonalTrainer="";
strTime="";
intMemberID=0;
}    



private void mGetValuesFromGUI()
{
    
//Date date = new Date(dcDateOfBirth.getDate().getTime());
strName=txtName.getText(); 
strUsername=txtUsername.getText();
strPassword=txtDateOfBirth.getText(); 
strRole=cboRole.getSelectedItem().toString(); 
strContactNumber=txtContactNumber.getText();
strAddress=txtAddress.getText();
strNextOfKin=txtNextOfKin.getText();
strSex=cboSex.getSelectedItem().toString();
strDateOfBirth=txtDateOfBirth.getText();
//strDateOfBirth=sdf.format(dcDateOfBirth.getDate());
//strDateOfBirth = dcDateOfBirth.getDate().getTime();
strMembership=cboMembership.getSelectedItem().toString();
strPersonalTrainer=cboPersonalTrainer.getSelectedItem().toString();
strTime=txtTime.getText();
}


private void mLoadGUIControls()
{

cboRole.setEnabled(false);

}
    
private void mSetValuesToUpperCase()
{
strName=strName.toUpperCase();
strUsername=strUsername.toUpperCase();
strPassword=strPassword.toUpperCase(); 
strRole=strRole.toUpperCase();
strContactNumber=strContactNumber.toUpperCase();
strAddress=strAddress.toUpperCase();
strNextOfKin=strNextOfKin.toUpperCase();
strSex=strSex.toUpperCase();
strDateOfBirth=strDateOfBirth.toUpperCase();
strMembership=strMembership.toUpperCase();
strPersonalTrainer=strPersonalTrainer.toUpperCase();
strTime=strTime.toUpperCase();
}

private void mSetValuesInGUI()
{
txtName.setText(strName);
txtUsername.setText(strUsername);
txtDateOfBirth.setText(strPassword);
cboRole.setSelectedItem(strRole);
txtContactNumber.setText(strContactNumber);
txtAddress.setText(strAddress);
txtNextOfKin.setText(strNextOfKin);
cboSex.setSelectedItem(strSex);
txtDateOfBirth.setText(strDateOfBirth);
cboMembership.setSelectedItem(strMembership);
cboPersonalTrainer.setSelectedItem(strPersonalTrainer);
txtTime.setText(strTime);
}

private void mClearTextFields()
{ 
txtName.setText("");
txtUsername.setText("");
txtDateOfBirth.setText(""); 
cboRole.setSelectedItem("");
txtContactNumber.setText("");
txtAddress.setText("");
txtNextOfKin.setText("");
cboSex.setSelectedItem("");
txtDateOfBirth.setText("");
cboMembership.setSelectedItem("");
cboPersonalTrainer.setSelectedItem("");
txtTime.setText("");

}

private void mLoadName()
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
String strQuery = " Select MemberName from Members"; 
stStatement.execute(strQuery); 
rs=stStatement.getResultSet();

while(rs.next())
{
txtName.setText(rs.getString(1));
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

private void mcheckIfltemsExistInTabIe()
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
String strQuery = " Select * from Members where MemberName='" + strName +"' and Username='" + strUsername +"' and UsernamePassword='" + strPassword +"' and Role='" + strRole +"' and ContactNumber='" + strContactNumber +"' and Address='" + strAddress +"' and NextOfKin='" + strNextOfKin +"' and Sex='" + strSex +"' and DateOfBirth='" + strDateOfBirth +"' and Membership='" + strMembership +"' and PersonalTrainer='" + strPersonalTrainer +"' and TimeSelected='" + strTime +"' ";
stStatement.execute(strQuery); 
rs=stStatement.getResultSet(); 
boolRecordExists=rs.next();
}
catch (Exception e) 
{
JOptionPane.showMessageDialog(null,e);
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

private void mCreateMember()
{
java.sql.Connection conMySQLConnectionString= null; 
String URL= "jdbc:mysql://localhost:3306/tennissportsclubapp"; 
String User="root"; 
String Password="Password"; 
try
{
conMySQLConnectionString=DriverManager.getConnection(URL,User,Password); 
Statement myStatement =conMySQLConnectionString.createStatement();
String sqlinsert = "insert into Members  " + " (MemberName, Username, UsernamePassword, Role, ContactNumber, Address, NextOfKin, Sex, DateOfBirth, Membership, PersonalTrainer, TimeSelected) "+" values ('"+ strName +"', '"+ strUsername +"', '"+ strPassword +"','"+ strRole +"', '"+ strContactNumber +"', '"+ strAddress +"', '"+ strNextOfKin +"', '"+ strSex +"', '"+ strDateOfBirth +"', '"+ strMembership +"', '"+ strPersonalTrainer +"', '"+ strTime +"')";
myStatement.executeUpdate(sqlinsert); 
myStatement.close(); 
JOptionPane.showMessageDialog(null,"Complete");
}
catch (Exception e)
        {
JOptionPane.showMessageDialog(null, e); 
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

        jpBackground = new javax.swing.JPanel();
        jpTitle = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        txtDateOfBirth = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        txtContactNumber = new javax.swing.JTextField();
        jspAddress = new javax.swing.JScrollPane();
        txtAddress = new javax.swing.JTextArea();
        lblPassword = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        lblRole = new javax.swing.JLabel();
        lblAddress = new javax.swing.JLabel();
        lblContactNumber = new javax.swing.JLabel();
        lblUsername = new javax.swing.JLabel();
        txtNextOfKin = new javax.swing.JTextField();
        lblNextOfKin = new javax.swing.JLabel();
        lblSex = new javax.swing.JLabel();
        lblDateOfBirth = new javax.swing.JLabel();
        lblMembership = new javax.swing.JLabel();
        lblPersonalTrainerWanted = new javax.swing.JLabel();
        lblTime = new javax.swing.JLabel();
        txtTime = new javax.swing.JTextField();
        cboMembership = new javax.swing.JComboBox<>();
        cboRole = new javax.swing.JComboBox<>();
        cboSex = new javax.swing.JComboBox<>();
        cboPersonalTrainer = new javax.swing.JComboBox<>();
        btnExit = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        txtPassword1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Registration Form");

        jpBackground.setBackground(new java.awt.Color(255, 255, 255));
        jpBackground.setLayout(null);

        jpTitle.setBackground(new java.awt.Color(0, 204, 0));

        lblTitle.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Registration Form");
        lblTitle.setToolTipText("");

        javax.swing.GroupLayout jpTitleLayout = new javax.swing.GroupLayout(jpTitle);
        jpTitle.setLayout(jpTitleLayout);
        jpTitleLayout.setHorizontalGroup(
            jpTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpTitleLayout.createSequentialGroup()
                .addGap(230, 230, 230)
                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(241, Short.MAX_VALUE))
        );
        jpTitleLayout.setVerticalGroup(
            jpTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        jpBackground.add(jpTitle);
        jpTitle.setBounds(0, 0, 750, 50);

        txtUsername.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        txtUsername.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        jpBackground.add(txtUsername);
        txtUsername.setBounds(30, 170, 300, 30);

        txtDateOfBirth.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        txtDateOfBirth.setToolTipText("YYYY-MM-DD");
        txtDateOfBirth.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        jpBackground.add(txtDateOfBirth);
        txtDateOfBirth.setBounds(420, 240, 300, 30);

        txtName.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        txtName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });
        jpBackground.add(txtName);
        txtName.setBounds(30, 100, 300, 30);

        txtContactNumber.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        txtContactNumber.setToolTipText("");
        txtContactNumber.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        jpBackground.add(txtContactNumber);
        txtContactNumber.setBounds(30, 380, 300, 30);

        jspAddress.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));

        txtAddress.setColumns(10);
        txtAddress.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        txtAddress.setRows(5);
        jspAddress.setViewportView(txtAddress);

        jpBackground.add(jspAddress);
        jspAddress.setBounds(30, 450, 300, 110);

        lblPassword.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        lblPassword.setText("Password");
        jpBackground.add(lblPassword);
        lblPassword.setBounds(30, 210, 53, 20);

        lblName.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        lblName.setText("Name");
        jpBackground.add(lblName);
        lblName.setBounds(30, 70, 60, 20);

        lblRole.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        lblRole.setText("Role");
        jpBackground.add(lblRole);
        lblRole.setBounds(30, 280, 25, 20);

        lblAddress.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        lblAddress.setText("Address");
        jpBackground.add(lblAddress);
        lblAddress.setBounds(30, 420, 57, 20);

        lblContactNumber.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        lblContactNumber.setText("Contact No");
        jpBackground.add(lblContactNumber);
        lblContactNumber.setBounds(30, 350, 90, 20);

        lblUsername.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        lblUsername.setText("Username");
        jpBackground.add(lblUsername);
        lblUsername.setBounds(30, 140, 90, 20);

        txtNextOfKin.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        txtNextOfKin.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        txtNextOfKin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNextOfKinActionPerformed(evt);
            }
        });
        jpBackground.add(txtNextOfKin);
        txtNextOfKin.setBounds(420, 100, 300, 30);

        lblNextOfKin.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        lblNextOfKin.setText("Next Of Kin");
        jpBackground.add(lblNextOfKin);
        lblNextOfKin.setBounds(420, 70, 90, 20);

        lblSex.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        lblSex.setText("Sex");
        jpBackground.add(lblSex);
        lblSex.setBounds(420, 140, 60, 20);

        lblDateOfBirth.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        lblDateOfBirth.setText("Date Of Birth");
        jpBackground.add(lblDateOfBirth);
        lblDateOfBirth.setBounds(420, 210, 110, 20);

        lblMembership.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        lblMembership.setText("Membership");
        jpBackground.add(lblMembership);
        lblMembership.setBounds(420, 280, 110, 20);

        lblPersonalTrainerWanted.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        lblPersonalTrainerWanted.setText("Would you like to receive a personal trainer?  ");
        jpBackground.add(lblPersonalTrainerWanted);
        lblPersonalTrainerWanted.setBounds(420, 350, 260, 20);

        lblTime.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        lblTime.setText("Time");
        jpBackground.add(lblTime);
        lblTime.setBounds(420, 420, 110, 20);

        txtTime.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        txtTime.setToolTipText("HH:mm");
        txtTime.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        txtTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimeActionPerformed(evt);
            }
        });
        jpBackground.add(txtTime);
        txtTime.setBounds(420, 450, 300, 30);

        cboMembership.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        cboMembership.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Junior", "Beginner", "Advanced", "Professional" }));
        jpBackground.add(cboMembership);
        cboMembership.setBounds(420, 310, 300, 30);

        cboRole.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        cboRole.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "STANDARD", "SUPERVISOR", "ADMIN" }));
        jpBackground.add(cboRole);
        cboRole.setBounds(30, 310, 300, 30);

        cboSex.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        cboSex.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Female", "Male" }));
        jpBackground.add(cboSex);
        cboSex.setBounds(420, 170, 300, 30);

        cboPersonalTrainer.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No", "Yes" }));
        jpBackground.add(cboPersonalTrainer);
        cboPersonalTrainer.setBounds(420, 380, 300, 30);

        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        jpBackground.add(btnExit);
        btnExit.setBounds(30, 580, 70, 23);

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        jpBackground.add(btnSave);
        btnSave.setBounds(650, 580, 70, 23);

        txtPassword1.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        txtPassword1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        jpBackground.add(txtPassword1);
        txtPassword1.setBounds(30, 240, 300, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpBackground, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpBackground, javax.swing.GroupLayout.DEFAULT_SIZE, 620, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameActionPerformed

    private void txtNextOfKinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNextOfKinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNextOfKinActionPerformed

    private void txtTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimeActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // TODO add your handling code here:
        setVisible(false);
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:

        if(boolCreate==true)
        {
            if(txtName.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null,"Please provide your Name.");
                txtName.requestFocusInWindow();
            }
            if(txtContactNumber.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null,"Please provide Contact Number.");
                txtContactNumber.requestFocusInWindow();
            }

            if(txtDateOfBirth.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null,"Please provide Date Of Birth.");
                txtContactNumber.requestFocusInWindow();
            }

            if(cboPersonalTrainer.getSelectedItem()==("Yes") && txtTime.getText().equals(""))
            {

                JOptionPane.showMessageDialog(null,"Please provide personal trainer time.");
                txtTime.requestFocusInWindow();
            }

            else
            {
                mGetValuesFromGUI();
                mSetValuesToUpperCase();
                mcheckIfltemsExistInTabIe();
                if(boolRecordExists==true)
                {
                    boolRecordExists=false;
                    JOptionPane.showMessageDialog(null, "Member already Exists");
                }
                else if(boolRecordExists==false)
                {
                    boolCreate=false;
                    mCreateMember();
                    mClearTextFields();
                    mClearVariables();
                    mLoadName();
                    mLoadGUIControls();
                   
                   
             
                }
            }
        }
    }//GEN-LAST:event_btnSaveActionPerformed


    
    
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
            java.util.logging.Logger.getLogger(frmRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmRegister().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cboMembership;
    private javax.swing.JComboBox<String> cboPersonalTrainer;
    private javax.swing.JComboBox<String> cboRole;
    private javax.swing.JComboBox<String> cboSex;
    private javax.swing.JPanel jpBackground;
    private javax.swing.JPanel jpTitle;
    private javax.swing.JScrollPane jspAddress;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblContactNumber;
    private javax.swing.JLabel lblDateOfBirth;
    private javax.swing.JLabel lblMembership;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblNextOfKin;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblPersonalTrainerWanted;
    private javax.swing.JLabel lblRole;
    private javax.swing.JLabel lblSex;
    private javax.swing.JLabel lblTime;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JTextArea txtAddress;
    private javax.swing.JTextField txtContactNumber;
    private javax.swing.JTextField txtDateOfBirth;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtNextOfKin;
    private javax.swing.JTextField txtPassword1;
    private javax.swing.JTextField txtTime;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
