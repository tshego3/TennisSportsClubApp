/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tennissportsclubapp;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
//import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;


/**
 *
 * @author Tshegofatso
 */
public class frmModifyMembers extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmMembers
     */
    public frmModifyMembers() {
        initComponents();
        mLoadName();
       mLoadGUIControls();
    }

//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
CaesarsChiper clsCC= new CaesarsChiper();    
    
Boolean boolRecordExists=false; 
Boolean boolEdit=false; 
Boolean boolCreate=false; 
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
strName=txtName.getText(); 
strUsername=txtUsername.getText();
strPassword=txtPassword.getText(); 
strRole=cboRole.getSelectedItem().toString(); 
strContactNumber=txtContactNumber.getText();
strAddress=txtAddress.getText();
strNextOfKin=txtNextOfKin.getText();
strSex=cboSex.getSelectedItem().toString();
strDateOfBirth=txtBirth.getText();
strMembership=cboMembership.getSelectedItem().toString();
strPersonalTrainer=cboPersonalTrainer.getSelectedItem().toString();
strTime=txtTime.getText();
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
txtPassword.setText(strPassword);
cboRole.setSelectedItem(strRole);
txtContactNumber.setText(strContactNumber);
txtAddress.setText(strAddress);
txtNextOfKin.setText(strNextOfKin);
cboSex.setSelectedItem(strSex);
txtBirth.setText(strDateOfBirth);
cboMembership.setSelectedItem(strMembership);
cboPersonalTrainer.setSelectedItem(strPersonalTrainer);
txtTime.setText(strTime);
}

private void mClearTextFields()
{ 
txtName.setText("");
txtUsername.setText("");
txtPassword.setText(""); 
cboRole.setSelectedItem("");
txtContactNumber.setText("");
txtAddress.setText("");
txtNextOfKin.setText("");
cboSex.setSelectedItem("");
txtBirth.setText("");
cboMembership.setSelectedItem("");
cboPersonalTrainer.setSelectedItem("");
txtTime.setText("");

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
cboName.addItem(rs.getString(1));
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

private void mUpdateMember()
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
String strQuery = " UPDATE members SET MemberName ='" + strName +"', Username='" + strUsername +"', UsernamePassword='" + strPassword +"' , Role='" + strRole +"' , ContactNumber='" + strContactNumber +"' , Address='" + strAddress +"' , NextOfKin='" + strNextOfKin +"' , Sex='" + strSex +"' , DateOfBirth='" + strDateOfBirth +"' , Membership='" + strMembership +"' , PersonalTrainer='" + strPersonalTrainer +"', TimeSelected='" + strTime +"' where ID ="+ intMemberID; 
 
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
cboName.setModel(model);
}

private void mDeleteMember()
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
String strQuery = " Delete from members where MemberName ='" + strName +"' and Username='" + strUsername +"' and UsernamePassword='" + strPassword +"' and Role='" + strRole +"' and ContactNumber='" + strContactNumber +"' and Address='" + strAddress +"' and NextOfKin='" + strNextOfKin +"' and Sex='" + strSex +"' and DateOfBirth='" + strDateOfBirth +"' and Membership='" + strMembership +"' and PersonalTrainer='" + strPersonalTrainer +"' and TimeSelected='" + strTime +"' and ID ="+ intMemberID; 
  
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


private void mReadMemberDetails()
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
String strQuery = " Select ID, MemberName, Username, UsernamePassword, Role, ContactNumber, Address, NextOfKin, Sex, DateOfBirth, Membership, PersonalTrainer, TimeSelected from Members where MemberName='"+ cboName.getSelectedItem().toString()+"'";
stStatement.execute(strQuery); 
rs=stStatement.getResultSet();

while(rs.next())
{
intMemberID=rs.getInt(1); 
strName=rs.getString(2); 
strUsername=rs.getString(3); 
strPassword=rs.getString(4); 
strRole=rs.getString(5); 
strContactNumber=rs.getString(6); 
strAddress=rs.getString(7); 
strNextOfKin=rs.getString(8); 
strSex=rs.getString(9); 
strDateOfBirth=rs.getString(10); 
strMembership=rs.getString(11); 
strPersonalTrainer=rs.getString(12); 
strTime=rs.getString(13); 

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
txtName.setEnabled(false);
txtUsername.setEnabled(false);
txtPassword.setEnabled(false); 
cboRole.setEnabled(false);
txtContactNumber.setEnabled(false);
txtAddress.setEnabled(false);
txtNextOfKin.setEnabled(false);
cboSex.setEnabled(false);
txtBirth.setEnabled(false);
cboMembership.setEnabled(false);
cboPersonalTrainer.setEnabled(false);
txtTime.setEnabled(false);
cboName.setEnabled(true); 
btnCreate.setEnabled(true); 
btnLoad.setEnabled(true); 
btnEdit.setEnabled(true); 
btnSave.setEnabled(false); 
btnDelete.setEnabled(true);
    
//       if(cboName.getSelectedItem()== null)
//            {
//           btnDelete.setEnabled(false);
//            }
//       else if (cboName.getSelectedItem().equals("*"))
//            {
//           btnDelete.setEnabled(true);
//            }
//       
//         if(cboName.getSelectedItem()== null)
//            {
//           btnEdit.setEnabled(false);
//            }
//       else if (cboName.getSelectedItem().equals("*"))
//            {
//           btnEdit.setEnabled(true);
//            }
//           if(cboName.getSelectedItem()== null)
//            {
//           btnLoad.setEnabled(false);
//            }
//       else if (cboName.getSelectedItem().equals("*"))
//            {
//           btnLoad.setEnabled(true);
//            }
//           
//             if(cboName.getSelectedItem()== null)
//            {
//           cboName.setEnabled(false);
//            }
//       else if (cboName.getSelectedItem().equals("*"))
//            {
//           cboName.setEnabled(true);
//            }
       
}

private void mEditGUIControls()
{
txtName.setEnabled(true);
txtUsername.setEnabled(true);
txtPassword.setEnabled(true); 
cboRole.setEnabled(true);
txtContactNumber.setEnabled(true);
txtAddress.setEnabled(true);
txtNextOfKin.setEnabled(true);
cboSex.setEnabled(true);
txtBirth.setEnabled(false);
cboMembership.setEnabled(true);
cboPersonalTrainer.setEnabled(true);
txtTime.setEnabled(true);
cboName.setEnabled(false); 
btnCreate.setEnabled(false); 
btnLoad.setEnabled(false); 
btnEdit.setEnabled(false); 
btnSave.setEnabled(true); 
btnDelete.setEnabled(true);
}

private void mSaveGUIControls()
{
txtName.setEnabled(false);
txtUsername.setEnabled(false);
txtPassword.setEnabled(false); 
cboRole.setEnabled(false);
txtContactNumber.setEnabled(false);
txtAddress.setEnabled(false);
txtNextOfKin.setEnabled(false);
cboSex.setEnabled(false);
txtBirth.setEnabled(false);
cboMembership.setEnabled(false);
cboPersonalTrainer.setEnabled(false);
txtTime.setEnabled(false);
cboName.setEnabled(true); 
btnCreate.setEnabled(true); 
btnLoad.setEnabled(true); 
btnEdit.setEnabled(true); 
btnSave.setEnabled(false); 
btnDelete.setEnabled(true);
    
   



}

private void mCreateGUIControls()
{
txtName.setEnabled(true);
txtUsername.setEnabled(true);
txtPassword.setEnabled(true); 
cboRole.setEnabled(true);
txtContactNumber.setEnabled(true);
txtAddress.setEnabled(true);
txtNextOfKin.setEnabled(true);
cboSex.setEnabled(true);
txtBirth.setEnabled(false);
cboMembership.setEnabled(true);
cboPersonalTrainer.setEnabled(true);
txtTime.setEnabled(true);
cboName.setEnabled(false); 
btnCreate.setEnabled(false); 
btnLoad.setEnabled(false); 
btnEdit.setEnabled(false); 
btnSave.setEnabled(true); 
btnDelete.setEnabled(true);
}

private void mDeleteGUIControls()
{
txtName.setEnabled(false);
txtUsername.setEnabled(false);
txtPassword.setEnabled(false); 
cboRole.setEnabled(false);
txtContactNumber.setEnabled(false);
txtAddress.setEnabled(false);
txtNextOfKin.setEnabled(false);
cboSex.setEnabled(false);
txtBirth.setEnabled(false);
cboMembership.setEnabled(false);
cboPersonalTrainer.setEnabled(false);
txtTime.setEnabled(false);
cboName.setEnabled(true); 
btnCreate.setEnabled(true); 
btnLoad.setEnabled(true); 
btnEdit.setEnabled(true); 
btnSave.setEnabled(false); 
btnDelete.setEnabled(false);
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
        cboName = new javax.swing.JComboBox<>();
        txtUsername = new javax.swing.JTextField();
        txtPassword = new javax.swing.JTextField();
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
        btnDelete = new javax.swing.JButton();
        btnCreate = new javax.swing.JButton();
        btnLoad = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        txtBirth = new javax.swing.JTextField();

        setTitle("Modify Members");
        setPreferredSize(new java.awt.Dimension(750, 500));

        jpBackground.setBackground(new java.awt.Color(255, 255, 255));
        jpBackground.setLayout(null);

        jpTitle.setBackground(new java.awt.Color(0, 204, 0));

        lblTitle.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Modify Members");
        lblTitle.setToolTipText("");

        javax.swing.GroupLayout jpTitleLayout = new javax.swing.GroupLayout(jpTitle);
        jpTitle.setLayout(jpTitleLayout);
        jpTitleLayout.setHorizontalGroup(
            jpTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpTitleLayout.createSequentialGroup()
                .addGap(279, 279, 279)
                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(271, Short.MAX_VALUE))
        );
        jpTitleLayout.setVerticalGroup(
            jpTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        jpBackground.add(jpTitle);
        jpTitle.setBounds(0, 0, 750, 50);

        cboName.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        cboName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        jpBackground.add(cboName);
        cboName.setBounds(30, 60, 700, 30);

        txtUsername.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        txtUsername.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        jpBackground.add(txtUsername);
        txtUsername.setBounds(30, 240, 300, 30);

        txtPassword.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        txtPassword.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        jpBackground.add(txtPassword);
        txtPassword.setBounds(30, 310, 300, 30);

        txtName.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        txtName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });
        jpBackground.add(txtName);
        txtName.setBounds(30, 170, 300, 30);

        txtContactNumber.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        txtContactNumber.setToolTipText("");
        txtContactNumber.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        jpBackground.add(txtContactNumber);
        txtContactNumber.setBounds(30, 450, 300, 30);

        jspAddress.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));

        txtAddress.setColumns(10);
        txtAddress.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        txtAddress.setRows(5);
        jspAddress.setViewportView(txtAddress);

        jpBackground.add(jspAddress);
        jspAddress.setBounds(30, 520, 300, 110);

        lblPassword.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        lblPassword.setText("Password");
        jpBackground.add(lblPassword);
        lblPassword.setBounds(30, 280, 53, 20);

        lblName.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        lblName.setText("Name");
        jpBackground.add(lblName);
        lblName.setBounds(30, 140, 60, 20);

        lblRole.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        lblRole.setText("Role");
        jpBackground.add(lblRole);
        lblRole.setBounds(30, 350, 25, 20);

        lblAddress.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        lblAddress.setText("Address");
        jpBackground.add(lblAddress);
        lblAddress.setBounds(30, 490, 57, 20);

        lblContactNumber.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        lblContactNumber.setText("Contact No");
        jpBackground.add(lblContactNumber);
        lblContactNumber.setBounds(30, 420, 90, 20);

        lblUsername.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        lblUsername.setText("Username");
        jpBackground.add(lblUsername);
        lblUsername.setBounds(30, 210, 90, 20);

        txtNextOfKin.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        txtNextOfKin.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        txtNextOfKin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNextOfKinActionPerformed(evt);
            }
        });
        jpBackground.add(txtNextOfKin);
        txtNextOfKin.setBounds(420, 170, 300, 30);

        lblNextOfKin.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        lblNextOfKin.setText("Next Of Kin");
        jpBackground.add(lblNextOfKin);
        lblNextOfKin.setBounds(420, 140, 90, 20);

        lblSex.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        lblSex.setText("Sex");
        jpBackground.add(lblSex);
        lblSex.setBounds(420, 210, 60, 20);

        lblDateOfBirth.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        lblDateOfBirth.setText("Date Of Birth");
        jpBackground.add(lblDateOfBirth);
        lblDateOfBirth.setBounds(420, 280, 110, 20);

        lblMembership.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        lblMembership.setText("Membership");
        jpBackground.add(lblMembership);
        lblMembership.setBounds(420, 350, 110, 20);

        lblPersonalTrainerWanted.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        lblPersonalTrainerWanted.setText("Would you like to receive a personal trainer?  ");
        jpBackground.add(lblPersonalTrainerWanted);
        lblPersonalTrainerWanted.setBounds(420, 420, 260, 20);

        lblTime.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        lblTime.setText("Time");
        jpBackground.add(lblTime);
        lblTime.setBounds(420, 490, 110, 20);

        txtTime.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        txtTime.setToolTipText("HH:mm");
        txtTime.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        txtTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimeActionPerformed(evt);
            }
        });
        jpBackground.add(txtTime);
        txtTime.setBounds(420, 520, 300, 30);

        cboMembership.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        cboMembership.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Junior", "Beginner", "Advanced", "Professional" }));
        jpBackground.add(cboMembership);
        cboMembership.setBounds(420, 380, 300, 30);

        cboRole.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        cboRole.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "STANDARD", "SUPERVISOR", "ADMIN" }));
        jpBackground.add(cboRole);
        cboRole.setBounds(30, 380, 300, 30);

        cboSex.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        cboSex.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Female", "Male" }));
        jpBackground.add(cboSex);
        cboSex.setBounds(420, 240, 300, 30);

        cboPersonalTrainer.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No", "Yes" }));
        jpBackground.add(cboPersonalTrainer);
        cboPersonalTrainer.setBounds(420, 450, 300, 30);

        btnDelete.setText("Delete Account");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        jpBackground.add(btnDelete);
        btnDelete.setBounds(420, 640, 120, 25);

        btnCreate.setText("Create");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });
        jpBackground.add(btnCreate);
        btnCreate.setBounds(110, 100, 80, 25);

        btnLoad.setText("Load");
        btnLoad.setToolTipText("");
        btnLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadActionPerformed(evt);
            }
        });
        jpBackground.add(btnLoad);
        btnLoad.setBounds(30, 100, 70, 25);

        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        jpBackground.add(btnExit);
        btnExit.setBounds(30, 640, 70, 25);

        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        jpBackground.add(btnEdit);
        btnEdit.setBounds(560, 640, 70, 25);

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        jpBackground.add(btnSave);
        btnSave.setBounds(650, 640, 70, 25);

        txtBirth.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        txtBirth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBirthActionPerformed(evt);
            }
        });
        jpBackground.add(txtBirth);
        txtBirth.setBounds(420, 310, 300, 30);

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
            .addComponent(jpBackground, javax.swing.GroupLayout.DEFAULT_SIZE, 688, Short.MAX_VALUE)
        );

        setBounds(0, 0, 760, 720);
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

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:

        if("Delete Account".equals(btnDelete.getText()))
        {
            mReadMemberDetails();
            mDeleteMember();
            mClearComboBox();
            mClearVariables();
            mLoadName();
        }
        else if("Cancel".equals(btnDelete.getText()))
        {
            mClearTextFields();
            mClearVariables();
            mClearComboBox();
            mLoadName();
            mLoadGUIControls();
        }
        btnDelete.setText("Delete Account");

    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        // TODO add your handling code here:

        mCreateGUIControls();
        txtName.requestFocusInWindow();
        btnDelete.setText("Cancel");
        boolCreate=true;
    }//GEN-LAST:event_btnCreateActionPerformed

    private void btnLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadActionPerformed
        // TODO add your handling code here:

        mReadMemberDetails();
        mSetValuesInGUI();
        mLoadGUIControls();
    }//GEN-LAST:event_btnLoadActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // TODO add your handling code here:
        setVisible(false);
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
        mReadMemberDetails();
        mSetValuesInGUI();
        mEditGUIControls();
        txtName.requestFocusInWindow();
        btnDelete.setText("Cancel");
        boolEdit=true;
    }//GEN-LAST:event_btnEditActionPerformed

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

            if(txtBirth.getText() == null)
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
                    mClearComboBox();
                    mLoadName();
                    mLoadGUIControls();
                }
            }
        }

        else if(boolEdit=true)
        {
            boolEdit=false;
            mGetValuesFromGUI();
            mSetValuesToUpperCase();
            mUpdateMember();
            mClearTextFields();
            mClearVariables();
            mClearComboBox();
            mLoadName();
            mLoadGUIControls();
        }
        btnDelete.setText("Delete Account");
    }//GEN-LAST:event_btnSaveActionPerformed

    private void txtBirthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBirthActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBirthActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnLoad;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cboMembership;
    private javax.swing.JComboBox<String> cboName;
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
    private javax.swing.JTextField txtBirth;
    private javax.swing.JTextField txtContactNumber;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtNextOfKin;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtTime;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
