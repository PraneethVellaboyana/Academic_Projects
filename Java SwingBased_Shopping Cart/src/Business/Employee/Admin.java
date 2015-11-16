/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Employee;

import Business.Employee.Employee;

/**
 *
 * @author Praneeth Reddy
 */
public final class Admin extends Employee{
    
    private static Admin admin;
    private Admin(){
    }
    
    public static Admin getInstance(){
    
        if(admin==null){
            admin = new Admin();
        }
    return admin;
    }
}
