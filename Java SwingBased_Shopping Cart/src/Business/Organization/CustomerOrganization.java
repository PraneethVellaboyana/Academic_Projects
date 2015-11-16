/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Organization;

import Business.Role.CustomerRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Praneeth Reddy
 */
public class CustomerOrganization extends Organization{

    public CustomerOrganization(){
    super(Organization.TypeOfOrg.Customer.getValue());
    }
    
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roleList = new ArrayList<Role>();
        roleList.add(new CustomerRole());
        return roleList;
    }
    
}
