package Business.Organization;

import java.util.ArrayList;

/**
 *
 * @author Praneeth Reddy
 */
public class OrganizationDirectory {
    
    private ArrayList<Organization> organizationDirectory;
    
    public OrganizationDirectory(){
        organizationDirectory = new ArrayList<Organization>();
    }

    /**
     * @return the organizationDirectory
     */
    public ArrayList<Organization> getOrganizationDirectory() {
        return organizationDirectory;
    }        
    
}
