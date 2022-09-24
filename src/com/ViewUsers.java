 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import static com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table;
import java.awt.AWTException;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
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
public class ViewUsers extends javax.swing.JFrame {

    /**
     * Creates new form ShowList
     */
    public ViewUsers(int admin_id) {
        initComponents();
        this.setLocationRelativeTo(null);
        createConnection();
        LoadTable();
        adminID = admin_id;
        
        userTbl.getTableHeader().setFont(new Font("Arial", Font.BOLD, 18));
    }
    int adminID;
    
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
            
            //This is the load table
            public void LoadTable(){
                    try {
                        //userTbl is the variable name of the table
                        DefaultTableModel tm = (DefaultTableModel) userTbl.getModel();
                        
                        Statement stmt;
                        stmt = con.createStatement();
                        ResultSet rs =  stmt.executeQuery("SELECT * FROM useraccounttbl");
                            while(rs.next()){
                                 int userID = rs.getInt("user_id");
                                 String name = rs.getString("name");
                                 String accType = rs.getString("account_type");
                                 tm.addRow(new Object[]{userID,name,accType});
                            }
                                stmt.close();

                    } catch (SQLException ex) {
                        Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
                    } 
            }
            
            
//            public void Search(){
//                DefaultTableModel tm = (DefaultTableModel) userTbl.getModel();//user_table: variable name or our table
//                    try {Statement stmt;
//                        stmt = con.createStatement();
//                        ResultSet rs =  stmt.executeQuery("SELECT * FROM useraccounttbl WHERE `name` = '"+searchField.getText()+"';");
//                            while(rs.next()){
//                                 int userID = rs.getInt("user_id");
//                                 String name = rs.getString("name");
//                                 String accType = rs.getString("account_type");
//                                 tm.addRow(new Object[]{userID,name,accType});
//                            }
//                                stmt.close();
//
//                    } catch (SQLException ex) {
//                        Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//            }
//            
            

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        editBtn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        userTbl = new javax.swing.JTable();
        addBtn = new javax.swing.JButton();
        searchField = new javax.swing.JTextField();
        backBtn = new javax.swing.JButton();
        logoutBtn = new javax.swing.JButton();
        searchBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(97, 136, 142));
        jPanel1.setPreferredSize(new java.awt.Dimension(1106, 692));

        editBtn.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        editBtn.setText("Edit User");
        editBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBtnActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(240, 240, 240));
        jLabel3.setText("Users");

        userTbl.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        userTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "User ID", "Name", "Account Type"
            }
        ));
        userTbl.setIntercellSpacing(new java.awt.Dimension(0, 0));
        userTbl.setOpaque(false);
        userTbl.setRowHeight(25);
        userTbl.setShowVerticalLines(false);
        jScrollPane2.setViewportView(userTbl);

        addBtn.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        addBtn.setText("Add User");
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        searchField.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        searchField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchFieldActionPerformed(evt);
            }
        });

        backBtn.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        backBtn.setText("Back");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        logoutBtn.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        logoutBtn.setText("logout");
        logoutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutBtnActionPerformed(evt);
            }
        });

        searchBtn.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        searchBtn.setText("Search");
        searchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(addBtn)
                        .addGap(26, 26, 26)
                        .addComponent(editBtn))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 847, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(searchBtn)
                                        .addGap(0, 102, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(backBtn)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel3)))
                                .addGap(287, 287, 287)
                                .addComponent(logoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(logoutBtn)
                    .addComponent(backBtn)
                    .addComponent(jLabel3))
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchBtn)
                    .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addBtn)
                    .addComponent(editBtn))
                .addContainerGap(92, Short.MAX_VALUE))
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

    private void editBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBtnActionPerformed

        try {
            DefaultTableModel tm = (DefaultTableModel) userTbl.getModel();
            int row = userTbl.getSelectedRow();

            int user_id = (int) tm.getValueAt(row, 0);
            String name = (String) tm.getValueAt(row, 1);
            String userType = (String) tm.getValueAt(row, 2);
            
            Statement stmt;
            stmt = con.createStatement();
            ResultSet rs =  stmt.executeQuery("SELECT * FROM useraccounttbl WHERE user_id = '"+user_id+"'");
            while(rs.next()){
                String address = rs.getString("address");
                int userid = user_id;
                String username = rs.getString("username");
                
                EditUser obj = new EditUser(username, address, userid, adminID);
                obj.setVisible(true);
                this.dispose();
            }
                stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch(ArrayIndexOutOfBoundsException e){
            JOptionPane.showMessageDialog(null, "Select a row from the table!", "Error!" ,1);
        }
    }//GEN-LAST:event_editBtnActionPerformed

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
            new AddUser(adminID).setVisible(true);
            this.dispose();
    }//GEN-LAST:event_addBtnActionPerformed

    private void searchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchFieldActionPerformed

    }//GEN-LAST:event_searchFieldActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
       
        new AdminLanding(adminID).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backBtnActionPerformed

    private void logoutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutBtnActionPerformed
        new Login().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_logoutBtnActionPerformed

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed
        DefaultTableModel tm = (DefaultTableModel) userTbl.getModel();//user_table: variable name or our table
                    try {
                        tm.setRowCount(0);
                        Statement stmt;
                        stmt = con.createStatement();
                        ResultSet rs =  stmt.executeQuery("SELECT * FROM useraccounttbl WHERE `name` = '"+searchField.getText()+"';");
                            while(rs.next()){
                                 int userID = rs.getInt("user_id");
                                 String name = rs.getString("name");
                                 String accType = rs.getString("account_type");
                                
                                 tm.addRow(new Object[]{userID,name,accType});
                            }
                                stmt.close();

                    } catch (SQLException ex) {
                        Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
                    }
    }//GEN-LAST:event_searchBtnActionPerformed

    
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
            java.util.logging.Logger.getLogger(ViewUsers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewUsers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewUsers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewUsers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
      

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new ViewUsers().setVisible(true);
//            }
//        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JButton backBtn;
    private javax.swing.JButton editBtn;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton logoutBtn;
    private javax.swing.JButton searchBtn;
    private javax.swing.JTextField searchField;
    private javax.swing.JTable userTbl;
    // End of variables declaration//GEN-END:variables
}
