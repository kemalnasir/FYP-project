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
public class FeedbackWebsiteManager 
{
    private ArrayList<FeedbackWebsite> feedbackWebsiteList;
    private FeedbackWebsite f = new FeedbackWebsite();
    
    Connection con;

    public FeedbackWebsiteManager() {}
    
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
    
    public ArrayList<FeedbackWebsite> readAll()
    {
        feedbackWebsiteList = new ArrayList<FeedbackWebsite>();
        
        try
        {
            connectToDatabase();
            
            String SQL = "SELECT VISIT_REASON,VISIT,SATISFACTION,MESSAGE,IMPROVEMENT FROM FEEDBACK_WEBSITE";
            
            PreparedStatement ps = con.prepareStatement(SQL);
            
            ResultSet rs = ps.executeQuery( );
            
            while(rs.next())
            {
                f = new FeedbackWebsite();
                
                f.setVisitReason(rs.getString("VISIT_REASON"));
                f.setVisit(rs.getString("VISIT"));
                f.setSatisfaction(rs.getString("SATISFACTION"));
                f.setMessage(rs.getString("MESSAGE"));
                f.setImprovement(rs.getString("IMPROVEMENT"));
                
                feedbackWebsiteList.add(f);
            }
        }
        catch(SQLException err)
        {
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
        return feedbackWebsiteList;
    }
    
    public void insertData(FeedbackWebsite f)
    {
        String visitReason = f.getVisitReason();
        String visit = f.getVisit();
        String satisfaction = f.getSatisfaction();
        String message = f.getMessage();
        String improvement = f.getImprovement();
        
        try
        {
            connectToDatabase();
            
            String SQL = "INSERT INTO FEEDBACK_WEBSITE(VISIT_REASON,VISIT,SATISFACTION,MESSAGE,IMPROVEMENT) Values (?,?,?,?,?)";
            
            PreparedStatement ps = con.prepareStatement(SQL);
            
            ps.setString(1,visitReason);
            ps.setString(2,visit);
            ps.setString(3,satisfaction);
            ps.setString(4,message);
            ps.setString(5,improvement);
            
            ps.executeUpdate();
        }
        catch(SQLException err)
        {
            JOptionPane.showMessageDialog(null,err.getMessage());
        }
    }
    
   
}
