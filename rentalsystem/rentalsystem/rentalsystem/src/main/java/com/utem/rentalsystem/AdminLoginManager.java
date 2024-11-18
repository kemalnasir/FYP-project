/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utem.rentalsystem;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author 
 */
public class AdminLoginManager 
{
    Connection con;

    public AdminLoginManager(){}
    
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
    
    public boolean loginValidation(AdminLogin aL)
    {
        
        try
        {
            connectToDatabase();
            
            String SQL = "SELECT * FROM ADMIN_LOGIN where USERNAME=? and PASSWORD=?";
            
            PreparedStatement ps = con.prepareStatement(SQL);
            
            ps.setString(1,aL.getUserName());
            
            ps.setString(2,aL.getPassword());
            
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
        catch(SQLException err)
        {
            JOptionPane.showMessageDialog(null, err.getMessage());
            return false;
        }
    }
    
}
