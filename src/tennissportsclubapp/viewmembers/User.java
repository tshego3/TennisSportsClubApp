/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tennissportsclubapp.viewmembers;



/**
 *
 * @author Tshegofatso
 */
class User {
    
    private int ID;
    private String MemberName, Username, UsernamePassword, Role, ContactNumber, Address, NextOfKin, Sex, DateOfBirth, Membership, PersonalTrainer, TimeSelected;  


public User(int ID, String MemberName, String Username, String UsernamePassword, String Role, String ContactNumber, String Address, String NextOfKin, String Sex, String DateOfBirth, String Membership, String PersonalTrainer, String TimeSelected)
{
this.ID=ID;
this.MemberName=MemberName;
this.Username=Username;
this.UsernamePassword=UsernamePassword;
this.Role=Role;
this.ContactNumber=ContactNumber;
this.Address=Address;
this.NextOfKin=NextOfKin;
this.Sex=Sex;
this.DateOfBirth=DateOfBirth;
this.Membership=Membership;
this.PersonalTrainer=PersonalTrainer;
this.TimeSelected=TimeSelected;

}

    User(int aInt, String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

public int getID()
{
 return ID;
}

public String getMemberName()
{
 return MemberName;
}

public String getUsername()
{
 return Username;
}

public String getUsernamePassword()
{
 return UsernamePassword;
}

public String getRole()
{
 return Role;
}

public String getContactNumber()
{
 return ContactNumber;
}

public String getAddress()
{
 return Address;
}


public String getNextOfKin()
{
 return NextOfKin;
}

public String getSex()
{
 return Sex;
}

public String getDateOfBirth()
{
 return DateOfBirth;
}

public String getMembership()
{
 return Membership;
}

public String getPersonalTrainer()
{
 return PersonalTrainer;
}

public String getTimeSelected()
{
 return TimeSelected;
}

}