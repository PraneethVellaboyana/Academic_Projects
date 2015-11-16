/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.WorkQueue;

/**
 *
 * @author Praneeth Reddy
 */
public class EnrollmentWorkRequest extends WorkRequest{
    
    private String enrollmentStatus;

    /**
     * @return the enrollmentStatus
     */
    public String getEnrollmentStatus() {
        return enrollmentStatus;
    }

    /**
     * @param enrollmentStatus the enrollmentStatus to set
     */
    public void setEnrollmentStatus(String enrollmentStatus) {
        this.enrollmentStatus = enrollmentStatus;
    }
    
    
}
