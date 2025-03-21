/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author baoki
 */
public class AdRouteTable extends javax.swing.JFrame {

    /**
     * Creates new form AdRouteTable
     */
    public AdRouteTable() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        loadRouteData();
        jBAddRoute1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAddRoute1ActionPerformed(evt);
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jBUpdateRoute1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBUpdateRoute1ActionPerformed(evt);
            }
        });
        jBDeleteRoute1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBDeleteRoute1ActionPerformed(evt);
            }
        });

    }

    private void loadRouteData() {
        String filePath = "d:\\works\\BusManagement\\BusServiceSystem\\CSE305_BusManagement\\scr\\db\\routes.txt";
        File file = new File(filePath);
    
        if (!file.exists()) {
            System.err.println("File not found: " + filePath);
            return;
        }
    
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0); // Clear existing rows
    
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ");
                if (parts.length >= 6) { // Ensure there are at least 6 parts
                    // Combine all parts before the last 4 fields into the route name
                    StringBuilder routeNameBuilder = new StringBuilder();
                    for (int i = 0; i < parts.length - 5; i++) {
                        routeNameBuilder.append(parts[i]).append(" ");
                    }
                    String routeName = routeNameBuilder.toString().trim();
                    String start = parts[parts.length - 5];
                    String end = parts[parts.length - 4];
                    long distance = Long.parseLong(parts[parts.length - 3]);
                    long duration = Long.parseLong(parts[parts.length - 2]);
                    double price = Double.parseDouble(parts[parts.length - 1]);
    
                    // Create a Route object
                    Route route = new Route.Builder()
                            .routeName(routeName)
                            .start(start)
                            .end(end)
                            .distance(distance)
                            .duration(duration)
                            .price(price)
                            .build();
                    route.setPrice(price); 
                    // Add the Route object to the table
                    model.addRow(new Object[] {
                            route.getRouteName(),
                            route.getStart(),
                            route.getEnd(),
                            route.getDistance(),
                            route.getDuration(),
                            route.getPrice() 
                    });
                } else {
                    System.err.println("Invalid line format: " + line); // Debugging log
                }
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }
    private void saveTableToFile() {
        String filePath = "d:\\works\\BusManagement\\BusServiceSystem\\CSE305_BusManagement\\scr\\db\\routes.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            for (int i = 0; i < model.getRowCount(); i++) {
                String routeName = model.getValueAt(i, 0).toString();
                String startLocation = model.getValueAt(i, 1).toString();
                String endLocation = model.getValueAt(i, 2).toString();
                long distance = Long.parseLong(model.getValueAt(i, 3).toString());
                long duration = Long.parseLong(model.getValueAt(i, 4).toString());
                double price = Double.parseDouble(model.getValueAt(i, 5).toString());

                writer.write(String.format("%s %s %s %d %d %.2f%n", routeName, startLocation, endLocation, distance, duration, price));
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error saving to file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jBAddRoute1 = new javax.swing.JButton();
        jBUpdateRoute1 = new javax.swing.JButton();
        jBDeleteRoute1 = new javax.swing.JButton();
        jTFNameRoute1 = new javax.swing.JTextField();
        jTFStartLocaRoute1 = new javax.swing.JTextField();
        jTFEndLocaRoute1 = new javax.swing.JTextField();
        jTFDistanceRoute1 = new javax.swing.JTextField();
        jTFDurationRoute1 = new javax.swing.JTextField();
        jTFPriceRoute1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        kGradientPanel1.setkEndColor(new java.awt.Color(255, 204, 255));
        kGradientPanel1.setkGradientFocus(650);
        kGradientPanel1.setkStartColor(new java.awt.Color(204, 204, 255));

        jScrollPane1.setEnabled(false);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {

                },
                new String[] {
                        "Route Name", "Start Location", "End Location", "Distance", "Duration", "Price"
                }) {
            Class[] types = new Class[] {
                    java.lang.String.class,
                    java.lang.String.class,
                    java.lang.String.class,
                    java.lang.Long.class,
                    java.lang.String.class,
                    java.lang.Long.class
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 153));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/app-map-icon.png"))); // NOI18N
        jLabel1.setText("Route");

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel3.setOpaque(false);

        jLabel8.setText("Name:");

        jLabel9.setText("Start Location:");

        jLabel10.setText("End Location:");

        jLabel11.setText("Distance:");

        jLabel12.setText("Duration:");

        jLabel13.setText("Price:");

        jBAddRoute1.setBackground(new java.awt.Color(0, 204, 204));
        jBAddRoute1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jBAddRoute1.setForeground(new java.awt.Color(255, 255, 255));
        jBAddRoute1.setText("Add");

        jBUpdateRoute1.setBackground(new java.awt.Color(0, 204, 204));
        jBUpdateRoute1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jBUpdateRoute1.setForeground(new java.awt.Color(255, 255, 255));
        jBUpdateRoute1.setText("Update");

        jBDeleteRoute1.setBackground(new java.awt.Color(0, 204, 204));
        jBDeleteRoute1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jBDeleteRoute1.setForeground(new java.awt.Color(255, 255, 255));
        jBDeleteRoute1.setText("Delete");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(jPanel3Layout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 85,
                                                Short.MAX_VALUE)
                                        .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jTFDistanceRoute1, javax.swing.GroupLayout.DEFAULT_SIZE, 200,
                                                Short.MAX_VALUE)
                                        .addComponent(jTFDurationRoute1)
                                        .addComponent(jTFPriceRoute1)
                                        .addComponent(jTFNameRoute1)
                                        .addComponent(jTFStartLocaRoute1)
                                        .addComponent(jTFEndLocaRoute1))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap(120, Short.MAX_VALUE)
                                .addComponent(jBAddRoute1)
                                .addGap(18, 18, 18)
                                .addComponent(jBUpdateRoute1)
                                .addGap(18, 18, 18)
                                .addComponent(jBDeleteRoute1)
                                .addGap(32, 32, 32)));
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel8)
                                        .addComponent(jTFNameRoute1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel9)
                                        .addComponent(jTFStartLocaRoute1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel10)
                                        .addComponent(jTFEndLocaRoute1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel11)
                                        .addComponent(jTFDistanceRoute1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel12)
                                        .addComponent(jTFDurationRoute1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel13)
                                        .addComponent(jTFPriceRoute1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jBAddRoute1)
                                        .addComponent(jBUpdateRoute1)
                                        .addComponent(jBDeleteRoute1))
                                .addContainerGap(13, Short.MAX_VALUE)));

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
                kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                .addGroup(kGradientPanel1Layout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jLabel1)
                                                .addGap(0, 453, Short.MAX_VALUE))
                                        .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jScrollPane1)))
                                .addContainerGap())
                        .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                .addGap(74, 74, 74)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        kGradientPanel1Layout.setVerticalGroup(
                kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 182,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

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

    private void jBAddRoute1ActionPerformed(java.awt.event.ActionEvent evt) {
        String routeName = jTFNameRoute1.getText().trim();
        String startLocation = jTFStartLocaRoute1.getText().trim();
        String endLocation = jTFEndLocaRoute1.getText().trim();
        String distanceText = jTFDistanceRoute1.getText().trim();
        String durationText = jTFDurationRoute1.getText().trim();

        if (routeName.isEmpty() || startLocation.isEmpty() || endLocation.isEmpty() ||
                distanceText.isEmpty() || durationText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            long distance = Long.parseLong(distanceText);
            long duration = Long.parseLong(durationText);

            Route newRoute = new Route.Builder()
                    .routeName(routeName)
                    .start(startLocation)
                    .end(endLocation)
                    .distance(distance)
                    .duration(duration)
                    .build();

            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.addRow(new Object[] {
                    newRoute.getRouteName(),
                    newRoute.getStart(),
                    newRoute.getEnd(),
                    newRoute.getDistance(),
                    newRoute.getDuration(),
                    newRoute.getPrice()
            });

            saveTableToFile();

            JOptionPane.showMessageDialog(this, "Route added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);

            jTFNameRoute1.setText("");
            jTFStartLocaRoute1.setText("");
            jTFEndLocaRoute1.setText("");
            jTFDistanceRoute1.setText("");
            jTFDurationRoute1.setText("");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Distance and duration must be valid numbers!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {
        int selectedRow = jTable1.getSelectedRow();

        if (selectedRow != -1) {
            jTFNameRoute1.setText(jTable1.getValueAt(selectedRow, 0).toString());
            jTFStartLocaRoute1.setText(jTable1.getValueAt(selectedRow, 1).toString());
            jTFEndLocaRoute1.setText(jTable1.getValueAt(selectedRow, 2).toString());
            jTFDistanceRoute1.setText(jTable1.getValueAt(selectedRow, 3).toString());
            jTFDurationRoute1.setText(jTable1.getValueAt(selectedRow, 4).toString());
        }
    }

    private void jBUpdateRoute1ActionPerformed(java.awt.event.ActionEvent evt) {
        int selectedRow = jTable1.getSelectedRow();
    
        if (selectedRow != -1) {
            String updatedRouteName = jTFNameRoute1.getText().trim();
            String updatedStartLocation = jTFStartLocaRoute1.getText().trim();
            String updatedEndLocation = jTFEndLocaRoute1.getText().trim();
            String updatedDistanceText = jTFDistanceRoute1.getText().trim();
            String updatedDurationText = jTFDurationRoute1.getText().trim();
            String updatedPriceText = jTFPriceRoute1.getText().trim();
    
            if (updatedRouteName.isEmpty() || updatedStartLocation.isEmpty() || updatedEndLocation.isEmpty() ||
                    updatedDistanceText.isEmpty() || updatedDurationText.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill in all fields except price!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
    
            try {
                long updatedDistance = Long.parseLong(updatedDistanceText);
                long updatedDuration = Long.parseLong(updatedDurationText);
    
                // Determine the price
                double updatedPrice;
                if (updatedPriceText.isEmpty()) {
                    // Auto-calculate price based on distance
                    updatedPrice = updatedDistance * 5; // Example: price is 5.0 per unit of distance
                } else {
                    // Use the provided price
                    updatedPrice = Double.parseDouble(updatedPriceText);
                }
    
                // Update the table model
                DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                model.setValueAt(updatedRouteName, selectedRow, 0);
                model.setValueAt(updatedStartLocation, selectedRow, 1);
                model.setValueAt(updatedEndLocation, selectedRow, 2);
                model.setValueAt(updatedDistance, selectedRow, 3);
                model.setValueAt(updatedDuration, selectedRow, 4);
                model.setValueAt(updatedPrice, selectedRow, 5);
    
                saveTableToFile();
    
                JOptionPane.showMessageDialog(this, "Route updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
    
                // Clear the input fields
                jTFNameRoute1.setText("");
                jTFStartLocaRoute1.setText("");
                jTFEndLocaRoute1.setText("");
                jTFDistanceRoute1.setText("");
                jTFDurationRoute1.setText("");
                jTFPriceRoute1.setText("");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Distance, duration, and price must be valid numbers!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a row to update!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    private void jBDeleteRoute1ActionPerformed(java.awt.event.ActionEvent evt) {
        int selectedRow = jTable1.getSelectedRow();

        if (selectedRow != -1) {
            int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this route?",
                    "Confirm Deletion", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                model.removeRow(selectedRow);

                saveTableToFile();

                JOptionPane.showMessageDialog(this, "Route deleted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);

                jTFNameRoute1.setText("");
                jTFStartLocaRoute1.setText("");
                jTFEndLocaRoute1.setText("");
                jTFDistanceRoute1.setText("");
                jTFDurationRoute1.setText("");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a row to delete!", "Error", JOptionPane.ERROR_MESSAGE);
        }
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
            java.util.logging.Logger.getLogger(AdRouteTable.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdRouteTable.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdRouteTable.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdRouteTable.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdRouteTable().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAddRoute1;
    private javax.swing.JButton jBDeleteRoute1;
    private javax.swing.JButton jBUpdateRoute1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTFDistanceRoute1;
    private javax.swing.JTextField jTFDurationRoute1;
    private javax.swing.JTextField jTFEndLocaRoute1;
    private javax.swing.JTextField jTFNameRoute1;
    private javax.swing.JTextField jTFPriceRoute1;
    private javax.swing.JTextField jTFStartLocaRoute1;
    private javax.swing.JTable jTable1;
    private keeptoo.KGradientPanel kGradientPanel1;
    // End of variables declaration//GEN-END:variables
}
