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
public class SupplyRequest extends javax.swing.JFrame {

    /**
     * Creates new form ShowList
     */
    public SupplyRequest(int farmer_id) {
        initComponents();
        this.setLocationRelativeTo(null);
        
        priceTbl.getTableHeader().setFont(new Font("Arial", Font.BOLD, 18));

        createConnection();
        
        LoadTable();
        Search();
        
        farmerID = farmer_id;
    }
    int farmerID;
    
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
                try {
                        DefaultTableModel tm = (DefaultTableModel) priceTbl.getModel();
                        
                        Statement stmt;
                        stmt = con.createStatement();
                        ResultSet rs =  stmt.executeQuery("SELECT * FROM supply_price_list");
                            while(rs.next()){
                                 int supplyID = rs.getInt("supply_id");
                                 String name = rs.getString("supply_name");
                                 String quantity = rs.getString("quantity");
                                 String price = rs.getString("supply_price");
                                 tm.addRow(new Object[]{supplyID,name,quantity,price});
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
        supplyIDField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        requestBtn = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        quantityField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        priceTbl = new javax.swing.JTable();
        requestBtn1 = new javax.swing.JButton();
        requestBtn2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        searchField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(97, 136, 142));
        jPanel1.setPreferredSize(new java.awt.Dimension(1106, 692));

        supplyIDField.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        jLabel2.setText("Supply ID:");

        requestBtn.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        requestBtn.setText("Request");
        requestBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requestBtnActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        jLabel4.setText("Quantity:");

        quantityField.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        priceTbl.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        priceTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Supply ID", "Supply name", "Quantity", "Price"
            }
        ));
        priceTbl.setRowHeight(30);
        priceTbl.setRowMargin(0);
        jScrollPane1.setViewportView(priceTbl);
        if (priceTbl.getColumnModel().getColumnCount() > 0) {
            priceTbl.getColumnModel().getColumn(0).setPreferredWidth(20);
        }

        requestBtn1.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        requestBtn1.setText("Back");
        requestBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requestBtn1ActionPerformed(evt);
            }
        });

        requestBtn2.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        requestBtn2.setText("Logout");
        requestBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requestBtn2ActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(68, 83, 83));

        jLabel5.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(240, 240, 240));
        jLabel5.setText("1 Unit = 1 Kg / 1 Litre");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(20, 20, 20))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel5)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        jLabel6.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        jLabel6.setText("Search:");

        searchField.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        searchField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(requestBtn1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(226, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addGap(42, 42, 42)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(401, 401, 401)
                        .addComponent(requestBtn2)))
                .addGap(31, 31, 31))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(80, 80, 80)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(requestBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(quantityField, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(supplyIDField, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(requestBtn1)
                    .addComponent(requestBtn2))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(quantityField, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(supplyIDField, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(requestBtn)
                    .addComponent(jLabel6)
                    .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
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

    private void requestBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_requestBtnActionPerformed
        int supplyID = Integer.parseInt(supplyIDField.getText());
        int Quantity = Integer.parseInt(quantityField.getText());
        
        try {
            //to get the price of the supply
                Statement s;
                s = con.createStatement();
                ResultSet rs =  s.executeQuery("SELECT * FROM supply_price_list WHERE supply_id = '"+supplyID+"'");
                while(rs.next()){
                     int pricePerQuantity = rs.getInt("supply_price");
                     
                     //To calculate total payable amount
                     int totalPrice = pricePerQuantity * Quantity;
                     
                     //To insert the order into the database
                    Statement stmt = con.createStatement();
                    String inserQuery = ("INSERT INTO `auctionappdb`.`supply_order_tbl` (`farmer_id`, `supply_id`, `quantity`, `total_price`) VALUES ('"+farmerID+"', '"+supplyID+"','"+quantityField.getText()+"','"+totalPrice+"');");
                    stmt.execute(inserQuery);
                    stmt.close();
                 }

                     s.close();
            
            JOptionPane.showMessageDialog(null, "Ordered Successfully!", "Click OK to proceed...", 1);
            new FarmerLanding(farmerID).setVisible(true);
            this.dispose();
        } catch (SQLException ex) {
            Logger.getLogger(SupplyRequest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_requestBtnActionPerformed

    private void requestBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_requestBtn1ActionPerformed
        new FarmerLanding(farmerID).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_requestBtn1ActionPerformed

    private void requestBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_requestBtn2ActionPerformed
        new Login().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_requestBtn2ActionPerformed

    private void searchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchFieldActionPerformed
        // TODO add your handling code here:
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
            java.util.logging.Logger.getLogger(SupplyRequest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SupplyRequest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SupplyRequest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SupplyRequest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new SupplyRequest().setVisible(true);
//            }
//        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable priceTbl;
    private javax.swing.JTextField quantityField;
    private javax.swing.JButton requestBtn;
    private javax.swing.JButton requestBtn1;
    private javax.swing.JButton requestBtn2;
    private javax.swing.JTextField searchField;
    private javax.swing.JTextField supplyIDField;
    // End of variables declaration//GEN-END:variables
}
