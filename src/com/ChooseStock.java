/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ziyan
 */
public class ChooseStock extends javax.swing.JFrame {

    /**
     * Creates new form ShowList
     */
    public ChooseStock(int farmer_id, int miller_id, String username) {
        initComponents();
        this.setLocationRelativeTo(null);
        auctionTbl.getTableHeader().setFont(new Font("Arial", Font.BOLD, 18));
        farmerID = farmer_id;
        millerID = miller_id;
        userName = username;
        createConnection();
    }
        int farmerID;
        int millerID;
        String userName;
    
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
        
        public void LoadTbl(){
            try {
                DefaultTableModel tm = (DefaultTableModel) auctionTbl.getModel();//user_table: variable name or our table

                Statement stmt;
                stmt = con.createStatement();
                ResultSet rs =  stmt.executeQuery("SELECT * FROM auctionappdb.farmer_item_tbl WHERE farmer_id = '"+farmerID+"' AND status = 'Ongoing';");
                    while(rs.next()){
                         int auctionID = rs.getInt("item_id");
                         String itemName = rs.getString("item_name");
                         String itemQuantity = rs.getString("item_quantity");
                         int highestBid = rs.getInt("highest_bid");
                         tm.addRow(new Object[]{auctionID,itemName,itemQuantity,highestBid});
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
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        auctionTbl = new javax.swing.JTable();
        bidBtn = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(97, 136, 142));
        jPanel1.setPreferredSize(new java.awt.Dimension(1106, 692));

        jButton1.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jButton1.setText("Logout");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(240, 240, 240));
        jLabel3.setText("Farmer Stocks");

        auctionTbl.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        auctionTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Auction ID", "Item", "Quantity", "Highest Bid"
            }
        ));
        auctionTbl.setRowHeight(25);
        auctionTbl.setRowMargin(0);
        jScrollPane1.setViewportView(auctionTbl);

        bidBtn.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        bidBtn.setText("Bid Auction");
        bidBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bidBtnActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jButton3.setText("Back");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 767, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 74, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(370, 370, 370)
                .addComponent(bidBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(231, 231, 231)
                .addComponent(jButton1)
                .addGap(28, 28, 28))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton3)
                    .addComponent(jLabel3))
                .addGap(139, 139, 139)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(bidBtn)
                .addContainerGap(49, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JOptionPane.showMessageDialog(null, "Click OK to Proceed....", "Logout Successful!", 1);
        new Login().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void bidBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bidBtnActionPerformed
        try {
                DefaultTableModel tm = (DefaultTableModel) auctionTbl.getModel();//user_table: variable name or our table

                
                int row = auctionTbl.getSelectedRow();
                int auctionID = (int) tm.getValueAt(row, 0);
                String itemName = (String) tm.getValueAt(row, 1);
                String itemQuantity = (String) tm.getValueAt(row, 2);
                int highestBid = (int) tm.getValueAt(row, 3);
                
                         
                         
                         MillerBidAuction obj = new MillerBidAuction(farmerID, millerID, auctionID, itemName, itemQuantity, highestBid,userName);
                         obj.setVisible(true);
                    
                    
                    
                        this.dispose();
                   
                
            
        } catch(ArrayIndexOutOfBoundsException e){
            JOptionPane.showMessageDialog(null, "Select a row from the table!", "Error!" ,1);
        } 

        
    }//GEN-LAST:event_bidBtnActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        new ChooseFarmer(millerID, userName).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    
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
            java.util.logging.Logger.getLogger(ChooseStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChooseStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChooseStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChooseStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new ChooseStock().setVisible(true);
//            }
//        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable auctionTbl;
    private javax.swing.JButton bidBtn;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
