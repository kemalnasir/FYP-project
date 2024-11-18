/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utem.rentalsystem;

import java.sql.*;
import java.util.*;
import javax.swing.*;

/**
 *
 * @author
 */
public class CustomerRegistrationManager 
{
    private ArrayList<CustomerRegistration> registrationList;
    private CustomerRegistration r = new CustomerRegistration();
    
    Connection con;

    public CustomerRegistrationManager(){}
    
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
    
    public ArrayList<CustomerRegistration> readAll()
    {
        registrationList = new ArrayList<CustomerRegistration>();
        
        try
        {
            connectToDatabase();
            
            String SQL = "SELECT EMAIL,PHONE_NUMBER,USERNAME,PASSWORD FROM Registration";
            
            PreparedStatement ps = con.prepareStatement(SQL);
            
            ResultSet rs = ps.executeQuery( );
            
            while(rs.next())
            {
                r = new CustomerRegistration();
                
                r.setEmail(rs.getString("EMAIL"));
                r.setPhoneNumber(rs.getString("PHONE_NUMBER"));
                r.setUserName(rs.getString("USERNAME"));
                r.setPassword(rs.getString("PASSWORD"));
                
                registrationList.add(r);
            }
        }
        catch(SQLException err)
        {
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
        return registrationList;
    }
    
    public void insertData(CustomerRegistration r)
    {
        String email = r.getEmail();
        String phoneNumber = r.getPhoneNumber();
        String userName = r.getUserName();
        String password = r.getPassword();
        
        try
        {
            connectToDatabase();
            
            String SQL = "INSERT INTO Registration(EMAIL,PHONE_NUMBER,USERNAME,PASSWORD) Values (?,?,?,?)";
            
            PreparedStatement ps = con.prepareStatement(SQL);
            
            ps.setString(1,email);
            ps.setString(2,phoneNumber);
            ps.setString(3,userName);
            ps.setString(4,password);
            
            ps.executeUpdate();
        }
        catch(SQLException err)
        {
            JOptionPane.showMessageDialog(null,err.getMessage());
        }
    }
}
