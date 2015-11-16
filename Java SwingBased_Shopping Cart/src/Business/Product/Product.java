/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Product;

/**
 *
 * @author Rushabh
 */
public class Product {
    private static int count = 1000;
    private String prodName;
    private int price;
    private int modelNumber;
    private int availability;
    private int soldQuantity;
    
    public Product() {
        count++;
        modelNumber = count;
    }
    
    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getModelNumber() {
        return modelNumber;
    }
    
    @Override
    public String toString() {
        return prodName;
    }

    /**
     * @return the availability
     */
    public int getAvailability() {
        return availability;
    }

    /**
     * @param availability the availability to set
     */
    public void setAvailability(int availability) {
        this.availability = availability;
    }
    
    
    /**
     * @return the count
     */
    public static int getCount() {
        return count;
    }

    /**
     * @param aCount the count to set
     */
    public static void setCount(int aCount) {
        count = aCount;
    }

    /**
     * @return the soldQuantity
     */
    public int getSoldQuantity() {
        return soldQuantity;
    }

    /**
     * @param soldQuantity the soldQuantity to set
     */
    public void setSoldQuantity(int soldQuantity) {
        this.soldQuantity = soldQuantity;
    }
}
