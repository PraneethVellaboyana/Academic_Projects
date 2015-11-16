/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Employee.EmployeeDirectory;
import Business.Role.Role;
import Business.UserAccount.UserAccountDirectory;
import Business.WorkQueue.WorkQueue;
import java.util.ArrayList;

/**
 *
 * @author Praneeth Reddy
 */
public abstract class Organization {

    private EmployeeDirectory employeeDirectory;
    private UserAccountDirectory userAccountDirectory;
    private String organizationName;
    private int orgId;
    private static int count = 1;
    private WorkQueue workQueue;

    public Organization(String organizationName) {
        this.organizationName = organizationName;
        employeeDirectory = new EmployeeDirectory();
        userAccountDirectory = new UserAccountDirectory();
        workQueue = new WorkQueue();
        orgId = count;
        ++count;
    }

    /**
     * @return the userAccountDirectory
     */
    public UserAccountDirectory getUserAccountDirectory() {
        return userAccountDirectory;
    }

    /**
     * @return the organizationName
     */
    public String getOrganizationName() {
        return organizationName;
    }

    /**
     * @param organizationName the organizationName to set
     */
    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    /**
     * @return the orgId
     */
    public int getOrgId() {
        return orgId;
    }

    /**
     * @return the employeeDirectory
     */
    public EmployeeDirectory getEmployeeDirectory() {
        return employeeDirectory;
    }

    /**
     * @param employeeDirectory the employeeDirectory to set
     */
    public void setEmployeeDirectory(EmployeeDirectory employeeDirectory) {
        this.employeeDirectory = employeeDirectory;
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

    public enum TypeOfOrg {

        Admin("Admin Organization"),
        Customer("Customer Organization"),
        Supplier("Supplier Organization"),
        SalesSpecialist("SalesSpecialist Organization"),
        ShippingSpecialist("Shipping Organization");


        private String value;

        private TypeOfOrg(String value) {
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

    public abstract ArrayList<Role> getSupportedRole();

    @Override
    public String toString() {
        return organizationName;
    }

}
