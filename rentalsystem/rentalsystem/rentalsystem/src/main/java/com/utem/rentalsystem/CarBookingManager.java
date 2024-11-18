/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utem.rentalsystem;

import java.sql.*;
import java.util.*;
import javax.swing.*;
import java.util.Date;

/**
 *
 * @author 
 */
public class CarBookingManager
{
    private ArrayList<CarBooking> customerList;
    private CarBooking c = new CarBooking();
    
    Connection con;

    public CarBookingManager() 
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
    
    public ArrayList<CarBooking> readAll()
    {
        customerList = new ArrayList<CarBooking>();
        
        try
        {
            connectToDatabase();
            
            String SQL = "SELECT * FROM CAR_BOOKING";
            
            PreparedStatement ps = con.prepareStatement(SQL);
            
            ResultSet rs = ps.executeQuery( );
            
            while(rs.next())
            {
                c = new CarBooking();
                
                c.setCustomerIc(rs.getString("IC"));
                c.setCustomerName(rs.getString("NAME"));
                c.setGender(rs.getString("GENDER"));
                c.setUserType(rs.getString("CUST_TYPE"));
                c.setVehicleReg(rs.getString("CAR_REG"));
                c.setVehicleName(rs.getString("CAR_TYPE"));
                c.setPrice(rs.getDouble("PRICE"));
                c.setTotalHour(rs.getInt("TOTAL_HOUR"));
               
                customerList.add(c);
            }
        }
        catch(SQLException err)
        {
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
        return customerList;
    }
    
    public void saveItem(CarBooking c)
    {
        String customerIc = c.getCustomerIc();
        String customerName = c.getCustomerName();
        String gender = c.getGender();
        String userType = c.getUserType();
        String carReg = c.getVehicleReg();
        String carType = c.getVehicleName();
        double carPrice = c.getPrice();
        int totalHour = c.getTotalHour();
        double totalPrice = c.getTotalPrice();
        
        try
        {
            connectToDatabase();
            
            String SQL = "INSERT INTO CAR_BOOKING Values (?,?,?,?,?,?,?,?,?)";
            
            PreparedStatement ps = con.prepareStatement(SQL);
            
            ps.setString(1,customerIc);
            ps.setString(2,customerName);
            ps.setString(3,gender);
            ps.setString(4,userType);
            ps.setString(5,carReg);
            ps.setString(6,carType);
            ps.setDouble(7,carPrice);
            ps.setInt(8,totalHour);
            ps.setDouble(9,totalPrice);
            
            ps.executeUpdate();
        }
        catch(SQLException err)
        {
            JOptionPane.showMessageDialog(null,err.getMessage());
        }
    }
    
    public CarBooking searchCustomer (String searchIC){
    try{
    
        connectToDatabase();
        String SQL = "SELECT * FROM CAR_BOOKING where IC=?";    
        PreparedStatement ps = con.prepareStatement(SQL);       
        ps.setString(1, searchIC);        
        ResultSet rs = ps.executeQuery();       
        c = new CarBooking();
        if (rs.next()) {
        c.setCustomerIc(rs.getString("IC"));
        c.setCustomerName(rs.getString("NAME"));
        c.setGender(rs.getString("GENDER"));
        c.setUserType(rs.getString("CUST_TYPE"));
        c.setVehicleReg(rs.getString("CAR_REG"));
        c.setVehicleName(rs.getString("CAR_TYPE"));
        c.setPrice(rs.getDouble("PRICE"));
        c.setTotalHour(rs.getInt("TOTAL_HOUR"));
        }
    }
    catch (SQLException err) {
          JOptionPane.showMessageDialog(null, err.getMessage());
    }
    return c;
}
}