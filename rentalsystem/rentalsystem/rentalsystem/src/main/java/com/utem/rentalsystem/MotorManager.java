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
public class MotorManager 
{
    private ArrayList<Motor> motorList;
    
    //Declare object for class car to set and get values of car
    private Motor motor = new Motor();
    
    //Declare object to set up a connection to a database
    Connection con;


    private void connectToDatabase()
    {
        try
        {
            String host = "jdbc:derby://localhost:1527/carRental";
            con = DriverManager.getConnection(host);
        }
        catch (SQLException err)
        {
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }

    //method definition: Read all data from database and
    // return it to the calling function
    public ArrayList<Motor> readAll()
    {
        //create arrayList object to store data from database
        motorList = new ArrayList<Motor>();
        try
        {
            //call method to establish database connection
            connectToDatabase();

            //SQL statement
            String SQL = "SELECT * FROM Motor";

            //Declare object to execute parameterized query
            PreparedStatement ps = con.prepareStatement(SQL);

            //Execute query and returns a set of resultts that contains the data
            ResultSet rs = ps.executeQuery();

            //loop to read each data in the rs table
            while(rs.next( )){
                //create new motor for each iteration
                motor = new Motor();

                //call setter to assign values to car atributes
                motor.setVehicleReg(rs.getString("MOTOR_REG"));
                motor.setVehicleName(rs.getString("MOTOR_NAME"));
                motor.setPrice(rs.getDouble("PRICE"));
                motor.setVehicleStatus(rs.getString("STATUS"));
                //add each car to the list of cars
                motorList.add(motor);
            }
        }
        catch(SQLException err)
        {
            JOptionPane.showMessageDialog(null, err.getMessage());
        } 
        //return the list of cars to the calling method
        return motorList;
    }

    public ArrayList<Motor> readAvailable()
    {
        //create arrayList object to store data from database
        motorList = new ArrayList<Motor>();
        String MotorStatus = "Available";
        try{
            //call method to establish database connection
            connectToDatabase();

            //SQL statement
            String SQL = "SELECT * FROM Motor WHERE STATUS = '"+MotorStatus+"'";

            //Declare object to execute parameterized query
            PreparedStatement ps = con.prepareStatement(SQL);

            //Execute query and returns a set of resultts that contains the data
            ResultSet rs = ps.executeQuery();

            //loop to read each data in the rs table
            while(rs.next( ))
            {
                //create new car for each iteration
                motor = new Motor();

                //call setter to assign values to car atributes
                motor.setVehicleReg(rs.getString("MOTOR_REG"));
                motor.setVehicleName(rs.getString("MOTOR_NAME"));
                motor.setPrice(rs.getDouble("PRICE"));
                motor.setVehicleStatus(rs.getString("STATUS"));
                //add each car to the list of cars
                motorList.add(motor);
            }
        }
        catch(SQLException err)
        {
            JOptionPane.showMessageDialog(null, err.getMessage());
        } 
        //return the list of cars to the calling method
        return motorList;
    }

    public ArrayList<Motor> readBooked()
    {
        //create arrayList object to store data from database
        motorList = new ArrayList<Motor>();
        String MotorStatus = "Booked";
        try{
            //call method to establish database connection
            connectToDatabase();

            //SQL statement
            String SQL = "SELECT * FROM Motor WHERE STATUS = '"+MotorStatus+"'";

            //Declare object to execute parameterized query
            PreparedStatement ps = con.prepareStatement(SQL);

            //Execute query and returns a set of resultts that contains the data
            ResultSet rs = ps.executeQuery();

            //loop to read each data in the rs table
            while(rs.next( )){
                //create new car for each iteration
                motor = new Motor();

                //call setter to assign values to car atributes
                motor.setVehicleReg(rs.getString("MOTOR_REG"));
                motor.setVehicleName(rs.getString("MOTOR_NAME"));
                motor.setPrice(rs.getDouble("PRICE"));
                motor.setVehicleStatus(rs.getString("STATUS"));
                //add each car to the list of cars
                motorList.add(motor);
            }
        }
        catch(SQLException err)
        {
            JOptionPane.showMessageDialog(null, err.getMessage());
        } 
        //return the list of cars to the calling method
        return motorList;
   }


    void saveMotor(Motor motor) {
       //call method to assign car attributes values to the variables
        String veReg = motor.getVehicleReg();
        String veName = motor.getVehicleName();
        double price = motor.getPrice();
        String status = motor.getVehicleStatus();
        
        try{
            //call method to establish database connection
            connectToDatabase();
            
            //SQL statement
            String SQL = "INSERT INTO Motor VALUES (?, ?, ?, ?)";
            
            //Declare object to execute parameterized query
            PreparedStatement ps = con.prepareStatement(SQL);
            
            //set the preparestatement parameters
            ps.setString(1, veReg);
            ps.setString(2, veName);
            ps.setDouble(3, price);
            ps.setString(4, status);
            
            //call executeUpdate to execute our sql insert statement
            ps.executeUpdate();
        }
        catch (SQLException err)
        {
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }

    void editMotor(String editReg, Motor motor) 
    {
        // Call getter to assign Car attributes values
        String name = motor.getVehicleName();
        double price = motor.getPrice();
        String stat = motor.getVehicleStatus();

        try
        {
            // Call method to establish database connection
            connectToDatabase();

            // SQL statement
            String SQL = "UPDATE Motor SET MOTOR_NAME = ?,"
                    + "PRICE = ?, STATUS = ? WHERE MOTOR_REG = ?";

            // Declare object to execute parameterized query
            PreparedStatement ps = con.prepareStatement (SQL);

            // Set the preparestatement parameters
            ps.setString(1, name);
            ps.setDouble(2, price);
            ps.setString(3, stat);
            ps.setString(4, editReg);

            // Call executeUpdate to execute the sql update statement
            ps.executeUpdate();
        }
        catch ( SQLException err ) 
        {
            JOptionPane.showMessageDialog(null, err.getMessage()) ;
        }
    }

    public Motor searchMotor(String searchReg) 
    {
        try
        {
            //call method to establish database connection
            connectToDatabase();
            
            //SQL statement
            String SQL = "SELECT * FROM Motor where MOTOR_REG =?";
            
            //declare object to execute parameterized query
            PreparedStatement ps = con.prepareStatement(SQL);
            
            //set the preparestatement parameters
            ps.setString(1, searchReg);
            
            //execute query and returns a set of results that contains the data
            ResultSet rs = ps.executeQuery();
            
            //create new car
            motor = new Motor();
            
            //if there is a data in the set of the esults
            if(rs.next( ))
            {
                //call setter to assign values to car attributes
                motor.setVehicleReg(rs.getString("MOTOR_REG"));
                motor.setVehicleName(rs.getString("MOTOR_NAME"));
                motor.setPrice(rs.getDouble("PRICE"));
                motor.setVehicleStatus(rs.getString("STATUS"));   
            }
        }
        catch (SQLException err)
        {
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
    //return the found car to the calling method
    return motor;
   }

    public void deleteMotor(String deleteReg)
    {
        try
        {
            // Call method to establish database connection
            connectToDatabase();

            // SQL statement
            String SQL = "DELETE FROM Motor where MOTOR_REG=?";

            // Declare object to execute parameterized query
            PreparedStatement ps = con.prepareStatement(SQL);

            // Set the preparestatement parameters
            ps.setString(1,deleteReg);

            // Call executeUpdate to execute the sql delete statement
            ps.executeUpdate();
        }
        catch ( SQLException err ) 
        {
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }
    
      public Motor searchMotorBook(String searchReg) 
    {
        try
        {
            //call method to establish database connection
            connectToDatabase();
            
            //SQL statement
            String SQL = "SELECT * FROM Motor where MOTOR_REG =?";
            
            //declare object to execute parameterized query
            PreparedStatement ps = con.prepareStatement(SQL);
            //set the preparestatement parameters
            ps.setString(1, searchReg);            
            //execute query and returns a set of results that contains the data
            ResultSet rs = ps.executeQuery();            
            //create new car
            motor = new Motor();            
            //if there is a data in the set of the esults
            if(rs.next( ))
            {
                //call setter to assign values to car attributes
                motor.setVehicleReg(rs.getString("MOTOR_REG"));
                motor.setVehicleName(rs.getString("MOTOR_NAME"));
                motor.setPrice(rs.getDouble("PRICE"));
            }
        }
        catch (SQLException err){
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
    //return the found car to the calling method
    return motor;
   }
}

