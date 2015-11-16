package Business.UserAccount;

import Business.Employee.Employee;
import Business.Role.Role;
import Business.WorkQueue.WorkQueue;

/**
 *
 * @author Praneeth Reddy
 */
public class UserAccount {
    
    private String userName;
    private String password;
    private Role role;
    private String status;
    private Employee employee;
    private WorkQueue workQueue;
    
    public UserAccount(){
        workQueue = new WorkQueue();
    }
    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }


    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the employee
     */
    public Employee getEmployee() {
        return employee;
    }

    /**
     * @param employee the employee to set
     */
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    /**
     * @return the role
     */
    public Role getRole() {
        return role;
    }

    /**
     * @param role the role to set
     */
    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return userName;
    }

    /**
     * @return the workQueue
     */
    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    /**
     * @param workQueue the workQueue to set
     */
    public void setWorkQueue(WorkQueue workQueue) {
        this.workQueue = workQueue;
    }
     
}
