/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business;

import Business.Order.MasterOrderCatalog;
import Business.Organization.OrganizationDirectory;

/**
 *
 * @author Praneeth Reddy
 */
public class Business {
    
    private MasterOrderCatalog masterOrderCatalog;
    private OrganizationDirectory organizationDirectory;
    
    private static Business business;
    
    private Business(){
        masterOrderCatalog = new MasterOrderCatalog();
        organizationDirectory = new OrganizationDirectory();
    }

    public static Business getInstance(){
        
        if(business == null){
            business = new Business();
        }
        return business;
    }

    /**
     * @return the masterOrderCatalog
     */
    public MasterOrderCatalog getMasterOrderCatalog() {
        return masterOrderCatalog;
    }

    /**
     * @param masterOrderCatalog the masterOrderCatalog to set
     */
    public void setMasterOrderCatalog(MasterOrderCatalog masterOrderCatalog) {
        this.masterOrderCatalog = masterOrderCatalog;
    }

    /**
     * @return the organizationDirectory
     */
    public OrganizationDirectory getOrganizationDirectory() {
        return organizationDirectory;
    }

    /**
     * @param organizationDirectory the organizationDirectory to set
     */
    public void setOrganizationDirectory(OrganizationDirectory organizationDirectory) {
        this.organizationDirectory = organizationDirectory;
    }
   
    
}
