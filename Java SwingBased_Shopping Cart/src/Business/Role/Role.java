/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.Business;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;

/**
 *
 * @author Praneeth Reddy
 */
public abstract class Role {

    public enum RoleType {

        Admin("AdminRole"),
        Customer("CustomerRole"),
        Supplier("SupplierRole"),
        SalesSpecialist("SalesSpecialistRole"),
        ShippingSpecialist("ShippingSpecialistRole");

        private String value;

        private RoleType(String value) {
            this.value = value;
        }

        /**
         * @return the value
         */
        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }

    }

    
    public abstract JPanel createWorkArea(JPanel userProcessContainer, UserAccount userAccount, Organization organization, Business business);
    
    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
    
    
}
