/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Order;

import java.util.ArrayList;

/**
 *
 * @author Praneeth Reddy
 */
public class Order {
    
    private ArrayList<OrderItem> orderItemList;
    private static int count = 1000;
    private int orderId;
    
    public Order(){
        count++;
        orderId = count;
       orderItemList = new ArrayList<OrderItem>();
    }

    /**
     * @return the orderItemList
     */
    public ArrayList<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    /**
     * @param orderItemList the orderItemList to set
     */
    public void setOrderItemList(ArrayList<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }
    
    
    public OrderItem addOrderItem(){
        OrderItem item = new OrderItem();
        orderItemList.add(item);
        return item;
    }
    
    public void removeOrderItem(OrderItem item){
        orderItemList.remove(item);
    }

    /**
     * @return the orderId
     */
    public int getOrderId() {
        return orderId;
    }

    /**
     * @param orderId the orderId to set
     */
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return String.valueOf(orderId);
    }

    
}
