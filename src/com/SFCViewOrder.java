/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ziyan
 */
public class SFCViewOrder extends javax.swing.JFrame {
    
    
    public SFCViewOrder(String username, int sfc_id) {
        initComponents();
        this.setLocationRelativeTo(null);
        createConnection();
        LoadTable();
        
        
        Username = username;
        sfcID = sfc_id;
    }
    String Username;
    int sfcID;
    
        Connection con;
    
            void createConnection(){
                try{
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/auctionappdb","root","123456789");}
                catch (ClassNotFoundException ex){
                    Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE,null,ex);
                        }
                catch (SQLException ex) {
                    Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
                        }
            }
            void LoadTable(){
                //This is to load the order table
                try {
                   DefaultTableModel tm = (DefaultTableModel) orderTbl.getModel();
                   Statement stmt;
                   stmt = con.createStatement();
                   ResultSet rs =  stmt.executeQuery("SELECT * FROM supply_order_tbl");
                   while(rs.next()){
                        int orderID = rs.getInt("order_id");
                        int farmerID = rs.getInt("farmer_id");
                        int supplyID = rs.getInt("supply_id");
                        int quantity = rs.getInt("quantity");
                        String status = rs.getString("status");
                        int totalPrice = rs.getInt("total_price");
                        tm.addRow(new Object[]{orderID,supplyID,farmerID,quantity,totalPrice,status});
                    }

                        stmt.close();

                } catch (SQLException ex) {
                    Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        acceptBtn = new javax.swing.JButton();
        rejectBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        orderTbl = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        backBtn = new javax.swing.JButton();
        logoutBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(97, 136, 142));
        jPanel1.setPreferredSize(new java.awt.Dimension(1106, 692));

        acceptBtn.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        acceptBtn.setText("Accept Order");
        acceptBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acceptBtnActionPerformed(evt);
            }
        });

        rejectBtn.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        rejectBtn.setText("Reject Order");
        rejectBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rejectBtnActionPerformed(evt);
            }
        });

        orderTbl.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        orderTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Order ID", "Supply ID", "Farmer ID", "Quantity", "Total Price", "Status"
            }
        ));
        orderTbl.setRowHeight(25);
        orderTbl.setRowMargin(0);
        jScrollPane1.setViewportView(orderTbl);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 28)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(240, 240, 240));
        jLabel3.setText("Orders");

        backBtn.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        backBtn.setText("Back");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        logoutBtn.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        logoutBtn.setText("Logout");
        logoutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(rejectBtn)
                        .addGap(30, 30, 30)
                        .addComponent(acceptBtn))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(backBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(logoutBtn))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 784, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backBtn)
                    .addComponent(logoutBtn))
                .addGap(87, 87, 87)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(acceptBtn)
                    .addComponent(rejectBtn))
                .addContainerGap(59, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 890, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void acceptBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acceptBtnActionPerformed
        try {
            DefaultTableModel tm = (DefaultTableModel) orderTbl.getModel();
            int row = orderTbl.getSelectedRow();
            int orderId = (int) tm.getValueAt(row, 0);
            
            Statement stmt = con.createStatement();
            
                String updateQ = ("UPDATE supply_order_tbl SET status = 'Accepted' WHERE order_id ='"+orderId+"'");
                JOptionPane.showMessageDialog(null, "Order accepted Succesfully!", "Click OK to proceed", 1);
                
                stmt.execute(updateQ);
                
                new SFCLanding(Username,sfcID).setVisible(true);
                this.dispose();
        } catch (SQLException ex) {
            Logger.getLogger(SFCViewOrder.class.getName()).log(Level.SEVERE, null, ex);
        }
                
        
    }//GEN-LAST:event_acceptBtnActionPerformed

    private void rejectBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rejectBtnActionPerformed
        try {
            DefaultTableModel tm = (DefaultTableModel) orderTbl.getModel();
            int row = orderTbl.getSelectedRow();
            int orderId = (int) tm.getValueAt(row, 0);
            
            Statement stmt = con.createStatement();
            
                String updateQ = ("UPDATE supply_order_tbl SET status = 'Rejected' WHERE order_id ='"+orderId+"'");
                JOptionPane.showMessageDialog(null, "Order Rejected!", "Click OK to proceed", 1);
                stmt.execute(updateQ);
                
                new SFCLanding(Username,sfcID).setVisible(true);
                this.dispose();
        } catch (SQLException ex) {
            Logger.getLogger(SFCViewOrder.class.getName()).log(Level.SEVERE, null, ex);
        } catch(ArrayIndexOutOfBoundsException e){
            JOptionPane.showMessageDialog(null, "Select a row from the table!", "Error!" ,1);
        }
    }//GEN-LAST:event_rejectBtnActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        new SFCLanding(Username, sfcID).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backBtnActionPerformed

    private void logoutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutBtnActionPerformed
        new Login().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_logoutBtnActionPerformed

    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SFCViewOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SFCViewOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SFCViewOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SFCViewOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new SFCViewOrder().setVisible(true);
//            }
//        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton acceptBtn;
    private javax.swing.JButton backBtn;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton logoutBtn;
    private javax.swing.JTable orderTbl;
    private javax.swing.JButton rejectBtn;
    // End of variables declaration//GEN-END:variables
}
