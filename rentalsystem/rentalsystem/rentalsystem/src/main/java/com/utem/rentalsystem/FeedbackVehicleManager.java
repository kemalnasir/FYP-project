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
public class FeedbackVehicleManager 
{
    private ArrayList<FeedbackVehicle> feedbackVehicleList;
    private FeedbackVehicle f = new FeedbackVehicle();
    
    Connection con;

    public FeedbackVehicleManager() {}
    
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
    
    public ArrayList<FeedbackVehicle> readAll()
    {
        feedbackVehicleList = new ArrayList<FeedbackVehicle>();
        
        try
        {
            connectToDatabase();
            
            String SQL = "SELECT VEHICLE_TYPE,SATISFACTION,RENTAL,PROBLEM,MESSAGE,IMPROVEMENT FROM FEEDBACK_VEHICLE";
            
            PreparedStatement ps = con.prepareStatement(SQL);
            
            ResultSet rs = ps.executeQuery( );
            
            while(rs.next())
            {
                f = new FeedbackVehicle();

                f.setVehicleType(rs.getString("VEHICLE_TYPE"));
                f.setSatisfaction(rs.getString("SATISFACTION"));
                f.setRental(rs.getString("RENTAL"));
                f.setProblem(rs.getString("PROBLEM"));
                f.setMessage(rs.getString("MESSAGE"));
                f.setImprovement(rs.getString("IMPROVEMENT"));
                
                feedbackVehicleList.add(f);
            }
        }
        catch(SQLException err)
        {
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
        return feedbackVehicleList;
    }
    
    public void insertData(FeedbackVehicle f)
    {
        String vehicleType = f.getVehicleType();
        String Satisfaction = f.getSatisfaction();
        String rental = f.getRental();
        String problem = f.getProblem();
        String message = f.getMessage();
        String improvement = f.getImprovement();
        
        try
        {
            connectToDatabase();
            
            String SQL = "INSERT INTO FEEDBACK_VEHICLE (VEHICLE_TYPE, SATISFACTION, RENTAL, PROBLEM, MESSAGE, IMPROVEMENT) VALUES (?,?,?,?,?,?)";
            
            PreparedStatement ps = con.prepareStatement(SQL);
     
            ps.setString(1,vehicleType);
            ps.setString(2,Satisfaction);
            ps.setString(3,rental);
            ps.setString(4,problem);
            ps.setString(5,message);
            ps.setString(6,improvement);
            
            ps.executeUpdate();
        }
        catch(SQLException err)
        {
            JOptionPane.showMessageDialog(null,err.getMessage());
        }
    }

}
