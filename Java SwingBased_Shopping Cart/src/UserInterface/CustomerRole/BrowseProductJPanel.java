/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package UserInterface.CustomerRole;

import Business.Employee.Supplier;
import Business.Employee.Customer;
import Business.Order.MasterOrderCatalog;
import Business.Product.Product;
import Business.Order.OrderItem;
import Business.Order.Order;
import Business.Employee.EmployeeDirectory;
import Business.Employee.Employee;
import Business.*;
import Business.Organization.Organization;
import Business.Organization.SalesSpecialistOrganization;
import Business.Organization.ShippingSpecialistOrganization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.OrderWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Praneeth Reddy
 */
public class BrowseProductJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private EmployeeDirectory employeeDirectory ;
    private MasterOrderCatalog moc;
    private Order order;
    private Customer customer;
    private UserAccount userAccount;
    private Business business;
    private Boolean isCheckedOut = false;
    /**
     * Creates new form BrowseProductJPanel
     */
    public BrowseProductJPanel (JPanel userProcessContainer, Business business,UserAccount userAccount) {
        initComponents();
        this.business = business;
        this.userProcessContainer = userProcessContainer;
        this.moc = business.getMasterOrderCatalog();
        this.customer = (Customer)userAccount.getEmployee();
        this.userAccount = userAccount;        
        for(Organization o : business.getOrganizationDirectory().getOrganizationDirectory()){
            if(o.getOrganizationName().equals(Organization.TypeOfOrg.Supplier.getValue())){
                    employeeDirectory = o.getEmployeeDirectory();
            }
        }
        customerName.setText("Welcome :"+customer.getName());
        if(!isCheckedOut){
        order = new Order();
        }
        populateSupplierCombox();
        populateProductTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmbSupplierJComboBox = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProductTable = new javax.swing.JTable();
        txtProductName = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        searchJButton = new javax.swing.JButton();
        spnQtySpinner = new javax.swing.JSpinner();
        addCartjButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        orderJTable = new javax.swing.JTable();
        checkOutJButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtModifyQuantity = new javax.swing.JTextField();
        btnModify = new javax.swing.JButton();
        btnViewProduct = new javax.swing.JButton();
        customerName = new javax.swing.JLabel();
        removeBtn = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();

        cmbSupplierJComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbSupplierJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbSupplierJComboBoxActionPerformed(evt);
            }
        });

        tblProductTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product Name", "Price", "Availibility"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblProductTable);
        if (tblProductTable.getColumnModel().getColumnCount() > 0) {
            tblProductTable.getColumnModel().getColumn(0).setResizable(false);
            tblProductTable.getColumnModel().getColumn(1).setResizable(false);
            tblProductTable.getColumnModel().getColumn(2).setResizable(false);
        }

        jLabel1.setText("Product Name");

        jLabel2.setText("SupplierName");

        searchJButton.setText("Search");
        searchJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchJButtonActionPerformed(evt);
            }
        });

        addCartjButton.setText("Add to Cart");
        addCartjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCartjButtonActionPerformed(evt);
            }
        });

        orderJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product Name", "Quantity", "Unit Price", "Total Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(orderJTable);
        if (orderJTable.getColumnModel().getColumnCount() > 0) {
            orderJTable.getColumnModel().getColumn(0).setResizable(false);
            orderJTable.getColumnModel().getColumn(1).setResizable(false);
            orderJTable.getColumnModel().getColumn(2).setResizable(false);
            orderJTable.getColumnModel().getColumn(3).setResizable(false);
        }

        checkOutJButton.setText("Check Out");
        checkOutJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkOutJButtonActionPerformed(evt);
            }
        });

        jLabel3.setText("Modify Quantity");

        btnModify.setText("Modify");
        btnModify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModifyActionPerformed(evt);
            }
        });

        btnViewProduct.setText("View Product");
        btnViewProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewProductActionPerformed(evt);
            }
        });

        customerName.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N

        removeBtn.setText("Remove");
        removeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeBtnActionPerformed(evt);
            }
        });

        btnBack.setText("<< Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(316, 316, 316)
                        .addComponent(spnQtySpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(btnViewProduct))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(121, 121, 121)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(cmbSupplierJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(38, 38, 38)
                                        .addComponent(customerName, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel1))
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(37, 37, 37))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(135, 135, 135)
                                        .addComponent(removeBtn)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel3)
                                        .addGap(41, 41, 41))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnBack)
                                        .addGap(227, 227, 227)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtModifyQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(checkOutJButton))
                                .addGap(38, 38, 38)
                                .addComponent(btnModify)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(searchJButton))
                            .addComponent(txtProductName, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(301, 301, 301)
                        .addComponent(addCartjButton)))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmbSupplierJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtProductName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(customerName, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)))
                .addComponent(searchJButton)
                .addGap(1, 1, 1)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(spnQtySpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnViewProduct))
                .addGap(18, 18, 18)
                .addComponent(addCartjButton)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtModifyQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModify)
                    .addComponent(removeBtn))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(checkOutJButton)
                        .addContainerGap(31, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBack)
                        .addGap(19, 19, 19))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmbSupplierJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSupplierJComboBoxActionPerformed
        // TODO add your handling code here:
        populateProductTable();
    }//GEN-LAST:event_cmbSupplierJComboBoxActionPerformed

    private void searchJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchJButtonActionPerformed
        // TODO add your handling code here:
        String prodName = txtProductName.getText().trim();
        if(prodName.isEmpty()){
        JOptionPane.showMessageDialog(null, "Please give a product.!!");
            return;
        }
        populateProductTable(prodName);
    }//GEN-LAST:event_searchJButtonActionPerformed

    private void addCartjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCartjButtonActionPerformed
        // TODO add your handling code here: 
        int selectedRow =  tblProductTable.getSelectedRow();
        int quantity = (Integer)spnQtySpinner.getValue();
        if(selectedRow<0){
        JOptionPane.showMessageDialog(null, "Please select a row.!!");
            return;
        }
        Product product = (Product)tblProductTable.getValueAt(selectedRow, 0);
        if(quantity <=0 || quantity > product.getAvailability()){
            JOptionPane.showMessageDialog(null, "Sorry Not Available.!!");
            return;
        }
        
        Boolean isIncluded = false;
        
        for (OrderItem oi  : order.getOrderItemList()) { 
            if(oi.getProduct().getProdName().equals(product.getProdName())){
                int oldQuantity = oi.getQuantity();
                int newQuantity = (Integer)spnQtySpinner.getValue();
                int availibility = product.getAvailability();
                int totalQuantity = oldQuantity + newQuantity;
                //System.out.println("oldquant :"+oldQuantity+"new quantity :"+newQuantity+"availibitliyt :"+availibility+"totalquant :"+totalQuantity);
                oi.setQuantity(totalQuantity);
                int newAvailability = availibility - newQuantity;
                //System.out.println("newAvailibilty :"+newAvailability);
                product.setAvailability(newAvailability);
                isIncluded = true;
            }
        }
            if(!isIncluded){
                OrderItem item = order.addOrderItem();
                item.setProduct(product);
                
                int quantity_notIncluded =  (Integer) spnQtySpinner.getValue();
                item.setQuantity(quantity_notIncluded);
                int new_Availability = product.getAvailability() - quantity_notIncluded;
                product.setAvailability(new_Availability);
            }
        populateOrderItemTable();
        populateProductTable();
    }//GEN-LAST:event_addCartjButtonActionPerformed

    private void checkOutJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkOutJButtonActionPerformed
        // TODO add your handling code here:
        Order o = moc.addOrder(order);
        //customer.addOrder(order);
        
        OrderWorkRequest owr = new OrderWorkRequest();
        owr.setOrder(order);
        owr.setSender(userAccount);
        owr.setStatus(WorkRequest.Status.SENT.getValue());
        userAccount.getWorkQueue().getWorkRequests().add(owr);
        
        
        for(Organization orgn: business.getOrganizationDirectory().getOrganizationDirectory()){
            if(orgn instanceof SalesSpecialistOrganization){
                orgn.getWorkQueue().getWorkRequests().add(owr);
            }
        }
        
        if(o != null){
        setSoldQuantity();
        JOptionPane.showMessageDialog(null, "You have successfully checked out.!!");
        }
        else{
        JOptionPane.showMessageDialog(null, "Checked out Errrr.!!");
        return;
        }
        isCheckedOut = true;
        order = new Order();
        txtModifyQuantity.setText("");
        populateOrderItemTable();
        populateProductTable();
    }//GEN-LAST:event_checkOutJButtonActionPerformed

    private void btnModifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModifyActionPerformed
        // TODO add your handling code here:
        if(txtModifyQuantity.getText().trim().length() == 0){
            JOptionPane.showMessageDialog(null, "Please enter some value.!!");
            return;
        }
        try{
        
        int selectedRow = orderJTable.getSelectedRow();
        
        if(selectedRow<0){
            JOptionPane.showMessageDialog(null, "Please select a row.!!");
            return;
        }
        
        int modifyQuantity = Integer.parseInt(txtModifyQuantity.getText());
        if(modifyQuantity<0){
            JOptionPane.showMessageDialog(null, "Please enter a valid quantity.!!");
            return;
        }
        
        
       OrderItem oi = (OrderItem) orderJTable.getValueAt(selectedRow, 0);
        if(modifyQuantity == oi.getQuantity()){
            JOptionPane.showMessageDialog(null, "Entered value is same as designated quantity.!!");
            return;
        }
            for (Employee person :  employeeDirectory.getEmployeeList()) {
                Supplier supplier = (Supplier) person;
                for (Product product : supplier.getProductCatalog().getProductCatalog()) {
                    if(product.getProdName().equalsIgnoreCase(oi.getProduct().getProdName())){
                        int oldAvailabilty = product.getAvailability();
                        int orderedQuantity = oi.getQuantity();
                        int totalQuantity = oldAvailabilty + orderedQuantity;
                        if(modifyQuantity <= totalQuantity){
                            oi.setQuantity(modifyQuantity);
                            product.setAvailability(totalQuantity-modifyQuantity);                     
//                        if(oi.getQuantity()==0){
//                        order.removeOrderItem(oi);
//                        }
                        }
                        else{
                            JOptionPane.showMessageDialog(null,"Sorry quantity not available.!!");
                            return;
                        }
                    }
                }
            }
        txtModifyQuantity.setText("");
        populateProductTable();
        populateOrderItemTable();
        }
        catch(NumberFormatException nfe){
            JOptionPane.showMessageDialog(null, "Please enter a valid quantity.!!");
        }
    }//GEN-LAST:event_btnModifyActionPerformed

    private void btnViewProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewProductActionPerformed
        // TODO add your handling code here:
        int selectedRow =  tblProductTable.getSelectedRow();
        if(selectedRow<0){
        JOptionPane.showMessageDialog(null, "Please select a row.!!");
            return;
        }
        Product product = (Product)tblProductTable.getValueAt(selectedRow, 0);
        ViewProductDetailsJPanel detailsJPanel = new ViewProductDetailsJPanel(userProcessContainer, product);
        userProcessContainer.add("ViewProductDetailsJPanel", detailsJPanel);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnViewProductActionPerformed

    private void removeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeBtnActionPerformed
        // TODO add your handling code here:
         int selectedRow =  orderJTable.getSelectedRow();
        if(selectedRow<0){
            JOptionPane.showMessageDialog(null, "Please select a row.!!");
            return;
        }
        OrderItem item = (OrderItem)orderJTable.getValueAt(selectedRow, 0);
        item.getProduct().setAvailability(item.getProduct().getAvailability()+item.getQuantity());
        order.removeOrderItem(item);
        
        populateProductTable();
        populateOrderItemTable();
    }//GEN-LAST:event_removeBtnActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        for (OrderItem item : order.getOrderItemList()) {
           item.getProduct().setAvailability(item.getProduct().getAvailability()+item.getQuantity()); 
        }
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    public void populateSupplierCombox(){
        cmbSupplierJComboBox.removeAllItems();
        for (Employee person : employeeDirectory.getEmployeeList()) {
            cmbSupplierJComboBox.addItem(person);
        }
    }

    public void populateProductTable(){
        Supplier supplier = (Supplier)cmbSupplierJComboBox.getSelectedItem();
        DefaultTableModel tableModel = (DefaultTableModel)tblProductTable.getModel();
        tableModel.setRowCount(0);
        if(supplier != null){
            for (Product product : supplier.getProductCatalog().getProductCatalog()) {
                Object rows[] = new Object[3];
                rows[0] = product;
                rows[1] = product.getPrice();
                rows[2] = product.getAvailability();
                
                tableModel.addRow(rows);
            }
        }
    }
    
    public void populateOrderItemTable(){
        DefaultTableModel tableModel = (DefaultTableModel)orderJTable.getModel();
        tableModel.setRowCount(0);
        for (OrderItem oi : order.getOrderItemList()) {
              
                  Object rows[] = new Object[4];
                  rows[0] = oi;
                  rows[1] = oi.getQuantity();
                  rows[2] = oi.getProduct().getPrice();
                  rows[3] = ((oi.getQuantity())*(oi.getProduct().getPrice()));
                  
                  tableModel.addRow(rows);
              
        }
    }
    
    public void populateProductTable(String prodName){
        
        DefaultTableModel tableModel = (DefaultTableModel)tblProductTable.getModel();
        tableModel.setRowCount(0);
        boolean found=false;
        for (Employee person: employeeDirectory.getEmployeeList()) {
                Supplier supplier = (Supplier) person;
            for (Product product : supplier.getProductCatalog().getProductCatalog()) {
              if(prodName.equalsIgnoreCase(product.getProdName())){
                  Object rows[] = new Object[3];
                  rows[0] = product;
                  rows[1] = product.getPrice();
                  rows[2] = product.getAvailability();
                  
                  tableModel.addRow(rows);
                  found =  true;
              }
            }
        }
        if(!found){
            JOptionPane.showMessageDialog(null, "No Search Results..!!!");
        }
    }
    
    public void setSoldQuantity(){
        
        for (OrderItem orderItem : order.getOrderItemList()) {
            int previousQuantity = orderItem.getProduct().getSoldQuantity();
            orderItem.getProduct().setSoldQuantity(previousQuantity + orderItem.getQuantity());
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addCartjButton;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnModify;
    private javax.swing.JButton btnViewProduct;
    private javax.swing.JButton checkOutJButton;
    private javax.swing.JComboBox cmbSupplierJComboBox;
    private javax.swing.JLabel customerName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable orderJTable;
    private javax.swing.JButton removeBtn;
    private javax.swing.JButton searchJButton;
    private javax.swing.JSpinner spnQtySpinner;
    private javax.swing.JTable tblProductTable;
    private javax.swing.JTextField txtModifyQuantity;
    private javax.swing.JTextField txtProductName;
    // End of variables declaration//GEN-END:variables
}
