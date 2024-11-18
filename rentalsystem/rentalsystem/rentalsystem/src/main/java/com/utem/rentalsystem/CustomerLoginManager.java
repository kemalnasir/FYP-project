/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utem.rentalsystem;

import java.sql.*;
import javax.swing.*;

/**
 *
 * @author 
 */
public class CustomerLoginManager 
{
    Connection con;

    public CustomerLoginManager(){}
    
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
    
    public boolean loginValidation(CustomerLogin custLogin)
    {
        try
        {
            connectToDatabase();
            
            String SQL = "SELECT USERNAME,PASSWORD FROM Registration where USERNAME=? and PASSWORD=?";
            
            PreparedStatement ps = con.prepareStatement(SQL);
            
            ps.setString(1,custLogin.getUserName());
            ps.setString(2, custLogin.getPassword());
            
            ResultSet rs = ps.executeQuery( );
            
            if(rs.next())
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        catch (SQLException error)
        {
                JOptionPane.showMessageDialog(null, error.getMessage());
                return false;
        }
    }
}
