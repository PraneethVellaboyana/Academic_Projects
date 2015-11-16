package Business.Employee;

import Business.Organization.Organization;
import Business.Organization.Organization.TypeOfOrg;
import java.util.ArrayList;

/**
 *
 * @author Praneeth Reddy
 */
public class EmployeeDirectory {
 
    private ArrayList<Employee> employeeList;
    
    public EmployeeDirectory(){
        employeeList = new ArrayList<Employee>();
    }

    /**
     * @return the employeeList
     */
    public ArrayList<Employee> getEmployeeList() {
        return employeeList;
    }

    public Employee createEmployee(String name,Organization organization){
        if(organization.getOrganizationName().equals(TypeOfOrg.Customer.getValue())){
            Customer customer = new Customer();
            customer.setName(name);
             employeeList.add(customer);
             return customer;
        }
        else if(organization.getOrganizationName().equals(TypeOfOrg.Supplier.getValue())){
            Supplier supplier = new Supplier();
            supplier.setName(name);
             employeeList.add(supplier);
             return supplier;
        }
        else if(organization.getOrganizationName().equals(TypeOfOrg.SalesSpecialist.getValue())){
            SalesSpecialist salesSpecialist = new SalesSpecialist();
            salesSpecialist.setName(name);
             employeeList.add(salesSpecialist);
             return salesSpecialist;
        } 
        else if(organization.getOrganizationName().equals(TypeOfOrg.ShippingSpecialist.getValue())){
            ShippingSpecialist shippingSpecialist = new ShippingSpecialist();
            shippingSpecialist.setName(name);
             employeeList.add(shippingSpecialist);
             return shippingSpecialist;
        } 
     return null;
    }
    
    public void removeEmployee(Employee emp) {
        employeeList.remove(emp);
    }
    
    public Employee searchEmployee(String emp) {
        for(Employee e : employeeList) {
            if(emp.equals(e.getName())) {
                return e;
            }
        }
        return null;
    }
}
