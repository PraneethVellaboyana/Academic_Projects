/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Employee;

import Business.Product.Product;
import Business.Product.ProductCatalog;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.EnrollmentWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author Rushabh
 */
public class Supplier  extends Employee{
    
    //private String supplyName;
    private ProductCatalog productCatalog;
    
    public Supplier() {
        productCatalog = new ProductCatalog();
    }

    public ProductCatalog getProductCatalog() {
        return productCatalog;
    }
    
    @Override
    public String toString() {
        return super.getName();
    }
    
     public Product getProductsSorted(Supplier supplier) throws IndexOutOfBoundsException{
     Collections.sort(supplier.getProductCatalog().getProductCatalog(), new Comparator<Product>(){

            public int compare(Product o1, Product o2) {
                if(o1.getSoldQuantity() < o2.getSoldQuantity())
                    return 1;
                else if(o1.getSoldQuantity() > o2.getSoldQuantity())
                    return -1;
                return 0;
            }
        });
     
     Product product = supplier.getProductCatalog().getProductCatalog().get(0);
     return product;
    }
     
    public boolean checkForEnrollment(UserAccount userAccount){
        
        for(WorkRequest wr: userAccount.getWorkQueue().getWorkRequests()){
            if(wr.getStatus().equals(WorkRequest.Status.COMPLETED.getValue())){
                    return true;
            }
        }
        return false;
    }
}
