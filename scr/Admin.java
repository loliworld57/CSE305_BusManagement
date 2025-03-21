/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

import java.util.TreeMap;

import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author baoki
 */
public class Admin extends javax.swing.JFrame {
    static BusSchedule schedule;

    /**
     * Creates new form Admin
     */
    public Admin() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Admin");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        loadSchedule();

        jTFAdSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTFAdSearchKeyReleased(evt);   
                loadSchedule();
                 }
        });

        jBMore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBMoreActionPerformed(evt);
            }
        });

    }

    private void loadSchedule() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        schedule = new BusSchedule();

        jTable1.setEnabled(true);
        try {
            TreeMap<String, Line> lineData = schedule.getBusSchedule();
            for (String time : lineData.keySet()) {
                Line line = lineData.get(time);
                model.addRow(new Object[] { line.getLineName(), line.getBus().getBusName(),
                        line.getRoute().getRouteName(), line.getRoute().getStart(), line.getRoute().getEnd(), time });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error loading schedule: " + e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kGradientPanel1 = new keeptoo.KGradientPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jBAdBus = new javax.swing.JButton();
        jBAdRoute = new javax.swing.JButton();
        jBSchedule = new javax.swing.JButton();
        jBMore = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTFAdSearch = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        kGradientPanel1.setkEndColor(new java.awt.Color(255, 204, 255));
        kGradientPanel1.setkGradientFocus(1000);
        kGradientPanel1.setkStartColor(new java.awt.Color(204, 204, 255));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/admin.png"))); // NOI18N
        jLabel1.setText("ADMIN");

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        jPanel1.setOpaque(false);

        jBAdBus.setBackground(new java.awt.Color(204, 255, 204));
        jBAdBus.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jBAdBus.setForeground(new java.awt.Color(102, 51, 0));
        jBAdBus.setText("BUS");
        jBAdBus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAdBusActionPerformed(evt);
            }
        });

        jBAdRoute.setBackground(new java.awt.Color(204, 255, 204));
        jBAdRoute.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jBAdRoute.setForeground(new java.awt.Color(102, 51, 0));
        jBAdRoute.setText("ROUTE");
        jBAdRoute.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAdRouteActionPerformed(evt);
            }
        });

        jBSchedule.setBackground(new java.awt.Color(204, 255, 204));
        jBSchedule.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jBSchedule.setForeground(new java.awt.Color(102, 51, 0));
        jBSchedule.setText("SCHEDULE");
        jBSchedule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBScheduleActionPerformed(evt);
            }
        });

        jBMore.setBackground(new java.awt.Color(204, 255, 204));
        jBMore.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jBMore.setForeground(new java.awt.Color(102, 51, 0));
        jBMore.setText("BUS LINE");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jBSchedule, javax.swing.GroupLayout.PREFERRED_SIZE, 169,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jBMore, javax.swing.GroupLayout.PREFERRED_SIZE, 169,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jBAdRoute, javax.swing.GroupLayout.PREFERRED_SIZE, 169,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jBAdBus, javax.swing.GroupLayout.PREFERRED_SIZE, 169,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(16, Short.MAX_VALUE)));
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap(26, Short.MAX_VALUE)
                                .addComponent(jBAdBus, javax.swing.GroupLayout.PREFERRED_SIZE, 36,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jBAdRoute, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jBSchedule, javax.swing.GroupLayout.PREFERRED_SIZE, 35,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jBMore, javax.swing.GroupLayout.PREFERRED_SIZE, 35,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(21, 21, 21)));

        jPanel2.setOpaque(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE));
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 29, Short.MAX_VALUE));

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 0, 0));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/account-functions-icon.png"))); // NOI18N
        jLabel2.setText("Manage");

        jTFAdSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFAdSearchActionPerformed(evt);
            }
        });
        jTFAdSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTFAdSearchKeyReleased(evt);
            }
        });

        jScrollPane2.setEnabled(false);
        jScrollPane2.setViewportView(null);

        jTable1.setBackground(new java.awt.Color(242, 254, 254));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {

                },
                new String[] {
                        "Line Name", "Bus Name", "Route Name", "Start", "End", "Time"
                }) {
            Class[] types = new Class[] {
                    java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class,
                    java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean[] {
                    false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTable1.setEnabled(false);
        jScrollPane2.setViewportView(jTable1);

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
                kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(kGradientPanel1Layout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(kGradientPanel1Layout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel2)
                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 155,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(kGradientPanel1Layout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jTFAdSearch)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 616,
                                                Short.MAX_VALUE))
                                .addGap(20, 20, 20)
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap()));
        kGradientPanel1Layout.setVerticalGroup(
                kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout
                                .createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(kGradientPanel1Layout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(jTFAdSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 29,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(kGradientPanel1Layout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0,
                                                Short.MAX_VALUE)
                                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(20, 20, 20)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTFAdSearchActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jTFAdSearchActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        jTable1.setRowSorter(sorter);
        sorter.setRowFilter(RowFilter.regexFilter(jTFAdSearch.getText()));
    }// GEN-LAST:event_jTFAdSearchActionPerformed

    private void jBAdRouteActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jBAdRouteActionPerformed
        // TODO add your handling code here:
        AdRouteTable adRoute = new AdRouteTable();
        adRoute.setVisible(true);
    }// GEN-LAST:event_jBAdRouteActionPerformed

    private void jBAdBusActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jBAdBusActionPerformed
        AdBusTable adBus = new AdBusTable();
        adBus.setVisible(true);
    }// GEN-LAST:event_jBAdBusActionPerformed

    private void jBScheduleActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jBScheduleActionPerformed
        // TODO add your handling code here:
        Schedule sche = new Schedule();
        sche.setVisible(true);
    }// GEN-LAST:event_jBScheduleActionPerformed

    private void jTFAdSearchKeyReleased(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_jTFAdSearchKeyReleased
        // TODO add your handling code here:
    }// GEN-LAST:event_jTFAdSearchKeyReleased

    private void jBMoreActionPerformed(java.awt.event.ActionEvent evt) {
        // Create and display the BusLineFrame
        BusLineFrame busLineFrame = new BusLineFrame();
        busLineFrame.setVisible(true);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAdBus;
    private javax.swing.JButton jBAdRoute;
    private javax.swing.JButton jBMore;
    private javax.swing.JButton jBSchedule;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTFAdSearch;
    private javax.swing.JTable jTable1;
    private keeptoo.KGradientPanel kGradientPanel1;
    // End of variables declaration//GEN-END:variables
}
