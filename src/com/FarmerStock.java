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
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Ziyan
 */
public class FarmerStock extends javax.swing.JFrame {

    /**
     * Creates new form ShowList
     */
    public FarmerStock(int farmer_id) {
        initComponents();
        this.setLocationRelativeTo(null);
        createConnection();
        
        stockTbl.getTableHeader().setFont(new Font("Arial", Font.BOLD, 18));
        
        farmerID = farmer_id;
    }
    
    int farmerID;
    String highestBid;
    int highestBidder;
    
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

    public void LoadTable(){

        TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(stockTbl.getModel());

        stockTbl.setRowSorter(rowSorter);

//                searchField.getDocument().addDocumentListener(new DocumentListener(){
//
//                        @Override
//                        public void insertUpdate(DocumentEvent e) {
//                            String text = searchField.getText();
//
//                            if (text.trim().length() == 0) {
//                                rowSorter.setRowFilter(null);
//                            } else {
//                                rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
//                            }
//                        }
//
//                        @Override
//                        public void removeUpdate(DocumentEvent e) {
//                            String text = searchField.getText();
//
//                            if (text.trim().length() == 0) {
//                                rowSorter.setRowFilter(null);
//                            } else {
//                                rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
//                            }
//                        }
//
//                        @Override
//                        public void changedUpdate(DocumentEvent e) {
//                            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//                        }
//
//                    });

            try {
                DefaultTableModel tm = (DefaultTableModel) stockTbl.getModel();//user_table: variable name or our table

                Statement stmt;
                stmt = con.createStatement();
                ResultSet rs =  stmt.executeQuery("SELECT * FROM auctionappdb.farmer_item_tbl WHERE farmer_id = '"+farmerID+"';");
                    while(rs.next()){
                         int itemID = rs.getInt("item_id");
                         String itemName = rs.getString("item_name");
                         String itemQuantity = rs.getString("item_quantity");
                         int highestBid = rs.getInt("highest_bid");
                         tm.addRow(new Object[]{itemID,itemName,itemQuantity,highestBid});
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
        viewAuctionBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        stockTbl = new javax.swing.JTable();
        backBtn = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        addItemBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(97, 136, 142));
        jPanel1.setPreferredSize(new java.awt.Dimension(1106, 692));

        viewAuctionBtn.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        viewAuctionBtn.setText("View Auction");
        viewAuctionBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewAuctionBtnActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(240, 240, 240));
        jLabel1.setText("Farmer Stock");

        stockTbl.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        stockTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item ID", "Item", "Quantity", "Highest Bid"
            }
        ));
        stockTbl.setRowHeight(25);
        stockTbl.setRowMargin(0);
        jScrollPane1.setViewportView(stockTbl);

        backBtn.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        backBtn.setText("Back");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jButton3.setText("Logout");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        addItemBtn.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        addItemBtn.setText("Add Item");
        addItemBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addItemBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 767, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(64, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(viewAuctionBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addItemBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(364, 364, 364))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(backBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(187, 187, 187)
                .addComponent(jButton3)
                .addGap(65, 65, 65))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(backBtn)
                    .addComponent(jButton3)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(viewAuctionBtn)
                .addGap(27, 27, 27)
                .addComponent(addItemBtn)
                .addGap(48, 48, 48))
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

    //this button is used to view the auction in another jframe by passing the values to it
    private void viewAuctionBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewAuctionBtnActionPerformed
        try {
            DefaultTableModel tm = (DefaultTableModel) stockTbl.getModel();
            int row = stockTbl.getSelectedRow();

            int itemID = (int) tm.getValueAt(row, 0);
            String itemName = (String) tm.getValueAt(row, 1);
            String itemQuantity = (String) tm.getValueAt(row, 2);
            int highestBid = (int) tm.getValueAt(row, 3);
            
            Statement stmt;
            stmt = con.createStatement();
            ResultSet rs =  stmt.executeQuery("SELECT * FROM auctionappdb.farmer_item_tbl WHERE farmer_id = '"+farmerID+"' AND item_id = '"+itemID+"';");
                while(rs.next()){

                int highestBidder = rs.getInt("miller_id");
                int startingPrice = rs.getInt("starting_price");

            ViewAuction obj = new ViewAuction(farmerID, itemID, itemName, startingPrice, highestBid, highestBidder, itemQuantity);

            obj.setVisible(true);
            this.dispose();
                
            }
           
                stmt.close();

        } catch(ArrayIndexOutOfBoundsException e){ //to catch the error when a row is not selected from the table
            JOptionPane.showMessageDialog(null, "Select a row from the table!", "Error!" ,1);
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }//GEN-LAST:event_viewAuctionBtnActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        FarmerLanding Obj = new FarmerLanding(farmerID);
        Obj.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backBtnActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        new Login().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void addItemBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addItemBtnActionPerformed
        AddFarmerItem Obj = new AddFarmerItem(farmerID);
        Obj.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_addItemBtnActionPerformed

    
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
            java.util.logging.Logger.getLogger(FarmerStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FarmerStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FarmerStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FarmerStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addItemBtn;
    private javax.swing.JButton backBtn;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable stockTbl;
    private javax.swing.JButton viewAuctionBtn;
    // End of variables declaration//GEN-END:variables
}
