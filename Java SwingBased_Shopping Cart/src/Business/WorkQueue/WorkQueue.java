/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.WorkQueue;

import java.util.ArrayList;

/**
 *
 * @author Praneeth Reddy
 */
public class WorkQueue {
    
    ArrayList<WorkRequest>  workRequests;
    
    public WorkQueue(){
        workRequests = new ArrayList<WorkRequest>();
    }

    public ArrayList<WorkRequest> getWorkRequests() {
        return workRequests;
    }

}
