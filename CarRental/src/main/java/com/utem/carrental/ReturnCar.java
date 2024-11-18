/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.utem.carrental;

import javax.swing.JOptionPane;
import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;
import java.text.*;
/**
 *
 * @author User
 */
public class ReturnCar extends javax.swing.JFrame {
    // declare object for class ItemManager to use methods for dealing with database
    private Connection carCon = new Connection();
    private Connection customerCon = new Connection();
    private Connection orderCon = new Connection();
    private Connection returnCon = new Connection();
    
    // declare object for class Car to set and get values of Item
    private Car car;
    
    private static ArrayList <Car> carList;
    
    // declare object for class Customer to set and get values of Item
    private Customer customer;
    
    private static ArrayList <Customer> customerList;
    
    // declare object for class Order to set and get values of Item
    private Order order;
    
    private static ArrayList <Order> orderList;
    
    // declare object for class Order to set and get values of Item
    private ReturnOrder returnOrder;
    
    private static ArrayList <ReturnOrder> returnOrderList;
    
    // declare object for class ReturnC to set and get values of Item
    private ReturnC returnC;
    
    private static ArrayList <ReturnC> returnCList;
    
    public void searchOrder(String str) 
    {
        DefaultTableModel tableContent = (DefaultTableModel) orderTable.getModel();
        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<> (tableContent); 
        orderTable.setRowSorter(trs);
        trs.setRowFilter(RowFilter.regexFilter(str));
    }
    /**
     * Creates new form ReturnCar
     */
    public ReturnCar() {
        initComponents();
        TxtExactDateReturn.setMinSelectableDate(new Date());
        returnCon.id_return();
        TxtOrderId.setEditable(false);
        TxtEmail.setEditable(false);
        TxtCarRegisterId.setEditable(false);
        TxtCarTotal.setEditable(false);
        TxtDateBook.setEnabled(false);
        TxtDateReturn.setEnabled(false);
        TxtFine.setEditable(false);
        
        //String searchString = "Book";
        //searchOrder(searchString);
    }
    
    public void clearForm() {
        TxtCarRegisterId.setText("");
        TxtOrderId.setText("");
        TxtEmail.setText("");
        TxtCarTotal.setText("");
        TxtDateBook.setDate(null);
        TxtDateReturn.setDate(null);
        TxtExactDateReturn.setDate(null);
        TxtFine.setText("");
    }
    
    public int carTotal = 0;
    public int carFine = 0;
    public int grandTotal = 0;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnExit = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        TxtFine = new javax.swing.JTextField();
        btnReturn = new javax.swing.JButton();
        btnGenerate = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        LblPay = new javax.swing.JLabel();
        txtOrder = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        orderTable = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(350, 134));
        setUndecorated(true);
        setResizable(false);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/delete_icon.jpeg"))); // NOI18N
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        getContentPane().add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 20, 40, 40));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 0));
        jLabel1.setText("RETURN CAR");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 80, 230, -1));

        TxtCarRegisterId.setEditable(false);
        TxtCarRegisterId.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(TxtCarRegisterId, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 480, 230, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Register ID:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 480, 80, -1));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Order ID:");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 400, 70, -1));

        TxtOrderId.setEditable(false);
        TxtOrderId.setBackground(new java.awt.Color(255, 255, 255));
        TxtOrderId.setName(""); // NOI18N
        getContentPane().add(TxtOrderId, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 400, 230, -1));

        TxtEmail.setEditable(false);
        TxtEmail.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(TxtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 440, 230, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Email:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 440, 50, -1));

        TxtReturnId.setEditable(false);
        TxtReturnId.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(TxtReturnId, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 360, 230, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Search Order ID:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 170, -1, -1));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Total:");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 170, 40, -1));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Fine:");
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 330, 40, -1));

        TxtFine.setEditable(false);
        TxtFine.setBackground(new java.awt.Color(255, 255, 255));
        TxtFine.setName(""); // NOI18N
        getContentPane().add(TxtFine, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 330, 230, -1));

        TxtDateReturn.setBackground(new java.awt.Color(204, 255, 255));
        getContentPane().add(TxtDateReturn, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 250, 230, -1));

        btnReturn.setBackground(new java.awt.Color(0, 0, 0));
        btnReturn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnReturn.setForeground(new java.awt.Color(255, 255, 255));
        btnReturn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bill.png"))); // NOI18N
        btnReturn.setText("Return");
        btnReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReturnActionPerformed(evt);
            }
        });
        getContentPane().add(btnReturn, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 460, 230, 40));
        getContentPane().add(TxtDateBook, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 210, 230, -1));

        btnGenerate.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnGenerate.setForeground(new java.awt.Color(153, 0, 0));
        btnGenerate.setText("^^ Generate Fine^^");
        btnGenerate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerateActionPerformed(evt);
            }
        });
        getContentPane().add(btnGenerate, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 370, 230, 40));

        TxtCarTotal.setEditable(false);
        TxtCarTotal.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(TxtCarTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 170, 230, -1));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Date Return:");
        getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 250, 90, -1));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Date Book:");
        getContentPane().add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 210, 80, -1));

        TxtExactDateReturn.setBackground(new java.awt.Color(204, 255, 255));
        getContentPane().add(TxtExactDateReturn, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 290, 230, -1));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Exact Date Return:");
        getContentPane().add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 290, 130, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 102));
        jLabel3.setText("Need to Pay : RM");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 420, -1, -1));

        LblPay.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        LblPay.setForeground(new java.awt.Color(255, 255, 102));
        LblPay.setText("00.00");
        getContentPane().add(LblPay, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 420, -1, -1));

        txtOrder.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtOrderKeyReleased(evt);
            }
        });
        getContentPane().add(txtOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 170, 230, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Return ID:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 360, 70, -1));

        orderTable.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        orderTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Order ID"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        orderTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                orderTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(orderTable);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 200, 230, 140));

        jLabel6.setBackground(new java.awt.Color(204, 204, 255));
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/backgroundcar.jpg"))); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1130, 710));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // Close form
        setVisible(false);
        TxtReturnId.setText("");
        TxtOrderId.setText("");
        TxtEmail.setText("");
        TxtCarRegisterId.setText("");
        TxtCarRegisterId.setText("");
        TxtCarTotal.setText("");
        TxtDateBook.setCalendar(null);
        TxtDateReturn.setCalendar(null);
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReturnActionPerformed
        SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String returnDate = dFormat.format(TxtDateReturn.getDate());
        String email = TxtEmail.getText();
        String finetxt = TxtFine.getText();
        Date rentDate = TxtDateReturn.getDate();
        Date rentExactDate = TxtExactDateReturn.getDate();
        long d1 = rentDate.getTime();
        long d2 = rentExactDate.getTime();
        //int diffInDays = (int) (difference / 1000 / 60 / 60 / 24);
        //int day = diffInDays;
        if(!email.equals(Home.TxtEmail.getText()))
        {
            JOptionPane.showMessageDialog(null, "You can't return the car for other user!!!");
        }
        else
        {
            if (!rentExactDate.equals("") && !finetxt.equals("")) {
                if (d2 < d1) {
                    JOptionPane.showMessageDialog(null, "Your Exact return date can't be low than your selected return date before!!!");
                } else {
                    //JOptionPane.showMessageDialog(null, "Successfully saved.");
                    returnC = new ReturnC();

                    returnC.setReturnId(TxtReturnId.getText().trim());
                    returnC.setFine(TxtFine.getText().trim());
                    returnC.setReturnDate(returnDate.trim());
                    returnC.setOrderId(TxtOrderId.getText().trim());
                    returnC.setEmail(TxtEmail.getText().trim());
                    returnC.setRegisterId(TxtCarRegisterId.getText().trim());

                    // call method to save the order
                    returnCon.saveReturn(returnC);

                    // call method to generate auto increment id
                    returnCon.id_return();

                    car = new Car();

                    // call method to update the car based on car register id
                    carCon.returnCarStatus(TxtCarRegisterId.getText().trim(), car);
                    orderCon.deleteReturnOrder(TxtOrderId.getText().trim());

                    clearForm();
                    int i = JOptionPane.showConfirmDialog(null, "Let us know your feedback!", "Feedback", JOptionPane.YES_NO_OPTION);
                    if (i == 0) {
                        new FeedbackCust().setVisible(true);
                    } else {
                        setVisible(false);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Please insert your exact date and click the generate fine's button!!!");
            }
        }
    }//GEN-LAST:event_btnReturnActionPerformed

    private void btnGenerateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerateActionPerformed
        carTotal = Integer.parseInt(TxtCarTotal.getText().trim());

        SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd");
        //Date startDate = TxtDateBook.getDate();
        Date returnDate = TxtDateReturn.getDate();
        Date endDate = TxtExactDateReturn.getDate();

        if (TxtDateReturn.getDate() == TxtExactDateReturn.getDate())
        {
            int period = 0;
            TxtFine.setText(String.valueOf(period));
        }
        else
        {
            // In milliseconds
            long difference = endDate.getTime() - returnDate.getTime();

            int diffInDays = (int) (difference / 1000 / 60 / 60 / 24);

            //TxtFine.setText(String.valueOf(diffInDays));

            int period = diffInDays;
            if (period <= 0) {
                period = 0;
            }
            carFine = carTotal * period;
            TxtFine.setText(String.valueOf(carFine));
            LblPay.setText(String.valueOf(carFine));
        }
    }//GEN-LAST:event_btnGenerateActionPerformed

    private void orderTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_orderTableMouseClicked
        int index = orderTable.getSelectedRow();
        TableModel model = orderTable.getModel();
        String orderId = model.getValueAt(index, 0).toString();
        Order order = orderCon.getOrderById(orderId);
        TxtOrderId.setText(order.getOrderId());
        TxtEmail.setText(order.getEmail());
        TxtCarRegisterId.setText(order.getRegisterId());
        TxtCarTotal.setText(order.getTotal());

        try {
            SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd");
            
            String dateInString = order.getDate();
            Date date = dFormat.parse(dateInString);
            
            String dateReturnInString = order.getReturnDate();
            Date dateReturn = dFormat.parse(dateReturnInString);

            Calendar calendar = Calendar.getInstance();
            Calendar calendarReturn = Calendar.getInstance();
            
            calendar.setTime(date);
            calendarReturn.setTime(dateReturn);
        
            TxtDateBook.setCalendar(calendar);
            TxtDateReturn.setCalendar(calendarReturn);
          }
        catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_orderTableMouseClicked

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // Call method readAll() to fetch all data from database
        returnOrderList = orderCon.readAllReturnOrder();
        
        DefaultTableModel tableContent = (DefaultTableModel) orderTable.getModel();
        
        Object rowData[] = new Object[8];
        
        // use repetition structure to read all item attributes of the ArrayList
        // and display the data in the table according to the columns and row
        for(ReturnOrder x:returnOrderList){
            rowData[0] = x.getOrderId();
            tableContent.addRow(rowData);
        }
    }//GEN-LAST:event_formComponentShown

    private void txtOrderKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtOrderKeyReleased
        String searchString = txtOrder.getText();
        searchOrder(searchString);
    }//GEN-LAST:event_txtOrderKeyReleased

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
            java.util.logging.Logger.getLogger(ReturnCar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReturnCar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReturnCar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReturnCar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReturnCar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LblPay;
    public static final javax.swing.JTextField TxtCarRegisterId = new javax.swing.JTextField();
    public static final javax.swing.JTextField TxtCarTotal = new javax.swing.JTextField();
    public static final com.toedter.calendar.JDateChooser TxtDateBook = new com.toedter.calendar.JDateChooser();
    public static final com.toedter.calendar.JDateChooser TxtDateReturn = new com.toedter.calendar.JDateChooser();
    public static final javax.swing.JTextField TxtEmail = new javax.swing.JTextField();
    public static final com.toedter.calendar.JDateChooser TxtExactDateReturn = new com.toedter.calendar.JDateChooser();
    private javax.swing.JTextField TxtFine;
    public static final javax.swing.JTextField TxtOrderId = new javax.swing.JTextField();
    public static final javax.swing.JTextField TxtReturnId = new javax.swing.JTextField();
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnGenerate;
    private javax.swing.JButton btnReturn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable orderTable;
    private javax.swing.JTextField txtOrder;
    // End of variables declaration//GEN-END:variables
}