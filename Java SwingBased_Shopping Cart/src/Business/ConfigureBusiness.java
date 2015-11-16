/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business;

import Business.Employee.Admin;
import Business.UserAccount.UserAccount;
import Business.Organization.AdminOrganization;
import Business.Organization.CustomerOrganization;
import Business.Organization.SalesSpecialistOrganization;
import Business.Organization.ShippingSpecialistOrganization;
import Business.Organization.SupplierOrganization;
import Business.Role.AdminRole;

/**
 *
 * @author Praneeth Reddy
 */
public class ConfigureBusiness {
    
    public static Business intialize(){
    
        Business business = Business.getInstance();
        
                
        AdminOrganization adminOrganization = new AdminOrganization();
        business.getOrganizationDirectory().getOrganizationDirectory().add(adminOrganization);
        
        SupplierOrganization supplierOrganization = new SupplierOrganization();
        business.getOrganizationDirectory().getOrganizationDirectory().add(supplierOrganization);
        
        CustomerOrganization customerOrganization = new CustomerOrganization();
        business.getOrganizationDirectory().getOrganizationDirectory().add(customerOrganization);
        
        SalesSpecialistOrganization salesOrganization = new SalesSpecialistOrganization();
        business.getOrganizationDirectory().getOrganizationDirectory().add(salesOrganization);

        ShippingSpecialistOrganization shippingOrganization = new ShippingSpecialistOrganization();
        business.getOrganizationDirectory().getOrganizationDirectory().add(shippingOrganization);

        
        Admin admin = Admin.getInstance();
        admin.setName("Praneeth Reddy");
        
        UserAccount userAccount = new UserAccount();
        userAccount.setUserName("admin");
        userAccount.setPassword("admin");
        userAccount.setStatus("Active");
        userAccount.setRole(new AdminRole());
        userAccount.setEmployee(admin);
        
        adminOrganization.getUserAccountDirectory().getUserAccountDirectory().add(userAccount);
        adminOrganization.getEmployeeDirectory().getEmployeeList().add(admin);
        
    
    return business;
        
    }
}
