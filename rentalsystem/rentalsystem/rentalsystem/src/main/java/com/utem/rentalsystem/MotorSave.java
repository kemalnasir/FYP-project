/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.utem.rentalsystem;

import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 
 */
public class MotorSave extends javax.swing.JFrame 
{
        private MotorManager manage = new MotorManager();
        private static ArrayList<Motor> motorList;
          
        private Motor motor;
    /**
     * Creates new form SaveMotor
     */
    public MotorSave() 
    {
        initComponents();
        // call method to determine buttons state
//        initialBtn();
    }
    
    private void initialBtn()
    {
        editBtn.setEnabled(false);
        saveBtn.setEnabled(true);
        resetBtn.setEnabled(false);
    }
    
    private void clearForm()
    {
        regTxtField.setText("");
        nameTxtField.setText("");
        priceTxtField.setText("");
        statusCB.setSelectedIndex(0);
    }
    
    private boolean isEmptyField()
    {
        if(regTxtField.getText().isEmpty() || nameTxtField.getText().isEmpty() || priceTxtField.getText().isEmpty() || statusCB.getSelectedIndex()== -1)
        {
            //if empty, return true
            return true;
        }
        else
        {
            //if empty, return false
            return false;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        priceTxtField = new javax.swing.JTextField();
        statusCB = new javax.swing.JComboBox<>();
        saveBtn = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        resetBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        editBtn = new javax.swing.JButton();
        regTxtField = new javax.swing.JTextField();
        searcBtn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        nameTxtField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        priceTxtField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                priceTxtFieldKeyPressed(evt);
            }
        });

        statusCB.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        statusCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Booked", "Available" }));

        saveBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/save.png"))); // NOI18N
        saveBtn.setText("Save Motor");
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });

        jLabel7.setText("Motor Availability :");

        resetBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/reset.png"))); // NOI18N
        resetBtn.setText("Reset Form");
        resetBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetBtnActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jLabel1.setText("Add Motor");

        jLabel2.setText("Motor Registration No :");

        editBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edit.png"))); // NOI18N
        editBtn.setText("Edit Motor");
        editBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBtnActionPerformed(evt);
            }
        });

        regTxtField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                regTxtFieldKeyPressed(evt);
            }
        });

        searcBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/search.png"))); // NOI18N
        searcBtn.setText("Search Motor");
        searcBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searcBtnActionPerformed(evt);
            }
        });

        jLabel3.setText("Motor Name :");

        nameTxtField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nameTxtFieldKeyPressed(evt);
            }
        });

        jLabel4.setText("Price (RM) :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(283, 283, 283)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(regTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(nameTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(priceTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(statusCB, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(115, Short.MAX_VALUE)
                .addComponent(searcBtn)
                .addGap(38, 38, 38)
                .addComponent(saveBtn)
                .addGap(34, 34, 34)
                .addComponent(editBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(resetBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(108, 108, 108))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(statusCB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(regTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(nameTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(priceTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(resetBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searcBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        // Check if the form is completed
        if(!isEmptyField()){
            // Create new car object to receive input
            motor = new Motor();

            // Call methods at class Car to set the new value from the form
            motor.setVehicleReg(regTxtField.getText().trim());
            motor.setVehicleName(nameTxtField.getText().trim());
            motor.setPrice(Double.parseDouble(priceTxtField.getText().trim()));
            motor.setVehicleStatus(statusCB.getSelectedItem().toString().trim());
            //call method to save the car
            manage.saveMotor(motor);

            //display information message box
            JOptionPane.showMessageDialog(null,"Motor added succesfully!");
            clearForm();
        }
        //If the form is not completed yet
        else{
            // Display information message box
            JOptionPane.showMessageDialog(null, "Complete the form!");
        }
    }//GEN-LAST:event_saveBtnActionPerformed

    private void resetBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetBtnActionPerformed
        // Call method to reset the form
        clearForm();
        // Call method to set initial butttons state
        initialBtn();
    }//GEN-LAST:event_resetBtnActionPerformed

    private void editBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBtnActionPerformed
        //Check if the form is completed
        if(!isEmptyField())
        {
            // call setter to assign car attributes with the values from GUI
            motor = new Motor();
            motor.setVehicleName(nameTxtField.getText().trim());
            motor.setPrice(Double.parseDouble(priceTxtField.getText().trim()));
            motor.setVehicleStatus(statusCB.getSelectedItem().toString().trim());

            //call method to update the car based on car registration number
            manage.editMotor(regTxtField.getText().trim(), motor);

            //message to infrom user
            JOptionPane.showMessageDialog(null,"Motor has been updated!");
            //Call method to set initial buttons state
            initialBtn();

            // Call method to reset the form
            clearForm();

        }
        //if the form is not completed yet
        else{

            // Display information message box
            JOptionPane.showMessageDialog(null, "Complete the form!");
        }
    }//GEN-LAST:event_editBtnActionPerformed

    private void searcBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searcBtnActionPerformed
        //create new car object to receive input
        motor= new Motor();

        //create object to set two -decimal places of price output format
        DecimalFormat df = new DecimalFormat("0.00");

        // Check if the Car No field is empty
        if(regTxtField.getText().isEmpty()){
            // Display information message box
            JOptionPane.showMessageDialog(null, "Please enter Registration No");
        }
        // If Car No field is not empty
        else{
            //call method to search the car based on car registration number
            //then return the found car
            motor = (Motor) manage.searchMotor(regTxtField.getText().trim());

            //if item found
            if(motor.getVehicleReg() != null){
                //Display the car attributes in the form
                regTxtField.setText(String.valueOf(motor.getVehicleReg()));
                nameTxtField.setText(motor.getVehicleName());
                priceTxtField.setText(String.valueOf(df.format(motor.getPrice())));
                statusCB.setSelectedItem(String.valueOf(motor.getVehicleStatus()));

                // Set the new state buttons
                saveBtn.setEnabled(false);
                editBtn.setEnabled(true);
                resetBtn.setEnabled(true);

            }
            // If do not found the selected car yet
            else{
                // Call method to set initial buttons state
                initialBtn();
                // Call method to reset the form
                clearForm();
                // Display information message box
                JOptionPane.showMessageDialog(null, "Motor does not exist!");
            }
        }
    }//GEN-LAST:event_searcBtnActionPerformed

    private void regTxtFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_regTxtFieldKeyPressed
        // TODO add your handling code here: 
        if (evt.getKeyCode() == KeyEvent.VK_ENTER)
        nameTxtField.requestFocus();
    }//GEN-LAST:event_regTxtFieldKeyPressed

    private void nameTxtFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nameTxtFieldKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER)
        priceTxtField.requestFocus();
    }//GEN-LAST:event_nameTxtFieldKeyPressed

    private void priceTxtFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_priceTxtFieldKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER)
        statusCB.requestFocus();
    }//GEN-LAST:event_priceTxtFieldKeyPressed

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
            java.util.logging.Logger.getLogger(MotorSave.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MotorSave.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MotorSave.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MotorSave.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MotorSave().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton editBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField nameTxtField;
    private javax.swing.JTextField priceTxtField;
    private javax.swing.JTextField regTxtField;
    private javax.swing.JButton resetBtn;
    private javax.swing.JButton saveBtn;
    private javax.swing.JButton searcBtn;
    private javax.swing.JComboBox<String> statusCB;
    // End of variables declaration//GEN-END:variables

}
