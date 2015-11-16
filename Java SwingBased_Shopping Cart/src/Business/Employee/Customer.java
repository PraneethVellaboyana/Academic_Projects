/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Employee;

import Business.Order.Order;
import java.util.ArrayList;

/**
 *
 * @author Praneeth Reddy
 */
public class Customer  extends Employee{
    
   // private String customerName;
//    private ArrayList<Order> orders;
//
//    public Customer(){
//        orders = new ArrayList<Order>();
//    }



    
    @Override
    public String toString() {
        return super.getName();
    }


    
//    public void addOrder(Order order){
//        orders.add(order);
//    }
}
