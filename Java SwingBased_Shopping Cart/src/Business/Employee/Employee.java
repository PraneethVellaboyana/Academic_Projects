package Business.Employee;

/**
 *
 * @author Praneeth Reddy
 */

public class Employee {
    
    private String name;
    private static int count=0;
    private int employeeID;

    public Employee(){
        count++;
        employeeID=count;
    }
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    /**
     * @return the employeeID
     */
    public int getEmployeeID() {
        return employeeID;
    }

    /**
     * @param employeeID the employeeID to set
     */
    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    
    
}
