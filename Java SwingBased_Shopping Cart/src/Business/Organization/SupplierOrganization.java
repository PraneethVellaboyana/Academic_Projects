package Business.Organization;

import Business.Role.Role;
import Business.Role.SupplierRole;
import java.util.ArrayList;

/**
 *
 * @author Praneeth Reddy
 */
public class SupplierOrganization  extends Organization{

    public SupplierOrganization(){
    super(Organization.TypeOfOrg.Supplier.getValue());
    }
    
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roleList = new ArrayList<Role>();
        roleList.add(new SupplierRole());
        return roleList;
    }
    
}
