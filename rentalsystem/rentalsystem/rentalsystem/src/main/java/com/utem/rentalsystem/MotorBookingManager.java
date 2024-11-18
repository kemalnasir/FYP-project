/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utem.rentalsystem;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author 
 */
public class MotorBookingManager 
{
    private ArrayList<MotorBooking> customerList;
    private MotorBooking mB = new MotorBooking();
    
    Connection con;

    public MotorBookingManager () 
    {
        
    }
    
    private void connectToDatabase()
    {
        try
        {
            String host = "jdbc:derby://localhost:1527/carRental";
            con = DriverManager.getConnection(host);
        }
        catch(SQLException err)
        {
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }
    
    public ArrayList<MotorBooking> readAll()
    {
        customerList = new ArrayList<MotorBooking>();
        
        try
        {
            connectToDatabase();
            
            String SQL = "SELECT * FROM MOTOR_BOOKING";
            
            PreparedStatement ps = con.prepareStatement(SQL);
            
            ResultSet rs = ps.executeQuery( );
            
            while(rs.next())
            {
                mB = new MotorBooking();
                
                mB.setCustomerIc(rs.getString("IC"));
                mB.setCustomerName(rs.getString("NAME"));
                mB.setGender(rs.getString("GENDER"));
                mB.setUserType(rs.getString("CUST_TYPE"));
                mB.setVehicleReg(rs.getString("MOTOR_REG"));
                mB.setVehicleName(rs.getString("MOTOR_TYPE"));
                mB.setPrice(rs.getDouble("PRICE"));
                mB.setTotalHour(rs.getInt("TOTAL_HOUR"));
               
                customerList.add(mB);
            }
        }
        catch(SQLException err)
        {
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
        return customerList;
    }
    
    public void saveItem(MotorBooking mB)
    {
        String customerIc = mB.getCustomerIc();
        String customerName = mB.getCustomerName();
        String gender = mB.getGender();
        String userType = mB.getUserType();
        String motorReg = mB.getVehicleReg();
        String motorType = mB.getVehicleName();
        double motorPrice = mB.getPrice();
        int totalHour = mB.getTotalHour();
        double totalPrice = mB.getTotalPrice();
        
        try
        {
            connectToDatabase();
            
            String SQL = "INSERT INTO MOTOR_BOOKING Values (?,?,?,?,?,?,?,?,?)";
            
            PreparedStatement ps = con.prepareStatement(SQL);
            
            ps.setString(1,customerIc);
            ps.setString(2,customerName);
            ps.setString(3,gender);
            ps.setString(4,userType);
             ps.setString(5,motorReg);
            ps.setString(6,motorType);
            ps.setDouble(7,motorPrice);
            ps.setInt(8,totalHour);
            ps.setDouble(9,totalPrice);
            
            ps.executeUpdate();
        }
        catch(SQLException err)
        {
            JOptionPane.showMessageDialog(null,err.getMessage());
        }
    }
    
    public MotorBooking searchCustomer (String searchIC)
    {
        try
        {
            connectToDatabase();
            
            String SQL = "SELECT * FROM MOTOR_BOOKING where IC=?";
            
            PreparedStatement ps = con.prepareStatement(SQL); 
            
            ps.setString(1, searchIC);     
            
            ResultSet rs = ps.executeQuery();  
            
            mB = new MotorBooking();
            
            if (rs.next()) 
            {
                mB.setCustomerIc(rs.getString("IC"));
                mB.setCustomerName(rs.getString("NAME"));
                mB.setGender(rs.getString("GENDER"));
                mB.setUserType(rs.getString("CUST_TYPE"));
                mB.setVehicleReg(rs.getString("MOTOR_REG"));
                mB.setVehicleName(rs.getString("MOTOR_TYPE"));
                mB.setPrice(rs.getDouble("PRICE"));
                mB.setTotalHour(rs.getInt("TOTAL_HOUR"));
            }
        }
        catch (SQLException err) 
        {
              JOptionPane.showMessageDialog(null, err.getMessage());
        }
        return mB;
    }
    
}
