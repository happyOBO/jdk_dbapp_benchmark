/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital_management;

import com.sun.org.apache.bcel.internal.generic.GOTO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Sumit
 */
public class SearchEmpInfo extends javax.swing.JFrame {

    /**
     * Creates new form SearchEmpInfo
     */
    public SearchEmpInfo() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jTextField1 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "SEARCH BY", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("Name");

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Employee ID");

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(153, 0, 153));
        jButton3.setText("SEARCH");
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jRadioButton1)
                                    .addComponent(jRadioButton2)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(96, 96, 96)
                                .addComponent(jButton3)))
                        .addGap(0, 116, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jRadioButton1)
                .addGap(1, 1, 1)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jRadioButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jButton3))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Search Employee Details");

        jTable1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Emp ID", "Name", "Gender", "Address", "EmpType", "Date of Joining", "Email ID", "Dept Name", "Salary"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTable1KeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 153, 153));
        jButton1.setText("BACK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 153, 0));
        jButton2.setText("CLEAR FIELDS");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CONTACT INFO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(84, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                    .addComponent(jTextField3))
                .addGap(26, 26, 26))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(418, 418, 418)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(146, 146, 146)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(91, 91, 91)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addContainerGap(86, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(64, 64, 64))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(100, 100, 100)))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(124, 124, 124))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(jButton1)
                        .addGap(54, 54, 54)
                        .addComponent(jButton2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new AdminInfo().setVisible(true);
        this.dispose();// TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        jTextField1.setText(null);
        jRadioButton1.setSelected(true);
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        int rows = model.getRowCount();
        if (rows > 0) {
            for (int i = 0; i < rows; i++) {
                model.removeRow(0);
            }
        }
// TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
         String hg=jTextField1.getText();
         if(hg.equals(""))
         {
             JOptionPane.showMessageDialog(this,"Please Search a valid data value");
         }
         else{
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        try {
            Class.forName("java.sql.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbmsproject", "root", "Sumit");
            Statement stmt = conn.createStatement();
            String str, query, query1, query2, query3;
            ResultSet rs, rs1, rs2, rs3, rs4;
            int eid, i , j;
            if (jRadioButton1.isSelected() == true) {
                str = jTextField1.getText();
                query = "Select empid from employee where fname like \"%" + str + "%\";";
                rs = stmt.executeQuery(query);
                int deptid = 0, k = 0;
                int empidf[] = new int[100];
                if (rs.next()) {
                    rs.previous();
                    i=0;
                    while (rs.next()) {
                        empidf[k] = rs.getInt(1);
                        k++;
                    }
                    for (int x = 0; x < k; x++) {
                        eid = empidf[x];
                        query = "SELECT empid,CONCAT(fname,\" \", mname,\" \", lname),"
                                + "gender,CONCAT(Hno,\" \",Street,\" \", City,\" \",State),emptype,date_of_joining,email,deptid FROM employee WHERE empid=" + eid + ";";
                        rs4 = stmt.executeQuery(query);
                        String etype = "DOCTOR";
                        if (rs4.next()) {
                            model.addRow(new Object[]{"" + rs4.getInt(1), rs4.getString(2), rs4.getString(3), rs4.getString(4), rs4.getString(5),
                                rs4.getString(6), rs4.getString(7)});
                            deptid = rs4.getInt(8);
                            etype = "" + rs4.getString(5);
                        }
                        rs4.close();

                        query = "Select dname from department where deptid=" + deptid + ";";
                        rs2 = stmt.executeQuery(query);

                        if (rs2.next()) {
                            model.setValueAt(rs2.getString(1), model.getRowCount() - 1, 7);
                        }
                        rs2.close();
                        query = "Select salary from salary where etype=\"" + etype + "\";";
                        rs3 = stmt.executeQuery(query);
                        if (rs3.next()) {
                            model.setValueAt(rs3.getFloat(1), model.getRowCount() - 1, 8);
                        }
                        
                    }
                } 
                else
                {
                    i=10;
                }
                 query = "Select empid from employee_inactive where fname like \"%" + str + "%\";";
                  System.out.println(""+query);
                    rs1 = stmt.executeQuery(query);
                if(rs1.next()) {
                   rs1.previous();
                   j=0;
                    while (rs1.next()) {
                        empidf[k] = rs1.getInt(1);
                        k++;
                    }
                    for (int x = 0; x < k; x++) {
                        eid = empidf[x];
                        query = "SELECT empid,CONCAT(fname,\" \", mname,\" \",lname),gender,"
                                + "CONCAT(Hno,\" \", Street, \" \",City,\" \", State),emptype,date_of_joining,email FROM employee_inactive WHERE empid=" + eid + ";";
                        rs4 = stmt.executeQuery(query);
                        String etype = "DOCTOR";
                        if (rs4.next()) {
                            model.addRow(new Object[]{"" + rs4.getInt(1), rs4.getString(2), rs4.getString(3), rs4.getString(4), rs4.getString(5),
                                rs4.getString(6), rs4.getString(7),"NULL"});
                            etype = rs4.getString(5);
                        }
                        query = "Select salary from salary where etype=\"" + etype + "\";";
                        rs3 = stmt.executeQuery(query);
                       
           
                        if (rs3.next()) {
                            System.out.println(""+rs3.getFloat(1));
                            model.setValueAt(rs3.getFloat(1), model.getRowCount() - 1, 8);
                        }
                    }
                }
                else
                {
                    j=10;
                }
              if(i==10 && j==10)
              {
                  i=j=0;
                  JOptionPane.showMessageDialog(null,"Record Not Found!");
              }
            } else if (jRadioButton2.isSelected() == true) {
                eid = Integer.parseInt(jTextField1.getText());
                query = "Select empid from employee where empid=" + eid + ";";
                rs = stmt.executeQuery(query);
                int deptid = 0;
                if (rs.next()) {
                    i=0;
                    query = "SELECT empid,CONCAT(fname,\" \", mname,\" \", lname),"
                            + "gender,CONCAT(Hno,\" \", Street,\" \", City,\" \", State),emptype,date_of_joining,email,deptid FROM employee WHERE empid=" + eid + ";";
                    rs = stmt.executeQuery(query);
                    String etype = "DOCTOR";
                    if (rs.next()) {
                        System.out.println("" + rs.getString(2));
                        model.addRow(new Object[]{"" + rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
                            rs.getString(6), rs.getString(7)});
                        deptid = rs.getInt(8);
                        etype = "" + rs.getString(5);
                    }
                    rs.close();
                    query1 = "Select phoneno from emp_phone where empid=" + eid + ";";
                    rs1 = stmt.executeQuery(query1);

                    if (rs1.next()) {
                        jTextField2.setText("" + rs1.getString(1));
                    }
                    if (rs1.next()) {
                        jTextField3.setText("" + rs1.getString(1));
                    }
                    rs1.close();

                    query = "Select dname from department where deptid=" + deptid + ";";
                    rs2 = stmt.executeQuery(query);
                    if (rs2.next()) {
                        model.setValueAt(rs2.getString(1), model.getRowCount() - 1, 7);
                    }
                    rs2.close();
                    query = "Select salary from salary where etype=\"" + etype + "\";";
                    rs3 = stmt.executeQuery(query);
                    if (rs3.next()) {
                        model.setValueAt(rs3.getFloat(1), model.getRowCount() - 1, 8);
                    }
                       rs.close();
                       rs1.close();
                       rs3.close();
                       rs2.close();
                }
                else
                {
                    i=10;
                }
                query = "Select empid from employee_inactive where empid=" + eid + ";";
                 System.out.println("" +eid);
                rs1 = stmt.executeQuery(query);
                if (rs1.next()) {
                    j=0;
                    rs1.close();
                    query = "SELECT empid,CONCAT(fname, mname, lname),gender,"
                            + "CONCAT(Hno, Street, City, State),emptype,date_of_joining,email FROM employee_inactive WHERE empid=" + eid + ";";
                    rs = stmt.executeQuery(query);
                    String etype = "DOCTOR";
                    if (rs.next()) {
                        System.out.println("" + rs.getString(2));
                        model.addRow(new Object[]{"" + rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
                            rs.getString(6), rs.getString(7),"NULL"});
                        etype =""+rs.getString(5);
                    }
                    rs.close();
                    query1 = "Select phoneno from emp_phone where empid=" + eid + ";";
                    rs1 = stmt.executeQuery(query1);
                    if (rs1.next()) {
                        jTextField2.setText("" + rs1.getString(1));
                    }
                    if (rs1.next()) {
                        jTextField3.setText("" + rs1.getString(1));
                    }
                    query = "Select salary from salary where etype=\"" + etype+ "\";";
                    rs3 = stmt.executeQuery(query);
                    if (rs3.next()) {
                        model.setValueAt(rs3.getFloat(1), model.getRowCount() - 1, 8);
                    }
                }else
                {
                    j=10;
                }
                           if(i==10 && j==10)
                           {
                               i=j=0;
                  JOptionPane.showMessageDialog(null,"Record Not Found!");
                           }
                               
            }

            stmt.close();
            conn.close();
jTextField1.setText("");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error in connectivity");
        } 
         }// TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        jRadioButton1.setSelected(true);        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

    private void jTable1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyReleased

// TODO add your handling code here:
    }//GEN-LAST:event_jTable1KeyReleased

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(SearchEmpInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SearchEmpInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SearchEmpInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SearchEmpInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SearchEmpInfo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
