/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package UserInterface.ShippingSpecialistRole;

import Business.Business;
import Business.Organization.Organization;
import Business.Organization.ShippingSpecialistOrganization;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import static javax.management.Query.or;
import javax.swing.JPanel;

/**
 *
 * @author Praneeth Reddy
 */
public class ShippingSpecialistWorkAreaPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private Business business;
    private UserAccount userAccount;
    private ShippingSpecialistOrganization ssOrganization;
    
    /**
     * Creates new form ShippingSpecialistJPanel
     */
    public ShippingSpecialistWorkAreaPanel(JPanel userProcessContainer, Business business,Organization organization,UserAccount userAccount) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.business = business;
        ssOrganization = (ShippingSpecialistOrganization)organization;
        this.userAccount = userAccount;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnOrderHistory = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel1.setText("Shipping Specialist Work Area");

        btnOrderHistory.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnOrderHistory.setText("Ship Requested Orders >>");
        btnOrderHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrderHistoryActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(85, Short.MAX_VALUE)
                .addComponent(btnOrderHistory)
                .addGap(70, 70, 70))
            .addGroup(layout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addGap(52, 52, 52)
                .addComponent(btnOrderHistory)
                .addContainerGap(169, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnOrderHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrderHistoryActionPerformed
        // TODO add your handling code here:
        ShipApprovedOrdersPanel panel = new ShipApprovedOrdersPanel(userProcessContainer,ssOrganization,userAccount);
        userProcessContainer.add("ShipApprovedOrdersPanel",panel);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnOrderHistoryActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOrderHistory;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
