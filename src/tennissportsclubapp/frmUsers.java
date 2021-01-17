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
 * @author Tshegofatso
 */
public class frmUsers extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmUsers
     */
    public frmUsers() {
        initComponents();
        mLoadUsername();
        mLoadGUIControls();
    }
    
    CaesarsChiper clsCC= new CaesarsChiper(); 
    
Boolean boolRecordExists=false; 
Boolean boolEdit=false; 
Boolean boolCreate=false; 
String strUsername;
String strPassword;
String strRole;
int intUserID; 
    
private void mClearVariables()
{

strUsername="";
strPassword="";
strRole="";
intUserID=0;
}    
    
private void mGetValuesFromGUI()
{
strUsername=txtUsername.getText();
strPassword=txtPassword.getText();
strRole=txtRole.getText();
}

private void mSetValuesToUpperCase()
{
strUsername=strUsername.toUpperCase();
strPassword=strPassword.toUpperCase();
strRole=strRole.toUpperCase();
}

private void mSetValuesInGUI()
{
txtUsername.setText(strUsername);
txtPassword.setText(strPassword);
txtRole.setText(strRole);
}

private void mClearTextFields()
{
txtUsername.setText("");
txtPassword.setText("");
txtRole.setText("");
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
String strQuery = " Select * from users where Username='" + strUsername + "' and UsernamePassword='" + strPassword +"'";
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

private void mCreateUser()
{
java.sql.Connection conMySQLConnectionString= null; 
String URL= "jdbc:mysql://localhost:3306/tennissportsclubapp"; 
String User="root"; 
String Password="Password"; 
try
{
conMySQLConnectionString=DriverManager.getConnection(URL,User,Password); 
Statement myStatement =conMySQLConnectionString.createStatement();
String sqlinsert = " insert into Users " + " (Username, UsernamePassword, Role) "+" values('"+ strUsername +"', '"+ strPassword +"', '"+ strRole +"') ";
myStatement.executeUpdate(sqlinsert); 
myStatement.close(); 
JOptionPane.showMessageDialog(null,"Complete");
}
catch (Exception e)
        {
JOptionPane.showMessageDialog(null, e); 
        }
}

private void mLoadUsername()
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
String strQuery = "Select Username from Users"; 
stStatement.execute(strQuery); 
rs=stStatement.getResultSet();

while(rs.next())
{
cboUsername.addItem(rs.getString(1));
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

private void mUpdateUser()
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
String strQuery = " UPDATE Users SET Username='" + strUsername +"', UsernamePassword='" + strPassword +"', Role='" + strRole +"' WHERE ID = "+ intUserID;  
 
stStatement.execute(strQuery); 
rs=stStatement.getResultSet();
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

private void mClearComboBox()
{
String[] arrArray = new String[0]; 
javax.swing.DefaultComboBoxModel model = new javax.swing.DefaultComboBoxModel(arrArray); 
cboUsername.setModel(model);
}

private void mDeleteUser()
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
String strQuery = " Delete from Users where Username ='" + strUsername +"' and UsernamePassword='" + strPassword +"' and Role='" + strRole +"' and ID = "+ intUserID; 
 
stStatement.execute(strQuery); 
rs=stStatement.getResultSet();
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

private void mReadUserDetails()
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
String strQuery = " Select ID,Username,UsernamePassword,Role from Users where Username ='"+ cboUsername.getSelectedItem().toString()+"'";
stStatement.execute(strQuery); 
rs=stStatement.getResultSet();

while(rs.next())
{
intUserID=rs.getInt(1); 
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

private void mLoadGUIControls()
{
txtUsername.setEnabled(false);
txtPassword.setEnabled(false);
txtRole.setEnabled(false);
cboUsername.setEnabled(true); 
btnCreate.setEnabled(true); 
btnLoad.setEnabled(true); 
btnEdit.setEnabled(true); 
btnSave.setEnabled(false); 
btnDelete.setEnabled(true);
}

private void mEditGUIControls()
{
txtUsername.setEnabled(true);
txtPassword.setEnabled(true);
txtRole.setEnabled(true);
cboUsername.setEnabled(false); 
btnCreate.setEnabled(false); 
btnLoad.setEnabled(false); 
btnEdit.setEnabled(false); 
btnSave.setEnabled(true); 
btnDelete.setEnabled(true);
}

private void mSaveGUIControls()
{
txtUsername.setEnabled(false);
txtPassword.setEnabled(false);
txtRole.setEnabled(false);
cboUsername.setEnabled(true); 
btnCreate.setEnabled(true); 
btnLoad.setEnabled(true); 
btnEdit.setEnabled(true); 
btnSave.setEnabled(false); 
btnDelete.setEnabled(false);
}

private void mCreateGUIControls()
{
txtUsername.setEnabled(true);
txtPassword.setEnabled(true);
txtRole.setEnabled(true);
cboUsername.setEnabled(false); 
btnCreate.setEnabled(false); 
btnLoad.setEnabled(false); 
btnEdit.setEnabled(false); 
btnSave.setEnabled(true); 
btnDelete.setEnabled(true);
}

private void mDeleteGUIControls()
{
txtUsername.setEnabled(false);
txtPassword.setEnabled(false);
txtRole.setEnabled(false);
cboUsername.setEnabled(true); 
btnCreate.setEnabled(true); 
btnLoad.setEnabled(true); 
btnEdit.setEnabled(true); 
btnSave.setEnabled(false); 
btnDelete.setEnabled(false);
}

private void mEncryptPassword()
{
    strPassword=clsCC.mEncrypt(strPassword, 5);
}

private void mDecryptPassword()
{
    strPassword=clsCC.mDecrypt(strPassword, 5);
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
        btnSave = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnLoad = new javax.swing.JButton();
        txtRole = new javax.swing.JTextField();
        lblRole = new javax.swing.JLabel();
        cboUsername = new javax.swing.JComboBox<>();
        txtUsername = new javax.swing.JTextField();
        txtPassword = new javax.swing.JTextField();
        lblUsername = new javax.swing.JLabel();
        btnExit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        lblPassword = new javax.swing.JLabel();
        btnCreate = new javax.swing.JButton();

        setTitle("Users");

        jpBackground.setBackground(new java.awt.Color(255, 255, 255));
        jpBackground.setLayout(null);

        jpTitle.setBackground(new java.awt.Color(0, 204, 0));

        lblTitle.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Users");
        lblTitle.setToolTipText("");

        javax.swing.GroupLayout jpTitleLayout = new javax.swing.GroupLayout(jpTitle);
        jpTitle.setLayout(jpTitleLayout);
        jpTitleLayout.setHorizontalGroup(
            jpTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpTitleLayout.createSequentialGroup()
                .addGap(289, 289, 289)
                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(292, Short.MAX_VALUE))
        );
        jpTitleLayout.setVerticalGroup(
            jpTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        jpBackground.add(jpTitle);
        jpTitle.setBounds(0, 0, 750, 50);

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        jpBackground.add(btnSave);
        btnSave.setBounds(580, 360, 90, 30);

        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        jpBackground.add(btnEdit);
        btnEdit.setBounds(580, 190, 90, 30);

        btnLoad.setText("Load");
        btnLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadActionPerformed(evt);
            }
        });
        jpBackground.add(btnLoad);
        btnLoad.setBounds(580, 140, 90, 30);

        txtRole.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        txtRole.setForeground(new java.awt.Color(0, 0, 0));
        txtRole.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        jpBackground.add(txtRole);
        txtRole.setBounds(150, 240, 330, 30);

        lblRole.setBackground(new java.awt.Color(0, 0, 0));
        lblRole.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        lblRole.setForeground(new java.awt.Color(0, 0, 0));
        lblRole.setText("Role:");
        jpBackground.add(lblRole);
        lblRole.setBounds(70, 240, 40, 30);

        cboUsername.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        cboUsername.setForeground(new java.awt.Color(0, 0, 0));
        jpBackground.add(cboUsername);
        cboUsername.setBounds(70, 90, 410, 30);

        txtUsername.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        txtUsername.setForeground(new java.awt.Color(0, 0, 0));
        txtUsername.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        jpBackground.add(txtUsername);
        txtUsername.setBounds(150, 140, 330, 30);

        txtPassword.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        txtPassword.setForeground(new java.awt.Color(0, 0, 0));
        txtPassword.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });
        jpBackground.add(txtPassword);
        txtPassword.setBounds(150, 190, 330, 30);

        lblUsername.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        lblUsername.setForeground(new java.awt.Color(0, 0, 0));
        lblUsername.setText("Username:");
        jpBackground.add(lblUsername);
        lblUsername.setBounds(70, 140, 70, 30);

        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        jpBackground.add(btnExit);
        btnExit.setBounds(70, 360, 90, 30);

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        jpBackground.add(btnDelete);
        btnDelete.setBounds(580, 240, 90, 30);

        lblPassword.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        lblPassword.setForeground(new java.awt.Color(0, 0, 0));
        lblPassword.setText("Password:");
        jpBackground.add(lblPassword);
        lblPassword.setBounds(70, 190, 70, 30);

        btnCreate.setText("Create");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });
        jpBackground.add(btnCreate);
        btnCreate.setBounds(580, 90, 90, 30);

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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpBackground, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed

        if(boolCreate==true)
        {
            if(txtUsername.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null,"The field cannot be left empty");
                txtUsername.requestFocusInWindow();
            }
            else if(txtPassword.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null,"The field cannot be left empty");
                txtPassword.requestFocusInWindow();
            }
            else if(txtRole.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null,"The field cannot be left empty");
                txtRole.requestFocusInWindow();
            }
            else
            {
                mGetValuesFromGUI();
                mSetValuesToUpperCase();
                mEncryptPassword();
                mcheckIfltemsExistInTabIe();
                if(boolRecordExists==true)
                {
                    boolRecordExists=false;
                    JOptionPane.showMessageDialog(null, "User already Exists");
                }
                else if(boolRecordExists==false)
                {
                    boolCreate=false;
                    mCreateUser();
                    mClearTextFields();
                    mClearVariables();
                    mClearComboBox();
                    mLoadUsername();
                    mLoadGUIControls();
                }
            }
        }

        else if(boolEdit=true)
        {
            boolEdit=false;
            mGetValuesFromGUI();
            mSetValuesToUpperCase();
            mEncryptPassword();
            mUpdateUser();
            mClearTextFields();
            mClearVariables();
            mClearComboBox();
            mLoadUsername();
            mLoadGUIControls();
        }
        btnDelete.setText("Delete");
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed

        mReadUserDetails();
        mDecryptPassword();
        mSetValuesInGUI();
        mEditGUIControls();
        txtUsername.requestFocusInWindow();
        btnDelete.setText("Cancel");
        boolEdit=true;
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadActionPerformed

        mReadUserDetails();
        mDecryptPassword();
        mSetValuesInGUI();
        mLoadGUIControls();
    }//GEN-LAST:event_btnLoadActionPerformed

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPasswordActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // TODO add your handling code here:
        setVisible(false);
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if("Delete".equals(btnDelete.getText()))
        {
            mReadUserDetails();
            mDeleteUser();
            mClearComboBox();
            mClearVariables();
            mLoadUsername();
        }
        else if("Cancel".equals(btnDelete.getText()))
        {
            mClearTextFields();
            mClearVariables();
            mClearComboBox();
            mLoadUsername();
            mLoadGUIControls();
        }
        btnDelete.setText("Delete");
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed

        mCreateGUIControls();
        txtUsername.requestFocusInWindow();
        btnDelete.setText("Cancel");
        boolCreate=true;
    }//GEN-LAST:event_btnCreateActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnLoad;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cboUsername;
    private javax.swing.JPanel jpBackground;
    private javax.swing.JPanel jpTitle;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblRole;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtRole;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
