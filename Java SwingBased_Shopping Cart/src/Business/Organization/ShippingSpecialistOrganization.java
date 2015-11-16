/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Organization;

import Business.Role.Role;
import Business.Role.ShippingSpecialistRole;
import java.util.ArrayList;

/**
 *
 * @author Praneeth Reddy
 */
public class ShippingSpecialistOrganization extends Organization{
    
    public ShippingSpecialistOrganization() {
        super(Organization.TypeOfOrg.ShippingSpecialist.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roleList = new ArrayList<Role>();
        roleList.add(new ShippingSpecialistRole());
        return roleList;    }
    
}
