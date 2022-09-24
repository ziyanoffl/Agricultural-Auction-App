/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

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
public class MillerSellStock extends javax.swing.JFrame {

    /**
     * Creates new form ShowList
     */
    public MillerSellStock(int miller_id, String username) {
        initComponents();
        this.setLocationRelativeTo(null);
        createConnection();
        
        userLbl.setText(username);
        
        //to load the table
        DefaultTableModel tm = (DefaultTableModel) itemTbl.getModel();
           try {
               Statement stmt;
               stmt = con.createStatement();
               ResultSet rs =  stmt.executeQuery("SELECT * FROM auction_receipt_tbl WHERE miller_id = '"+miller_id+"' AND status = 'In stock'");
               while(rs.next()){
                    int itemID = rs.getInt("item_id");
                    String itemName = rs.getString("item_name");
                    tm.addRow(new Object[]{itemID,itemName});
                }
           
                stmt.close();

        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        millerID = miller_id;
        userName = userName;
        
        
    }
    String millerCheck = "Not milled";
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

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        sellBtn = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        itemTbl = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        userLbl = new javax.swing.JLabel();
        milledCheck = new javax.swing.JCheckBox();
        homeBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(97, 136, 142));
        jPanel1.setPreferredSize(new java.awt.Dimension(1106, 692));

        sellBtn.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        sellBtn.setText("Sell to AC Agency");
        sellBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sellBtnActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel4.setText("Logged in as:");

        itemTbl.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        itemTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item ID", "Item name"
            }
        ));
        itemTbl.setRowHeight(30);
        itemTbl.setRowMargin(0);
        jScrollPane1.setViewportView(itemTbl);

        jButton2.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jButton2.setText("Logout");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        userLbl.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        userLbl.setText("User");

        milledCheck.setBackground(new java.awt.Color(97, 136, 142));
        milledCheck.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        milledCheck.setText("Milled");
        milledCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                milledCheckActionPerformed(evt);
            }
        });

        homeBtn.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        homeBtn.setText("Home");
        homeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 86, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 725, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(77, 77, 77))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(milledCheck)
                                .addGap(402, 402, 402))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(sellBtn)
                                .addGap(347, 347, 347))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(userLbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(homeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(userLbl))
                        .addGap(30, 30, 30))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(homeBtn)
                        .addGap(18, 18, 18)))
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(milledCheck)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sellBtn)
                .addGap(68, 68, 68))
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

    private void sellBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sellBtnActionPerformed
        try {
            DefaultTableModel tm = (DefaultTableModel) itemTbl.getModel();
            int row = itemTbl.getSelectedRow();
            
            int itemID = (int) tm.getValueAt(row, 0);
            String itemName = (String) tm.getValueAt(row, 1);
            
            //to get the item price from the retail_price_tbl
               Statement stmt;
               stmt = con.createStatement();
               ResultSet rs =  stmt.executeQuery("SELECT * FROM retail_price_tbl WHERE item_name = '"+itemName+"'");
               while(rs.next()){
                    int pricePerUnit = rs.getInt("item_price");
                    
                    //to get the quantity of the item
                       Statement s;
                       s = con.createStatement();
                       ResultSet resultSet =  s.executeQuery("SELECT * FROM auction_receipt_tbl WHERE item_id = '"+itemID+"'");
                           while(resultSet.next()){
                                String quantity = resultSet.getString("item_quantity");

                                //to get the int from quantity
                                String numberOnly= quantity.replaceAll("[^0-9]", "");
                                int itemQuantity = Integer.parseInt(numberOnly);
                                
                                //to calculate the final price
                                int finalPrice = pricePerUnit * itemQuantity;
                                
                                //to enter it to the ac_agency_stock_tbl in the database
                                Statement st = con.createStatement();
                                if(millerCheck.equals("Milled")){
                                    String insertQuery = ("INSERT INTO `auctionappdb`.`ac_agency_stock` (`item_id`, `item_name`, `miller_id`, `item_quantity`, `retail_price`) VALUES ('"+itemID+"', '"+millerCheck+" "+itemName+"', '"+millerID+"', '"+quantity+"', '"+finalPrice+"');");
                                    st.execute(insertQuery);
                                }else{
                                    String insertQuery = ("INSERT INTO `auctionappdb`.`ac_agency_stock` (`item_id`, `item_name`, `miller_id`, `item_quantity`, `retail_price`) VALUES ('"+itemID+"', '"+itemName+"', '"+millerID+"', '"+quantity+"', '"+finalPrice+"');");
                                    st.execute(insertQuery);
                                }
                                //to update the auction_receipt_tbl
                                Statement sl = con.createStatement();
                                String updateq = ("UPDATE `auctionappdb`.`auction_receipt_tbl` SET `status` = 'Sold' WHERE (`item_id` = '"+itemID+"');");
                                sl.executeUpdate(updateq);

                                JOptionPane.showMessageDialog(null, "Transaction successful!", "Click OK to proceed....", 1);
                            }
                }
           
                stmt.close();
            
            new MillerLanding(millerID, userName).setVisible(true);
            this.dispose();

        } catch(ArrayIndexOutOfBoundsException e){
            JOptionPane.showMessageDialog(null, "Select a row from the table!", "Error!" ,1);
        } catch (SQLException ex) {
            Logger.getLogger(MillerSellStock.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_sellBtnActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        new Login().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    //This checkbox is to for miller to specify whether the product has been milled or not
    private void milledCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_milledCheckActionPerformed
        if (milledCheck.isSelected()) {
                millerCheck = "Milled";
            } else {
                millerCheck = "Not milled";
            }
    }//GEN-LAST:event_milledCheckActionPerformed

    private void homeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeBtnActionPerformed
        new MillerLanding(millerID, userName).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_homeBtnActionPerformed

    
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
            java.util.logging.Logger.getLogger(MillerSellStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MillerSellStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MillerSellStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MillerSellStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
//                new MillerSellStock().setVisible(true);
//            }
//        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton homeBtn;
    private javax.swing.JTable itemTbl;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JCheckBox milledCheck;
    private javax.swing.JButton sellBtn;
    private javax.swing.JLabel userLbl;
    // End of variables declaration//GEN-END:variables
}
