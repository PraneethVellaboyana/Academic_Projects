/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Role;

import Business.Business;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import UserInterface.ShippingSpecialistRole.ShippingSpecialistWorkAreaPanel;
import javax.swing.JPanel;

/**
 *
 * @author Praneeth Reddy
 */
public class ShippingSpecialistRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount userAccount, Organization organization, Business business) {
       return new ShippingSpecialistWorkAreaPanel(userProcessContainer,business,organization,userAccount);
    }
    
}
