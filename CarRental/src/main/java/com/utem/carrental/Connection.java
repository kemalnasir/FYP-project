/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utem.carrental;

import java.sql.*;
import java.util.*;
import javax.swing.*;
import javax.swing.JOptionPane;
import javax.swing.table.*;
import java.io.*;
import java.text.*;
import java.awt.Color;
import javax.swing.UIManager;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.jdbc.JDBCCategoryDataset;

/**
 *
 * @author kemal
 */
public class Connection {

    // Declare the list of Customer to store the user object from database
    private ArrayList<Customer> customerList;

    // Declare object for class Customer to set and get values of Item
    private Customer customer = new Customer();

    // Declare the list of Car to store the user object from database
    private ArrayList<Car> carList;

    // Declare object for class Car to set and get values of Item
    private Car car = new Car();

    // Declare the list of Order to store the user object from database
    private ArrayList<Order> orderList;

    // Declare object for class Order to set and get values of Item
    private Order order = new Order();

    // Declare the list of Order to store the user object from database
    private ArrayList<ReturnOrder> returnOrderList;

    // Declare object for class Order to set and get values of Item
    private ReturnOrder returnOrder = new ReturnOrder();

    // Declare the list of Return to store the user object from database
    private ArrayList<ReturnC> returnCList;

    // Declare object for class ReturnC to set and get values of Item
    private ReturnC returnC = new ReturnC();

    // Declare the list of feedback to store the user object from database
    private ArrayList<Feedback> feedbackList;

    // Declare object for class Product to set and get values of Item
    private Feedback feedback = new Feedback();

    // Declare object to set up a connection to a database
    java.sql.Connection con;

    // default constructor
    public Connection() {
    }

    // set up a connection to a database
    private void connectToDatabase() {
        try {
            String host = "jdbc:derby://localhost:1527//customer";
            con = DriverManager.getConnection(host);
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }

    // read all customer data from database and return it to the calling function
    public ArrayList<Customer> readAllUser() {
        customerList = new ArrayList<Customer>();
        try {
            // call method to establish database connection
            connectToDatabase();

            // sql statement
            String SQL = "SELECT * FROM customerTable";

            // declare object to execute parameterized query
            PreparedStatement ps = con.prepareStatement(SQL);

            // execute query and returns a set of results that contains the data
            ResultSet rs = ps.executeQuery();

            // loop to read each data in the rs table
            while (rs.next()) {
                customer = new Customer();

                // call setter to assign values to Item attributes
                customer.setName(rs.getString("NAME"));
                customer.setPhoneNo(rs.getString("PHONENO"));
                customer.setAddress(rs.getString("ADDRESS"));
                customer.setEmail(rs.getString("EMAIL"));
                customer.setPassword(rs.getString("PASSWORD"));

                // Add each Item to the list of item
                customerList.add(customer);
            }
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
        return customerList;
    }

    // save customer data into database
    public void saveCustomer(Customer customer) {
        // call getter to assign customer attributes values to the variables
        String name = customer.getName();
        String phoneNo = customer.getPhoneNo();
        String address = customer.getAddress();
        String email = customer.getEmail();
        String password = customer.getPassword();

        try {
            // call method to establish database connection
            connectToDatabase();

            // sql statement
            String SQL = "INSERT INTO customerTable VALUES (?, ?, ?, ?, ?)";

            // declare object to execute parameterized query
            PreparedStatement ps = con.prepareStatement(SQL);

            // set the preparestatement parameters
            ps.setString(1, name);
            ps.setString(2, phoneNo);
            ps.setString(3, address);
            ps.setString(4, email);
            ps.setString(5, password);

            // call executeUpdate to execute out sql insert statement
            ps.executeUpdate();
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }

    // read all car data from database and return it to the calling function
    public ArrayList<Car> readAllCar() {
        carList = new ArrayList<Car>();
        try {
            // call method to establish database connection
            connectToDatabase();

            // sql statement
            String SQL = "SELECT * FROM carTable";

            // declare object to execute parameterized query
            PreparedStatement ps = con.prepareStatement(SQL);

            // execute query and returns a set of results that contains the data
            ResultSet rs = ps.executeQuery();

            // loop to read each data in the rs table
            while (rs.next()) {
                car = new Car();

                // call setter to assign values to Item attributes
                car.setRegisterId(rs.getString("REGISTERID"));
                car.setName(rs.getString("NAME"));
                car.setSeatQuantity(rs.getString("SEATQUANTITY"));
                car.setPrice(rs.getString("PRICE"));
                car.setStatus(rs.getString("STATUS"));

                // Add each Item to the list of item
                carList.add(car);
            }
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
        return carList;
    }

    // read all product data from database and return it to the calling function
    public ArrayList<Order> readAllOrder() {
        orderList = new ArrayList<Order>();
        try {
            // call method to establish database connection
            connectToDatabase();

            // sql statement
            String SQL = "SELECT * FROM orderTable"; //inner join customerTable, carTable ON orderTable.icNo = customerTable.icNo AND orderTable.registerId = carTable.registerId";

            // declare object to execute parameterized query
            PreparedStatement ps = con.prepareStatement(SQL);

            // execute query and returns a set of results that contains the data
            ResultSet rs = ps.executeQuery();

            // loop to read each data in the rs table
            while (rs.next()) {
                order = new Order();

                // call setter to assign values to Item attributes
                order.setOrderId(rs.getString("ORDERID"));
                order.setRegisterId(rs.getString("REGISTERID"));
                order.setEmail(rs.getString("Email"));
                order.setPeriod(rs.getString("PERIOD"));
                order.setDate(rs.getString("DATE"));
                order.setReturnDate(rs.getString("RETURNDATE"));
                order.setTotal(rs.getString("TOTAL"));

                // Add each Item to the list of item
                orderList.add(order);
            }
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
        return orderList;
    }

    // read all product data from database and return it to the calling function
    public ArrayList<ReturnOrder> readAllReturnOrder() {
        returnOrderList = new ArrayList<ReturnOrder>();
        carList = new ArrayList<Car>();
        try {
            // call method to establish database connection
            connectToDatabase();

            // sql statement
            String SQL = "SELECT * FROM RETURNORDERTABLE INNER JOIN carTable ON RETURNORDERTABLE.RegisterId = carTable.RegisterId";
            // declare object to execute parameterized query
            PreparedStatement ps = con.prepareStatement(SQL);

            // execute query and returns a set of results that contains the data
            ResultSet rs = ps.executeQuery();

            // loop to read each data in the rs table
            while (rs.next()) {
                returnOrder = new ReturnOrder();

                // call setter to assign values to Item attributes
                returnOrder.setOrderId(rs.getString("ORDERID"));
                // Add each Item to the list of item
                returnOrderList.add(returnOrder);
            }
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
        return returnOrderList;
    }

    // read all customer data from database and return it to the calling function
    public ArrayList<ReturnC> readAllReturn() {
        returnCList = new ArrayList<ReturnC>();
        try {
            // call method to establish database connection
            connectToDatabase();

            // sql statement
            String SQL = "SELECT * FROM returnTable";

            // declare object to execute parameterized query
            PreparedStatement ps = con.prepareStatement(SQL);

            // execute query and returns a set of results that contains the data
            ResultSet rs = ps.executeQuery();

            // loop to read each data in the rs table
            while (rs.next()) {
                returnC = new ReturnC();

                // call setter to assign values to Item attributes
                returnC.setReturnId(rs.getString("RETURNID"));
                returnC.setReturnDate(rs.getString("DATERETURN"));
                returnC.setFine(rs.getString("FINE"));
                returnC.setOrderId(rs.getString("ORDERID"));
                returnC.setEmail(rs.getString("Email"));
                returnC.setRegisterId(rs.getString("REGISTERID"));

                // Add each Item to the list of item
                returnCList.add(returnC);
            }
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
        return returnCList;
    }

    // save product data into database
    public void saveCar(Car car) {
        // call getter to assign Product attributes values to the variables
        String registerId = car.getRegisterId();
        String name = car.getName();
        String seatQuantity = car.getSeatQuantity();
        String price = car.getPrice();
        String status = ("Available");

        try {
            // call method to establish database connection
            connectToDatabase();

            // sql statement
            String SQL = "INSERT INTO carTable VALUES (?, ?, ?, ?, ?)";

            // declare object to execute parameterized query
            PreparedStatement ps = con.prepareStatement(SQL);

            // set the preparestatement parameters
            ps.setString(1, registerId);
            ps.setString(2, name);
            ps.setString(3, seatQuantity);
            ps.setString(4, price);
            ps.setString(5, status);
            // call executeUpdate to execute out sql insert statement
            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Successfully saved.");
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Car already exist!!");
        }
    }

    // update product data into database
    public void updateCar(String updateID, Car car) {
        String name = car.getName();
        String seatQuantity = car.getSeatQuantity();
        String price = car.getPrice();

        try {
            connectToDatabase();

            String SQL = "UPDATE carTable SET NAME = ?, SEATQUANTITY = ?, "
                    + "PRICE = ? WHERE REGISTERID = ?";

            PreparedStatement ps = con.prepareStatement(SQL);

            // set the preparestatement parameters
            ps.setString(1, name);
            ps.setString(2, seatQuantity);
            ps.setString(3, price);
            ps.setString(4, updateID);

            // call executeupdate to execute the sql update statement
            ps.executeUpdate();
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }

    // delete product data into database
    public void deleteCar(String registerId) {
        try {
            // call method to establish database connection
            connectToDatabase();

            // sql statement
            String SQL = "DELETE FROM carTable WHERE registerId = ?";

            // declare object to execute parameterized query
            PreparedStatement ps = con.prepareStatement(SQL);

            // set the preparestatement parameters
            ps.setString(1, registerId);

            // call executeUpdate to execute the sql delete statement
            ps.executeUpdate();
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }

    // delete return order data into database
    public void deleteReturnOrder(String orderId) {
        try {
            // call method to establish database connection
            connectToDatabase();

            // sql statement
            String SQL = "DELETE FROM RETURNORDERTABLE WHERE ORDERID = ?";

            // declare object to execute parameterized query
            PreparedStatement ps = con.prepareStatement(SQL);

            // set the preparestatement parameters
            ps.setString(1, orderId);

            // call executeUpdate to execute the sql delete statement
            ps.executeUpdate();
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }

    // get car data by name
    public Car getCarByName(String name) {
        try {
            // call method to establish database connection
            connectToDatabase();

            // sql statement
            String SQL = "SELECT * FROM carTable WHERE name = ?";

            // declare object to execute parameterized query
            PreparedStatement ps = con.prepareStatement(SQL);

            // set the preparestatement parameters
            ps.setString(1, name);

            // execute query and returns a set of results that contains the data
            ResultSet rs = ps.executeQuery();

            // loop to read each data in the rs table
            while (rs.next()) {
                car.setRegisterId(rs.getString(1));
                car.setName(rs.getString(2));
                car.setSeatQuantity(rs.getString(3));
                car.setPrice(rs.getString(4));
                car.setStatus(rs.getString(5));
            }
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
        return car;
    }

    // save product data into database
    public void saveOrder(Order order, ReturnOrder returnOrder) {
        // call getter to assign Product attributes values to the variables
        String orderId = order.getOrderId();
        String registerId = order.getRegisterId();
        String email = order.getEmail();
        String period = order.getPeriod();
        String date = order.getDate();
        String returnDate = order.getReturnDate();
        String total = order.getTotal();
        ///////////////////////////////////////////////
        String orderId2 = returnOrder.getOrderId();
        String registerId2 = returnOrder.getRegisterId();
        String email2 = returnOrder.getEmail();
        String period2 = returnOrder.getPeriod();
        String date2 = returnOrder.getDate();
        String returnDate2 = returnOrder.getReturnDate();
        String total2 = returnOrder.getTotal();

        try {
            // call method to establish database connection
            connectToDatabase();

            String SQL = "INSERT INTO orderTable VALUES (?, ?, ?, ?, ?, ?, ?)";
            String SQL2 = "INSERT INTO RETURNORDERTABLE VALUES (?, ?, ?, ?, ?, ?, ?)";

            // declare object to execute parameterized query
            PreparedStatement ps = con.prepareStatement(SQL);
            PreparedStatement ps2 = con.prepareStatement(SQL2);

            // set the preparestatement parameters
            ps.setString(1, orderId);
            ps.setString(2, registerId);
            ps.setString(3, email);
            ps.setString(4, period);
            ps.setString(5, date);
            ps.setString(6, returnDate);
            ps.setString(7, total);
            /////////////////////////////
            ps2.setString(1, orderId2);
            ps2.setString(2, registerId2);
            ps2.setString(3, email2);
            ps2.setString(4, period2);
            ps2.setString(5, date2);
            ps2.setString(6, returnDate2);
            ps2.setString(7, total2);
            // call executeUpdate to execute out sql insert statement
            ps.executeUpdate();
            ps2.executeUpdate();
            
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Your order for the selected date already booked!");
        }
    }

    // get data from database and return it to the calling function
    public Customer loginUser(String email, String password) {
        Customer customer = null;
        try {
            // call method to establish database connection
            connectToDatabase();

            // sql statement
            String SQL = "SELECT * FROM customerTable WHERE Email = ? AND password = ?";

            // declare object to execute parameterized query
            PreparedStatement ps = con.prepareStatement(SQL);

            // set the preparestatement parameters
            ps.setString(1, email);
            ps.setString(2, password);

            // execute query and returns a set of results that contains the data
            ResultSet rs = ps.executeQuery();

            //icNo[0] = rs.getString("icNo");
            // loop to read each data in the rs table
            while (rs.next()) {
                customer = new Customer();

                // call setter to assign values to userTable attributes
                customer.setName(rs.getString("NAME"));
                customer.setPhoneNo(rs.getString("PHONENO"));
                customer.setAddress(rs.getString("ADDRESS"));
                customer.setEmail(rs.getString("EMAIL"));
                JOptionPane.showMessageDialog(null, "Login Successfully !!!");
            }
            
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
        return customer;
    }

    // get data from database and return it to the calling function
    public Customer showUser(String email) {
        Customer customer = null;
        try {
            // call method to establish database connection
            connectToDatabase();

            // sql statement
            String SQL = "SELECT * FROM customerTable WHERE Email = ?";

            // declare object to execute parameterized query
            PreparedStatement ps = con.prepareStatement(SQL);

            // set the preparestatement parameters
            ps.setString(1, email);

            // execute query and returns a set of results that contains the data
            ResultSet rs = ps.executeQuery();

            //icNo[0] = rs.getString("icNo");
            // loop to read each data in the rs table
            while (rs.next()) {
                //customer = new Customer();

                // call setter to assign values to userTable attributes
                OrderCar.TxtName.setText(rs.getString("NAME"));
                OrderCar.TxtPhoneNumber.setText(rs.getString("PHONENO"));
                OrderCar.TxtAddress.setText(rs.getString("ADDRESS"));
                OrderCar.TxtEmail.setText(rs.getString("EMAIL"));
                Home.TxtEmail.setText(rs.getString("EMAIL"));
                FeedbackCust.TxtEmail.setText(rs.getString("EMAIL"));
            }
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
        return customer;
    }

    // update car status into database
    public void updateCarStatus(String updateID, Car car) {
        String status = ("Booked");

        try {
            connectToDatabase();

            String SQL = "UPDATE carTable SET STATUS = ? WHERE REGISTERID = ?";

            PreparedStatement ps = con.prepareStatement(SQL);

            // set the preparestatement parameters
            ps.setString(1, status);
            ps.setString(2, updateID);

            // call executeupdate to execute the sql update statement
            ps.executeUpdate();
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }

    // get data from database and return it to the calling function
    public Order showOrder(String orderId) {
        Order order = null;
        try {
            // call method to establish database connection
            connectToDatabase();

            // sql statement
            String SQL = "SELECT * FROM orderTable WHERE orderId = ?";

            // declare object to execute parameterized query
            PreparedStatement ps = con.prepareStatement(SQL);

            // set the preparestatement parameters
            ps.setString(1, orderId);

            // execute query and returns a set of results that contains the data
            ResultSet rs = ps.executeQuery();

            //icNo[0] = rs.getString("icNo");
            // loop to read each data in the rs table
            while (rs.next()) {
                //customer = new Customer();

                // call setter to assign values to userTable attributes
                OrderCar.TxtOrderId.setText(rs.getString("ORDERID"));
                OrderCar.TxtEmail.setText(rs.getString("EMAIL"));
                OrderCar.TxtCarRegisterId.setText(rs.getString("REGISTERID"));
            }
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
        return order;
    }

    // save product data into database
    public void saveReturn(ReturnC returnC) {
        // call getter to assign Product attributes values to the variables
        String returnId = returnC.getReturnId();
        String returnDate = returnC.getReturnDate();
        String fine = returnC.getFine();
        String orderId = returnC.getOrderId();
        String registerId = returnC.getRegisterId();
        String email = returnC.getEmail();

        try {
            // call method to establish database connection
            connectToDatabase();

            // sql statement
            String SQL = "INSERT INTO returnTable VALUES (?, ?, ?, ?, ?, ?)";

            // declare object to execute parameterized query
            PreparedStatement ps = con.prepareStatement(SQL);

            // set the preparestatement parameters
            ps.setString(1, returnId);
            ps.setString(2, returnDate);
            ps.setString(3, fine);
            ps.setString(4, orderId);
            ps.setString(5, email);
            ps.setString(6, registerId);
            // call executeUpdate to execute out sql insert statement
            ps.executeUpdate();
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Successfully return!");
        }
    }

    // update return car status into database
    public void returnCarStatus(String updateID, Car car) {
        String status = ("Available");

        try {
            connectToDatabase();

            String SQL = "UPDATE carTable SET STATUS = ? WHERE REGISTERID = ?";

            PreparedStatement ps = con.prepareStatement(SQL);

            // set the preparestatement parameters
            ps.setString(1, status);
            ps.setString(2, updateID);

            // call executeupdate to execute the sql update statement
            ps.executeUpdate();

            // message to inform user
            JOptionPane.showMessageDialog(null, "Your order are return!");
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }

    // auto increment for car register id
    public void id_car() {
        try {
            connectToDatabase();

            String SQL = "SELECT * FROM CARTABLE ORDER BY registerId DESC";

            // declare object to execute parameterized query
            PreparedStatement ps = con.prepareStatement(SQL);

            // execute query and returns a set of results that contains the data
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String id = rs.getString("registerId").substring(1);
                int AN = Integer.parseInt(id);
                int panjang = id.length();
                for (int i = 0; i < 2 - panjang; i++) {
                    AN = AN;
                }
                ManageCar.TxtRegisterId.setText("C" + Integer.toString(AN + 1));
            } else {
                ManageCar.TxtRegisterId.setText("C1");
            }
            rs.close();
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }

    // auto increment for return id
    public void id_return() {
        try {
            connectToDatabase();

            String SQL = "SELECT * FROM RETURNTABLE ORDER BY returnId DESC";

            // declare object to execute parameterized query
            PreparedStatement ps = con.prepareStatement(SQL);

            // execute query and returns a set of results that contains the data
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String id = rs.getString("returnId").substring(1);
                int AN = Integer.parseInt(id);
                int panjang = id.length();
                for (int i = 0; i < 2 - panjang; i++) {
                    AN = AN;
                }
                ReturnCar.TxtReturnId.setText("R" + Integer.toString(AN + 1));
            } else {
                ReturnCar.TxtReturnId.setText("R1");
            }
            rs.close();
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }

    // get customer data by name
    public Order getOrderById(String orderId) {
        try {
            // call method to establish database connection
            connectToDatabase();

            // sql statement
            String SQL = "SELECT * FROM orderTable WHERE orderId = ?";

            // declare object to execute parameterized query
            PreparedStatement ps = con.prepareStatement(SQL);

            // set the preparestatement parameters
            ps.setString(1, orderId);

            // execute query and returns a set of results that contains the data
            ResultSet rs = ps.executeQuery();

            // loop to read each data in the rs table
            while (rs.next()) {
                order.setOrderId(rs.getString(1));
                order.setRegisterId(rs.getString(2));
                order.setEmail(rs.getString(3));
                order.setPeriod(rs.getString(4));
                order.setDate(rs.getString(5));
                order.setReturnDate(rs.getString(6));
                order.setTotal(rs.getString(7));
            }
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
        return order;
    }

    // read all customer data from database and return it to the calling function
    public ArrayList<Feedback> readAllFeedback() {
        feedbackList = new ArrayList<Feedback>();
        try {
            // call method to establish database connection
            connectToDatabase();

            // sql statement
            String SQL = "SELECT * FROM FEEDBACKTABLE";

            // declare object to execute parameterized query
            PreparedStatement ps = con.prepareStatement(SQL);

            // execute query and returns a set of results that contains the data
            ResultSet rs = ps.executeQuery();

            // loop to read each data in the rs table
            while (rs.next()) {
                feedback = new Feedback();

                // call setter to assign values to Item attributes
                feedback.setFeedbackId(rs.getString("FEEDBACKID"));
                feedback.setFirstTime(rs.getString("FIRSTTIME"));
                feedback.setProblem(rs.getString("PROBLEM"));
                feedback.setCar(rs.getString("CAR"));
                feedback.setRating(rs.getString("RATING"));
                feedback.setMessage(rs.getString("MESSAGE"));
                feedback.setSuggestion(rs.getString("SUGGESTION"));
                feedback.setEmail(rs.getString("EMAIL"));

                // Add each Item to the list of item
                feedbackList.add(feedback);
            }
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
        return feedbackList;
    }

    // save product data into database
    public void saveFeedback(Feedback feedback) {
        // call getter to assign Product attributes values to the variables
        String feedbackId = feedback.getFeedbackId();
        String firstTime = feedback.getFirstTime();
        String problem = feedback.getProblem();
        String car = feedback.getCar();
        String rating = feedback.getRating();
        String message = feedback.getMessage();
        String suggestion = feedback.getSuggestion();
        String email = feedback.getEmail();

        try {
            // call method to establish database connection
            connectToDatabase();

            // sql statement
            String SQL = "INSERT INTO feedbackTable VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

            // declare object to execute parameterized query
            PreparedStatement ps = con.prepareStatement(SQL);

            // set the preparestatement parameters
            ps.setString(1, feedbackId);
            ps.setString(2, firstTime);
            ps.setString(3, problem);
            ps.setString(4, car);
            ps.setString(5, rating);
            ps.setString(6, message);
            ps.setString(7, suggestion);
            ps.setString(8, email);
            // call executeUpdate to execute out sql insert statement
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Successfully submit your feedback.");
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }

    // read all customer data from database and return it to the calling function
    public void readReport2Date(String n, String d1, String d2) {
        try {
            // call method to establish database connection
            connectToDatabase();
            PreparedStatement ps;
            ResultSet rs;

            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            String date1 = df.format(Report.TxtFrom.getDate());
            String date2 = df.format(Report.TxtTo.getDate());
            String name = String.valueOf(Report.comboBoxCarName.getSelectedItem());

            if (n.equals("") && d1.equals("") && d2.equals("")) {
                // sql statement
                ps = con.prepareStatement("SELECT CARTABLE.NAME, ORDERTABLE.ORDERID, ORDERTABLE.DATE, ORDERTABLE.RETURNDATE, ORDERTABLE.TOTAL, "
                        + "ORDERTABLE.REGISTERID, RETURNTABLE.FINE FROM CARTABLE INNER JOIN ORDERTABLE ON CARTABLE.REGISTERID = "
                        + "ORDERTABLE.REGISTERID INNER JOIN RETURNTABLE ON ORDERTABLE.ORDERID = RETURNTABLE.ORDERID");
            } else {
                // sql statement
                ps = con.prepareStatement("SELECT CARTABLE.NAME, ORDERTABLE.ORDERID, ORDERTABLE.DATE, ORDERTABLE.RETURNDATE, ORDERTABLE.TOTAL, "
                        + "ORDERTABLE.REGISTERID, RETURNTABLE.FINE FROM CARTABLE INNER JOIN ORDERTABLE ON CARTABLE.REGISTERID = "
                        + "ORDERTABLE.REGISTERID INNER JOIN RETURNTABLE ON ORDERTABLE.ORDERID = RETURNTABLE.ORDERID WHERE ORDERTABLE.DATE >= '" + d1 + "' AND RETURNTABLE.DATERETURN <= '" + d2 + "' AND CARTABLE.NAME LIKE '%" + n + "%'");
            }
            // execute query and returns a set of results that contains the data
            rs = ps.executeQuery();

            DefaultTableModel tableContent = (DefaultTableModel) Report.sumTable.getModel();
            tableContent.setRowCount(0);

            String report[] = new String[6];
            // loop to read each data in the rs table
            while (rs.next()) {
                // call setter to assign values to Item attributes
                report[0] = rs.getString("NAME");
                report[1] = rs.getString("REGISTERID");
                report[2] = rs.getString("DATE");
                report[3] = rs.getString("RETURNDATE");
                report[4] = rs.getString("TOTAL");
                report[5] = rs.getString("FINE");

                // Add each Item to the list of item
                tableContent.addRow(report);
            }
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }
}
