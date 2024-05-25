/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.projectransportationmangementsystem;

import com.mycompany.projectransportationmangementsystem.Login;
import com.mycompany.projectransportationmangementsystem.Trip;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lenovo
 */
public class PassengerForm extends javax.swing.JFrame {
      
    private static final String TRIP_FILENAME = "trip.txt";
  private Passenger passenger;
        // Initialize available trips
        
    /**
     * Creates new form PassengerForm
     */
    public PassengerForm() {
       initComponents();
       loadTripsFromFile();
      
    }
    private void loadTripsFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(TRIP_FILENAME))) {
            String line;
            DefaultTableModel model = (DefaultTableModel) availableTable.getModel();
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(", ");
                model.addRow(parts);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "An error occurred while reading from the file: " + e.getMessage());
        }
    }


    
   /* private void removeTripBFromFile(int rowIndex) {
        DefaultTableModel model = (DefaultTableModel) bookedTable.getModel();
        model.removeRow(rowIndex);
        saveTripsToFile();
    }

    */
       private void removeTripFromFile(int rowIndex) {
       DefaultTableModel model = (DefaultTableModel) bookedTable.getModel();
       String[] rowData = new String[model.getColumnCount()];
       for (int i = 0; i < model.getColumnCount(); i++) {
           rowData[i] = (String) model.getValueAt(rowIndex, i);
       }
       model.removeRow(rowIndex);

       DefaultTableModel availableModel = (DefaultTableModel) availableTable.getModel();
       availableModel.addRow(rowData);

       saveTripsToFile();
   }
/*private void saveTripsToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("trips.txt"))) {
            DefaultTableModel model = (DefaultTableModel) bookedTable.getModel();
            for (int i = 0; i < model.getRowCount(); i++) {
                StringBuilder tripDetails = new StringBuilder();
                for (int j = 0; j < model.getColumnCount(); j++) {
                    tripDetails.append(model.getValueAt(i, j));
                    if (j < model.getColumnCount() - 1) {
                        tripDetails.append(", ");
                    }
                }
                writer.write(tripDetails.toString() + "\n");
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "An error occurred while writing to the file: " + e.getMessage());
        }
    }

 */
           private void saveTripsToFile() {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(TRIP_FILENAME))) {
        DefaultTableModel model = (DefaultTableModel) bookedTable.getModel();
        for (int i = 0; i < model.getRowCount(); i++) {
            StringBuilder tripDetails = new StringBuilder();
            for (int j = 0; j < model.getColumnCount(); j++) {
                tripDetails.append(model.getValueAt(i, j));
                if (j < model.getColumnCount() - 1) {
                    tripDetails.append(", ");
                }
            }
            writer.write(tripDetails.toString() + "\n");
        }
    } catch (IOException e) {
        JOptionPane.showMessageDialog(null, "An error occurred while writing to the file: " + e.getMessage());
    }
}
/*private void removeTripFromFile(int rowIndex) {
    
        DefaultTableModel model = (DefaultTableModel) bookedTable.getModel();
        model.removeRow(rowIndex);
       
        saveTripsToFile();
    }

 */
/*private void addTripFromFile(int rowIndex ) {
   
         DefaultTableModel modelA = (DefaultTableModel) availableTable.getModel();
         rowIndex = availableTable.getSelectedRow();
        if (rowIndex != -1) {
         Object[] rowData = new Object[modelA.getColumnCount()];
          for (int i = 0; i < rowData.length; i++) {
         rowData[i] = modelA.getValueAt(rowIndex, i);
             }
           modelA.removeRow(rowIndex);
    
         DefaultTableModel modelB = (DefaultTableModel) bookedTable.getModel();
          modelB.addRow(rowData);
          saveTripsToFile();
}

 */
private void addTripFromFile(int rowIndex) {
    DefaultTableModel model = (DefaultTableModel) availableTable.getModel();
    String[] rowData = new String[model.getColumnCount()];
    for (int i = 0; i < model.getColumnCount(); i++) {
        rowData[i] = (String) model.getValueAt(rowIndex, i);
    }
    model.removeRow(rowIndex);

    DefaultTableModel bookedModel = (DefaultTableModel) bookedTable.getModel();
    bookedModel.addRow(rowData);

    saveTripsToFile();
}

/*private void addTriptoFile(int rowIndex ) {
   
         DefaultTableModel modelA = (DefaultTableModel) bookedTable.getModel();
         rowIndex = bookedTable.getSelectedRow();
        if (rowIndex != -1) {
         Object[] rowData = new Object[modelA.getColumnCount()];
          for (int i = 0; i < rowData.length; i++) {
         rowData[i] = modelA.getValueAt(rowIndex, i);
             }
           modelA.removeRow(rowIndex);
    
         DefaultTableModel modelB = (DefaultTableModel) availableTable.getModel();
          modelB.addRow(rowData);
          saveTripsToFile();
}


}

 */




    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btReturn = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        availableTable = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        bookedTable = new javax.swing.JTable();
        btDelete = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(145, 137, 129));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 2, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Welcome to Transportation Company  ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 773, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(144, 144, 144))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        btReturn.setBackground(new java.awt.Color(255, 255, 255));
        btReturn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btReturn.setForeground(new java.awt.Color(0, 0, 0));
        btReturn.setText("Return");
        btReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btReturnActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));

        jLabel7.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Avaliable Trip");

        availableTable.setBackground(new java.awt.Color(153, 153, 153));
        availableTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(availableTable);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(233, 233, 233)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 584, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));

        jLabel8.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("Your Trips");

        bookedTable.setBackground(new java.awt.Color(153, 153, 153));
        bookedTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(bookedTable);

        btDelete.setBackground(new java.awt.Color(204, 204, 204));
        btDelete.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        btDelete.setForeground(new java.awt.Color(0, 0, 0));
        btDelete.setText("Remove");
        btDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(231, 231, 231)
                        .addComponent(jLabel8)
                        .addGap(65, 65, 65)
                        .addComponent(btDelete))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 629, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Choose the trip you want to book :");

        jButton1.setBackground(new java.awt.Color(204, 204, 204));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setText("Book");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(btReturn, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(225, 225, 225)
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addComponent(btReturn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btReturnActionPerformed
        // TODO add your handling code here:
        Login r = new Login ();
        r.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btReturnActionPerformed

    private void btDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDeleteActionPerformed
        // TODO add your handling code here:
       int rowIndex = bookedTable.getSelectedRow();
        if (rowIndex != -1) {
            removeTripFromFile(rowIndex);
            JOptionPane.showMessageDialog(null, "trip removed");
        } else {
            JOptionPane.showMessageDialog(null, "Please select a trip to remove.");
        }
        
                                          
        
           
        
    }//GEN-LAST:event_btDeleteActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int rowIndex = availableTable.getSelectedRow();
        if (rowIndex != -1) {
         addTripFromFile(rowIndex);
          JOptionPane.showMessageDialog(null, "trip booked");
        } else {
            JOptionPane.showMessageDialog(null, "Please select trip.");
        }        
                                           
    
    


                
        
    }//GEN-LAST:event_jButton1ActionPerformed
private void updateFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("trip.txt"))) {
            DefaultTableModel model = (DefaultTableModel) availableTable.getModel();
            for (int i = 0; i < model.getRowCount(); i++) {
                for (int j = 0; j < model.getColumnCount(); j++) {
                    writer.write(model.getValueAt(i, j) + ",");
                }
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
  
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable availableTable;
    private javax.swing.JTable bookedTable;
    private javax.swing.JButton btDelete;
    private javax.swing.JButton btReturn;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
