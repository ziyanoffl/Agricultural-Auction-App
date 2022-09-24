/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
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
public class AddSupplyPrice extends javax.swing.JFrame {

    public AddSupplyPrice(String username, int sfc_id) {
        initComponents();
        this.setLocationRelativeTo(null);
        createConnection();
        LoadTable();
        Search();
        
        sfcID = sfc_id;
        userName = username;
        
        priceTbl.getTableHeader().setFont(new Font("Arial", Font.BOLD, 18));
    }
    int sfcID;
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
            
            void LoadTable(){
                //This is to load the table when the jframe is opened
                DefaultTableModel tm = (DefaultTableModel) priceTbl.getModel();
                   try {Statement stmt;
                   stmt = con.createStatement();
                   ResultSet rs =  stmt.executeQuery("SELECT * FROM supply_price_list;");
                   while(rs.next()){
                        int supplyID = rs.getInt("supply_id");
                        String supplyName = rs.getString("supply_name");
                        String supplyPrice = rs.getString("supply_price");
                        String supplyQuantity = rs.getString("quantity");
                        tm.addRow(new Object[]{supplyID,supplyName,supplyQuantity,supplyPrice});
                    }

                        stmt.close();

                } catch (SQLException ex) {
                    Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            void Search(){
                //This is for the search funciton
                TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(priceTbl.getModel());
                
                    priceTbl.setRowSorter(rowSorter);

                    searchField.getDocument().addDocumentListener(new DocumentListener(){

                            @Override
                            public void insertUpdate(DocumentEvent e) {
                                String text = searchField.getText();

                                if (text.trim().length() == 0) {
                                    rowSorter.setRowFilter(null);
                                } else {
                                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                                }
                            }

                            @Override
                            public void removeUpdate(DocumentEvent e) {
                                String text = searchField.getText();

                                if (text.trim().length() == 0) {
                                    rowSorter.setRowFilter(null);
                                } else {
                                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                                }
                            }

                            @Override
                            public void changedUpdate(DocumentEvent e) {
                                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                            }

                    });
            }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        priceTbl = new javax.swing.JTable();
        addBtn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        supplyNameField = new javax.swing.JTextField();
        priceField = new javax.swing.JTextField();
        quantityField = new javax.swing.JTextField();
        logoutBtn = new javax.swing.JButton();
        addBtn2 = new javax.swing.JButton();
        searchField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(97, 136, 142));
        jPanel1.setPreferredSize(new java.awt.Dimension(1106, 692));

        priceTbl.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        priceTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Supply ID", "Supply Name", "Quantity", "Price"
            }
        ));
        priceTbl.setRowHeight(25);
        priceTbl.setRowMargin(0);
        jScrollPane1.setViewportView(priceTbl);

        addBtn.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        addBtn.setText("Add");
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(240, 240, 240));
        jLabel3.setText("Add Supply");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel4.setText("Supply Name:");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel5.setText("Price:");

        jLabel6.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel6.setText("Quantity:");

        supplyNameField.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        supplyNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supplyNameFieldActionPerformed(evt);
            }
        });

        priceField.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        priceField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priceFieldActionPerformed(evt);
            }
        });

        quantityField.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        quantityField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quantityFieldActionPerformed(evt);
            }
        });

        logoutBtn.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        logoutBtn.setText("Logout");
        logoutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutBtnActionPerformed(evt);
            }
        });

        addBtn2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        addBtn2.setText("Back");
        addBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtn2ActionPerformed(evt);
            }
        });

        searchField.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        searchField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchFieldActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel7.setText("Search:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(85, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 728, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(addBtn2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(168, 168, 168)
                        .addComponent(jLabel3)
                        .addGap(224, 224, 224))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(quantityField, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(priceField, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(50, 50, 50)
                                .addComponent(supplyNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(134, 134, 134)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(addBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(logoutBtn))
                .addGap(20, 20, 20))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(logoutBtn)
                    .addComponent(addBtn2))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(supplyNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addBtn))
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(priceField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(quantityField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
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
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        String price = priceField.getText();
        String name = supplyNameField.getText();
        String quantity = quantityField.getText();
        try {
            DefaultTableModel tm = (DefaultTableModel) priceTbl.getModel();
            Statement stmt = con.createStatement();
            String insertQuery = ("INSERT INTO `auctionappdb`.`supply_price_list` (`supply_name`, `supply_price`, `quantity`) VALUES ('"+name+"', '"+price+"', '"+quantity+"');");

            int i = stmt.executeUpdate(insertQuery);
            if(i>0){
                JOptionPane.showMessageDialog(null, "Price added Successfully!", "Click OK to proceed....", 1);
                
                tm.setRowCount(0);
                Statement s;
                s = con.createStatement();
                ResultSet rs =  s.executeQuery("SELECT * FROM supply_price_list;");
                
                while(rs.next()){
                int supply_id = rs.getInt("supply_id");
                String supply_name = rs.getString("supply_name");
                String supply_price = rs.getString("supply_price");
                String supply_quantity = rs.getString("quantity");
                //this is to add the new object to the table
                tm.addRow(new Object[]{supply_id,supply_name,supply_price,supply_quantity});
                }
                s.close();
             }
            stmt.close();
        } catch (SQLIntegrityConstraintViolationException e){
            JOptionPane.showMessageDialog(null, "Price already added for this item!", "Click OK to proceed", 2);
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Please enter correct values in the field!", "Error!", 2);
        }
    }//GEN-LAST:event_addBtnActionPerformed

    private void supplyNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supplyNameFieldActionPerformed
        
    }//GEN-LAST:event_supplyNameFieldActionPerformed

    private void priceFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priceFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_priceFieldActionPerformed

    private void quantityFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quantityFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_quantityFieldActionPerformed

    private void logoutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutBtnActionPerformed
        new Login().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_logoutBtnActionPerformed

    private void addBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtn2ActionPerformed
        new SFCLanding(userName, sfcID).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_addBtn2ActionPerformed

    private void searchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchFieldActionPerformed

    }//GEN-LAST:event_searchFieldActionPerformed

    
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
            java.util.logging.Logger.getLogger(AddSupplyPrice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddSupplyPrice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddSupplyPrice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddSupplyPrice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
//                new AddSupplyPrice().setVisible(true);
//            }
//        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JButton addBtn2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton logoutBtn;
    private javax.swing.JTextField priceField;
    private javax.swing.JTable priceTbl;
    private javax.swing.JTextField quantityField;
    private javax.swing.JTextField searchField;
    private javax.swing.JTextField supplyNameField;
    // End of variables declaration//GEN-END:variables
}
