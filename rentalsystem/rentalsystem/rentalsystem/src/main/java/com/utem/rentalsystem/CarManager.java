/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utem.rentalsystem;

import java.sql.Connection;
import java.sql.*;
import java.util.*;
import javax.swing.*;
        


/**
 *
 * @author
 */     
public class CarManager 
{
    private ArrayList<Car> carList;
    
    //Declare object for class car to set and get values of car
    private Car car = new Car();
    
    //Declare object to set up a connection to a database
    Connection con;

    //method definition: set up a connection to a database        
    private void connectToDatabase(){
        try{
            String host = "jdbc:derby://localhost:1527/carRental";
            con = DriverManager.getConnection(host);
            }
            catch (SQLException err){
            JOptionPane.showMessageDialog(null, err.getMessage());
            }
    }

    //method definition: Read all data from database and
    // return it to the calling function
    public ArrayList<Car> readAll()
    {
        //create arrayList object to store data from database
        carList = new ArrayList<Car>();
        try
        {
            //call method to establish database connection
            connectToDatabase();

            //SQL statement
            String SQL = "SELECT * FROM Car";

            //Declare object to execute parameterized query
            PreparedStatement ps = con.prepareStatement(SQL);

            //Execute query and returns a set of resultts that contains the data
            ResultSet rs = ps.executeQuery();

            //loop to read each data in the rs table
            while(rs.next( ))
            {
                //create new car for each iteration
                car = new Car();

                //call setter to assign values to car atributes
                car.setVehicleReg(rs.getString("CAR_REG"));
                car.setVehicleName(rs.getString("CAR_NAME"));
                car.setSeatQuantity(rs.getInt("SEAT_QUANTITY"));
                car.setPrice(rs.getDouble("PRICE"));
                car.setVehicleStatus(rs.getString("STATUS"));
                //add each car to the list of cars
                carList.add(car);
            }
        }
        catch(SQLException err)
        {
            JOptionPane.showMessageDialog(null, err.getMessage());
        } 
        //return the list of cars to the calling method
        return carList;
    }

    public ArrayList<Car> readAvailable()
    {
        //create arrayList object to store data from database
        carList = new ArrayList<Car>();
        String CarStatus = "Available";
        try
        {
            //call method to establish database connection
            connectToDatabase();

            //SQL statement
            String SQL = "SELECT * FROM Car WHERE STATUS = '"+CarStatus+"'";

            //Declare object to execute parameterized query
            PreparedStatement ps = con.prepareStatement(SQL);

            //Execute query and returns a set of resultts that contains the data
            ResultSet rs = ps.executeQuery();

            //loop to read each data in the rs table
            while(rs.next( ))
            {
                //create new car for each iteration
                car = new Car();

                //call setter to assign values to car atributes
                car.setVehicleReg(rs.getString("CAR_REG"));
                car.setVehicleName(rs.getString("CAR_NAME"));
                car.setSeatQuantity(rs.getInt("SEAT_QUANTITY"));
                car.setPrice(rs.getDouble("PRICE"));
                car.setVehicleStatus(rs.getString("STATUS"));
                //add each car to the list of cars
                carList.add(car);
            }
        }
        catch(SQLException err)
        {
            JOptionPane.showMessageDialog(null, err.getMessage());
        } 
        //return the list of cars to the calling method
        return carList;
    }

    public ArrayList<Car> readBooked()
    {
        //create arrayList object to store data from database
        carList = new ArrayList<Car>();
        String CarStatus = "Booked";
        try{
            //call method to establish database connection
            connectToDatabase();

            //SQL statement
            String SQL = "SELECT * FROM Car WHERE STATUS = '"+CarStatus+"'";

            //Declare object to execute parameterized query
            PreparedStatement ps = con.prepareStatement(SQL);

            //Execute query and returns a set of resultts that contains the data
            ResultSet rs = ps.executeQuery();

            //loop to read each data in the rs table
            while(rs.next( )){
                //create new car for each iteration
                car = new Car();

                //call setter to assign values to car atributes
                car.setVehicleReg(rs.getString("CAR_REG"));
                car.setVehicleName(rs.getString("CAR_NAME"));
                car.setSeatQuantity(rs.getInt("SEAT_QUANTITY"));
                car.setPrice(rs.getDouble("PRICE"));
                car.setVehicleStatus(rs.getString("STATUS"));
                //add each car to the list of cars
                carList.add(car);
            }
        }
        catch(SQLException err){
            JOptionPane.showMessageDialog(null, err.getMessage());
        } 
        //return the list of cars to the calling method
        return carList;
    }


    void saveCar(Car car) 
    {
        //call method to assign car attributes values to the variables
        String carReg = car.getVehicleReg();
        String carName = car.getVehicleName();
        int quantity = car.getSeatQuantity();
        double price = car.getPrice();
        String status = car.getVehicleStatus();

        try
        {
            //call method to establish database connection
            connectToDatabase();

            //SQL statement
            String SQL = "INSERT INTO Car VALUES (?, ?, ?, ?, ?)";

            //Declare object to execute parameterized query
            PreparedStatement ps = con.prepareStatement(SQL);

            //set the preparestatement parameters
            ps.setString(1, carReg);
            ps.setString(2, carName);
            ps.setInt(3, quantity);
            ps.setDouble(4, price);
            ps.setString(5, status);

            //call executeUpdate to execute our sql insert statement
            ps.executeUpdate();
        }
        catch (SQLException err)
        {
                JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }

    void editCar(String editReg, Car car) 
    {
        // Call getter to assign Car attributes values
        String name = car.getVehicleName();
        int qty = car.getSeatQuantity();
        double price = car.getPrice();
        String stat = car.getVehicleStatus();

        try
        {
            // Call method to establish database connection
            connectToDatabase();

            // SQL statement
            String SQL = "UPDATE Car SET CAR_NAME = ?, SEAT_QUANTITY = ?, "
                    + "PRICE = ?, STATUS = ? WHERE CAR_REG = ?";

            // Declare object to execute parameterized query
            PreparedStatement ps = con.prepareStatement (SQL);

            // Set the preparestatement parameters
            ps.setString(1, name);
            ps.setInt(2, qty);
            ps.setDouble(3, price);
            ps.setString(4, stat);
            ps.setString(5, editReg);

            // Call executeUpdate to execute the sql update statement
            ps.executeUpdate();
        }
        catch ( SQLException err ) 
        {
            JOptionPane.showMessageDialog(null, err.getMessage()) ;
        }
    }

    public Car searchCar(String searchReg) 
    {
        try
        {
            //call method to establish database connection
            connectToDatabase();
            
            //SQL statement
            String SQL = "SELECT * FROM Car where CAR_REG =?";
            
            //declare object to execute parameterized query
            PreparedStatement ps = con.prepareStatement(SQL);
            
            //set the preparestatement parameters
            ps.setString(1, searchReg);
            
            //execute query and returns a set of results that contains the data
            ResultSet rs = ps.executeQuery();
            
            //create new car
            car = new Car();
            
            //if there is a data in the set of the esults
            if(rs.next( ))
            {
                //call setter to assign values to car attributes
                car.setVehicleReg(rs.getString("CAR_REG"));
                car.setVehicleName(rs.getString("CAR_NAME"));
                car.setSeatQuantity(rs.getInt("SEAT_QUANTITY"));
                car.setPrice(rs.getDouble("PRICE"));
                car.setVehicleStatus(rs.getString("STATUS"));   
            }
        }
        catch (SQLException err){
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
    //return the found car to the calling method
    return car;
   }

    public void deleteCar(String deleteReg)
    {
            try
            {
                // Call method to establish database connection
                connectToDatabase();

                // SQL statement
                String SQL = "DELETE FROM Car where CAR_REG=?";

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
    
    public Car searchCarBook(String searchReg) 
    {
        try
        {
            //call method to establish database connection
            connectToDatabase();
            
            //SQL statement
            String SQL = "SELECT * FROM Car where CAR_REG =?";
            
            //declare object to execute parameterized query
            PreparedStatement ps = con.prepareStatement(SQL);
            //set the preparestatement parameters
            ps.setString(1, searchReg);            
            //execute query and returns a set of results that contains the data
            ResultSet rs = ps.executeQuery();            
            //create new car
            car = new Car();            
            //if there is a data in the set of the esults
            if(rs.next( ))
            {
                //call setter to assign values to car attributes
                car.setVehicleReg(rs.getString("CAR_REG"));
                car.setVehicleName(rs.getString("CAR_NAME"));
                car.setPrice(rs.getDouble("PRICE"));
            }
        }
        catch (SQLException err){
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
    //return the found car to the calling method
    return car;
   }
    }
