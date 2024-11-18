/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utem.musicstore;

import java.sql.*;
import java.util.*;
import javax.swing.*;
import javax.swing.JOptionPane;
import javax.swing.table.*;
import java.io.*;
import java.text.*;
import java.awt.Color;
import java.time.LocalDate;
import java.util.Date;
import java.time.Month;
import javax.swing.UIManager;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.jdbc.JDBCCategoryDataset;
import org.jfree.data.jdbc.JDBCXYDataset;
/**
 *
 * @author User
 */
public class ConnectionData {
    // Declare the list of Customer to store the user object from database
    private ArrayList<User> userList;
    // Declare the list of Customer to store the user object from database
    private ArrayList<Items> itemsList;
    // Declare the list of Customer to store the user object from database
    private ArrayList<Category> categoryList;
    // Declare the list of Customer to store the user object from database
    private ArrayList<Order> orderList;
    // Declare the list of Customer to store the user object from database
    private ArrayList<Bill> billList;

    // Declare object for class Customer to set and get values of Item
    private User user = new User();
    // Declare object for class Customer to set and get values of Item
    private Items items = new Items();
    // Declare object for class Customer to set and get values of Item
    private Category category = new Category();
    // Declare object for class Customer to set and get values of Item
    private Order order = new Order();
    // Declare object for class Customer to set and get values of Item
    private Bill bill = new Bill();
    
    // Declare object to set up a connection to a database
    java.sql.Connection con;
    
    // default constructor
    public ConnectionData() {
    }

    // set up a connection to a database
    private void connectToDatabase() {
        try {
            String host = "jdbc:derby://localhost:1527/MusicStore";
            con = DriverManager.getConnection(host);
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }
    
    // auto increment for item id
    public void ID_item() {
        try {
            connectToDatabase();

            String SQL = "SELECT * FROM ITEMTABLE ORDER BY itemID DESC";

            // declare object to execute parameterized query
            PreparedStatement ps = con.prepareStatement(SQL);

            // execute query and returns a set of results that contains the data
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                String id = rs.getString("itemID").substring(1);
                String AN = "" + (Integer.parseInt(id) + 1);
                String No1 = "";
                
                if (AN.length() == 1) {
                    No1 = "00";
                }
                else if (AN.length() == 2) {
                    No1 = "0";
                }
                else if (AN.length() == 3) {
                    No1 = "";
                }
                ItemsForm.txtID.setText("A" + No1 + AN);
            } else {
                ItemsForm.txtID.setText("A001");
            }
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }
    
    // auto increment for item id
    public void ID_category() {
        try {
            connectToDatabase();

            String SQL = "SELECT * FROM CATEGORYTABLE ORDER BY categoryID DESC";

            // declare object to execute parameterized query
            PreparedStatement ps = con.prepareStatement(SQL);

            // execute query and returns a set of results that contains the data
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String id = rs.getString("categoryID").substring(1);
                int AN = Integer.parseInt(id);
                int panjang = id.length();
                for (int i = 0; i < 2 - panjang; i++) {
                    AN = AN;
                }
                CategoryForm.txtID.setText("C" + Integer.toString(AN + 1));
            } else {
                CategoryForm.txtID.setText("C1");
            }
            rs.close();
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }
    
    // auto increment for order id
    public void ID_order() {
        try {
            connectToDatabase();

            String SQL = "SELECT * FROM ORDERTABLE ORDER BY orderID DESC";

            // declare object to execute parameterized query
            PreparedStatement ps = con.prepareStatement(SQL);

            // execute query and returns a set of results that contains the data
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String id = rs.getString("orderID").substring(1);
                String AN = "" + (Integer.parseInt(id) + 1);
                String No1 = "";
                
                if (AN.length() == 1) {
                    No1 = "00";
                }
                else if (AN.length() == 2) {
                    No1 = "0";
                }
                else if (AN.length() == 3) {
                    No1 = "";
                }
                OrderForm.txtOrderID.setText("O" + No1 + AN);
            } else {
                OrderForm.txtOrderID.setText("O001");
            }
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }
    
    // read all customer data from database and return it to the calling function
    public ArrayList<User> readAllUser() {
        userList = new ArrayList<User>();
        try {
            // call method to establish database connection
            connectToDatabase();
            
            // sql statement
            String SQL = "SELECT * FROM userTable";

            // declare object to execute parameterized query
            PreparedStatement ps = con.prepareStatement(SQL);

            // execute query and returns a set of results that contains the data
            ResultSet rs = ps.executeQuery();

            // loop to read each data in the rs table
            while (rs.next()) {
                user = new User();

                // call setter to assign values to Item attributes
                user.setName(rs.getString("NAME"));
                user.setEmail(rs.getString("EMAIL"));
                user.setPassword(rs.getString("PASSWORD"));
                user.setType(rs.getString("TYPE"));

                // Add each Item to the list of item
                userList.add(user);
            }
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
        return userList;
    }
    
    // read all customer data from database and return it to the calling function
    public ArrayList<User> readAllSeller() {
        userList = new ArrayList<User>();
        try {
            // call method to establish database connection
            connectToDatabase();
            
            // sql statement
            String SQL = "SELECT * FROM userTable WHERE TYPE = 'Seller'";

            // declare object to execute parameterized query
            PreparedStatement ps = con.prepareStatement(SQL);

            // execute query and returns a set of results that contains the data
            ResultSet rs = ps.executeQuery();

            // loop to read each data in the rs table
            while (rs.next()) {
                user = new User();

                // call setter to assign values to Item attributes
                user.setName(rs.getString("NAME"));
                user.setEmail(rs.getString("EMAIL"));
                user.setPassword(rs.getString("PASSWORD"));
                user.setType(rs.getString("TYPE"));

                // Add each Item to the list of item
                userList.add(user);
            }
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
        return userList;
    }

    // save customer data into database
    public void saveUser(User user) {
        // call getter to assign customer attributes values to the variables
        String name = user.getName();
        String email = user.getEmail();
        String password = user.getPassword();
        String type = user.getType();

        try {
            // call method to establish database connection
            connectToDatabase();

            // sql statement
            String SQL = "INSERT INTO userTable VALUES (?, ?, ?, ?)";

            // declare object to execute parameterized query
            PreparedStatement ps = con.prepareStatement(SQL);

            // set the preparestatement parameters
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, password);
            ps.setString(4, type);

            // call executeUpdate to execute out sql insert statement
            ps.executeUpdate();
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }
    
    // save customer data into database
    public void saveSeller(User user) {
        // call getter to assign customer attributes values to the variables
        String name = user.getName();
        String email = user.getEmail();
        String password = user.getPassword();
        String type = user.getType();

        try {
            // call method to establish database connection
            connectToDatabase();

            // sql statement
            String SQL = "INSERT INTO userTable VALUES (?, ?, ?, ?)";

            // declare object to execute parameterized query
            PreparedStatement ps = con.prepareStatement(SQL);

            // set the preparestatement parameters
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, password);
            ps.setString(4, type);

            // call executeUpdate to execute out sql insert statement
            ps.executeUpdate();
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }
    
    // update user data into database
    public void updateSeller(String updateEmail, User user) {
        String name = user.getName();
        String password = user.getPassword();
        String type = ("Seller");

        try {
            connectToDatabase();

            String SQL = "UPDATE userTable SET NAME = ?, PASSWORD = ?, TYPE = ? WHERE EMAIL = ?";

            PreparedStatement ps = con.prepareStatement(SQL);

            // set the preparestatement parameters
            ps.setString(1, name);
            ps.setString(2, password);
            ps.setString(3, type);
            ps.setString(4, updateEmail);

            // call executeupdate to execute the sql update statement
            ps.executeUpdate();
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }
    
    // update user data into database
    public void updateSellerType(String updateEmail, User user) {
        String type = ("Seller");

        try {
            connectToDatabase();

            String SQL = "UPDATE userTable SET TYPE = ? WHERE EMAIL = ?";

            PreparedStatement ps = con.prepareStatement(SQL);

            // set the preparestatement parameters
            ps.setString(1, type);
            ps.setString(2, updateEmail);

            // call executeupdate to execute the sql update statement
            ps.executeUpdate();
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }
    
    // delete product data into database
    public void deleteSeller(String email) {
        try {
            // call method to establish database connection
            connectToDatabase();

            // sql statement
            String SQL = "DELETE FROM userTable WHERE email = ?";

            // declare object to execute parameterized query
            PreparedStatement ps = con.prepareStatement(SQL);

            // set the preparestatement parameters
            ps.setString(1, email);

            // call executeUpdate to execute the sql delete statement
            ps.executeUpdate();
            
            //display message
            JOptionPane.showMessageDialog(null, "The user has been deleted!");
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "");
        }
    }
    
    // get data from database and return it to the calling function
    public User showUser(String email) {
        User user = null;
        try {
            // call method to establish database connection
            connectToDatabase();

            // sql statement
            String SQL = "SELECT * FROM userTable WHERE Email = ?";

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
                Dashboard.txtName.setText(rs.getString("NAME"));                                                                                                                                                                                                                                                                                                                                                                                                                                                                           
                Dashboard.txtEmail.setText(rs.getString("EMAIL"));
                OrderForm.txtName.setText(rs.getString("NAME"));  
                OrderForm.txtEmail.setText(rs.getString("EMAIL"));
            }
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
        return user;
    }
    
    // get data from database and return it to the calling function
    public User loginUser(String email, String password) {
        User user = null;
        try {
            // call method to establish database connection
            connectToDatabase();

            // sql statement
            String SQL = "SELECT * FROM userTable WHERE Email = ? AND password = ?";

            // declare object to execute parameterized query
            PreparedStatement ps = con.prepareStatement(SQL);

            // set the preparestatement parameters
            ps.setString(1, email);
            ps.setString(2, password);

            // execute query and returns a set of results that contains the data
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                user = new User();

                // call setter to assign values to userTable attributes
                user.setName(rs.getString("NAME"));
                user.setEmail(rs.getString("EMAIL"));
                user.setType(rs.getString("TYPE"));
                if (rs.getString("TYPE").equals("Admin"))
                {
                    //new Login().setVisible(false);
                    new Dashboard(email).setVisible(true);
                }
                else if (rs.getString("TYPE").equals("Seller"))
                {
                    //new Login().setVisible(false);
                    new OrderForm(email).setVisible(true);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Incorrect Email or Password", "Message", JOptionPane.ERROR_MESSAGE);
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Incorrect Email or Password", "Message", JOptionPane.ERROR_MESSAGE);
                Login.txtEmail.setText("Email");
                Login.txtPassword.setText("Password");
                Login.labelError.setText("");
            }
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
        return user;
    }
    
    // read all customer data from database and return it to the calling function
    public void readAllItems() {
        try {
            // call method to establish database connection
            connectToDatabase();
            PreparedStatement ps;
            ResultSet rs;

            // sql statement
            ps = con.prepareStatement("SELECT CATEGORYTABLE.NAME, ITEMTABLE.ITEMID, ITEMTABLE.TITLE, ITEMTABLE.PRICE, ITEMTABLE.QUANTITY, "
                    + "ITEMTABLE.CATEGORYID FROM CATEGORYTABLE INNER JOIN ITEMTABLE ON CATEGORYTABLE.CATEGORYID = ITEMTABLE.CATEGORYID");

            // execute query and returns a set of results that contains the data
            rs = ps.executeQuery();

            DefaultTableModel tableContent = (DefaultTableModel) ItemsForm.tableItem.getModel();

            String items[] = new String[5];
            // loop to read each data in the rs table
            while (rs.next()) {
                // call setter to assign values to Item attributes
                items[0] = rs.getString("ITEMID");
                items[1] = rs.getString("TITLE");
                items[2] = rs.getString("PRICE");
                items[3] = rs.getString("QUANTITY");
                items[4] = rs.getString("NAME");

                // Add each Item to the list of item
                tableContent.addRow(items);
            }
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }
    
    // read all customer data from database and return it to the calling function
    public ArrayList<Items> readAllItems2() {
        itemsList = new ArrayList<Items>();
        try {
            // call method to establish database connection
            connectToDatabase();

            // sql statement
            String SQL = "SELECT * FROM itemTable";

            // declare object to execute parameterized query
            PreparedStatement ps = con.prepareStatement(SQL);

            // execute query and returns a set of results that contains the data
            ResultSet rs = ps.executeQuery();

            // loop to read each data in the rs table
            while (rs.next()) {
                items = new Items();

                // call setter to assign values to Item attributes
                items.setItemID(rs.getString("ITEMID"));
                items.setTitle(rs.getString("TITLE"));
                items.setPrice(rs.getString("PRICE"));
                items.setQuantity(rs.getString("QUANTITY"));
                items.setCategoryID(rs.getString("CATEGORYID"));

                // Add each Item to the list of item
                itemsList.add(items);
            }
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
        return itemsList;
    }
    
    // save customer data into database
    public void addItems(Items items) {
        // call getter to assign customer attributes values to the variables
        String itemID = items.getItemID();
        String title = items.getTitle();
        String price = items.getPrice();
        String quantity = items.getQuantity();
        String categoryID = items.getCategoryID();

        try {
            // call method to establish database connection
            connectToDatabase();

            // sql statement
            String SQL = "INSERT INTO itemTable VALUES (?, ?, ?, ?, ?)";

            // declare object to execute parameterized query
            PreparedStatement ps = con.prepareStatement(SQL);

            // set the preparestatement parameters
            ps.setString(1, itemID);
            ps.setString(2, title);
            ps.setString(3, price);
            ps.setString(4, quantity);
            ps.setString(5, categoryID);

            // call executeUpdate to execute out sql insert statement
            ps.executeUpdate();
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }
    
    // update product data into database
    public void updateItems(String updateID, Items items) {
        String title = items.getTitle();
        String price = items.getPrice();
        String quantity = items.getQuantity();
        String categoryID = items.getCategoryID();

        try {
            connectToDatabase();

            String SQL = "UPDATE itemTable SET TITLE = ?, PRICE = ?, QUANTITY = ?, CATEGORYID = ? WHERE ITEMID = ?";

            PreparedStatement ps = con.prepareStatement(SQL);

            // set the preparestatement parameters
            ps.setString(1, title);
            ps.setString(2, price);
            ps.setString(3, quantity);
            ps.setString(4, categoryID);
            ps.setString(5, updateID);

            // call executeupdate to execute the sql update statement
            ps.executeUpdate();
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }
    
    // delete product data into database
    public void deleteItems(String itemID) {
        try {
            // call method to establish database connection
            connectToDatabase();

            // sql statement
            String SQL = "DELETE FROM itemTable WHERE itemID = ?";

            // declare object to execute parameterized query
            PreparedStatement ps = con.prepareStatement(SQL);

            // set the preparestatement parameters
            ps.setString(1, itemID);

            // call executeUpdate to execute the sql delete statement
            ps.executeUpdate();
            
            //display message
            JOptionPane.showMessageDialog(null, "The item has been deleted!");
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "");
        }
    }
    
    // get category data by name
    public Category getCategoryByName(String categoryName) {
        try {
            // call method to establish database connection
            connectToDatabase();

            // sql statement
            String SQL = "SELECT * FROM categoryTable WHERE name = ?";

            // declare object to execute parameterized query
            PreparedStatement ps = con.prepareStatement(SQL);

            // set the preparestatement parameters
            ps.setString(1, categoryName);

            // execute query and returns a set of results that contains the data
            ResultSet rs = ps.executeQuery();

            // loop to read each data in the rs table
            while (rs.next()) {
                category.setCategoryID(rs.getString(1));
            }
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
        return category;
    }
    
    // get product data by name
    public Items getItemsByTitle(String title){        
        try{
            // call method to establish database connection
            connectToDatabase();
            
            // sql statement
            String SQL = "SELECT * FROM itemTable WHERE title = ?";
            
            // declare object to execute parameterized query
            PreparedStatement ps = con.prepareStatement(SQL);
            
            // set the preparestatement parameters
            ps.setString(1, title);
            
            // execute query and returns a set of results that contains the data
            ResultSet rs = ps.executeQuery();
            
            // loop to read each data in the rs table
            while(rs.next()){
                items.setItemID(rs.getString(1));
                items.setTitle(rs.getString(2));
                items.setPrice(rs.getString(3));
                items.setCategoryID(rs.getString(5));
            }
        }
        catch ( SQLException err ){
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
        return items;
    }
    
    // read all items data by category name from database and return it to the calling function
    public ArrayList<Items> readAllItemsByCategory(String categoryID){
        itemsList = new ArrayList<Items>();
        try{
            // call method to establish database connection
            connectToDatabase();
            
            // sql statement
            String SQL = "SELECT * FROM ITEMTABLE WHERE categoryID = ?";
            
            // declare object to execute parameterized query
            PreparedStatement ps = con.prepareStatement(SQL);
            
            // set the preparestatement parameters
            ps.setString(1, categoryID);
            
            // execute query and returns a set of results that contains the data
            ResultSet rs = ps.executeQuery();
            
            // loop to read each data in the rs table
            while(rs.next()){
                items = new Items();
                
                // call setter to assign values to Item attributes
                items.setTitle(rs.getString("TITLE"));
                items.setQuantity(rs.getString("QUANTITY"));

                
                // Add each Item to the list of item
                itemsList.add(items);
            }
        }
        catch ( SQLException err ){
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
        return itemsList;
    }
    
    // read all customer data from database and return it to the calling function
    public ArrayList<Category> readAllCategory() {
        categoryList = new ArrayList<Category>();
        try {
            // call method to establish database connection
            connectToDatabase();

            // sql statement
            String SQL = "SELECT * FROM categoryTable";

            // declare object to execute parameterized query
            PreparedStatement ps = con.prepareStatement(SQL);

            // execute query and returns a set of results that contains the data
            ResultSet rs = ps.executeQuery();

            // loop to read each data in the rs table
            while (rs.next()) {
                category = new Category();

                // call setter to assign values to Item attributes
                category.setCategoryID(rs.getString("CATEGORYID"));
                category.setName(rs.getString("NAME"));

                // Add each Item to the list of item
                categoryList.add(category);
            }
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
        return categoryList;
    }
    
    // save customer data into database
    public void addCategory(Category category) {
        // call getter to assign customer attributes values to the variables
        String categoryID = category.getCategoryID();
        String name = category.getName();

        try {
            // call method to establish database connection
            connectToDatabase();

            // sql statement
            String SQL = "INSERT INTO categoryTable VALUES (?, ?)";

            // declare object to execute parameterized query
            PreparedStatement ps = con.prepareStatement(SQL);

            // set the preparestatement parameters
            ps.setString(1, categoryID);
            ps.setString(2, name);

            // call executeUpdate to execute out sql insert statement
            ps.executeUpdate();
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }
    
    // update product data into database
    public void updateCategory(String updateID, Category category) {
        String name = category.getName();

        try {
            connectToDatabase();

            String SQL = "UPDATE categoryTable SET NAME = ? WHERE CATEGORYID = ?";

            PreparedStatement ps = con.prepareStatement(SQL);

            // set the preparestatement parameters
            ps.setString(1, name);
            ps.setString(2, updateID);

            // call executeupdate to execute the sql update statement
            ps.executeUpdate();
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }
    
    // delete product data into database
    public void deleteCategory(String categoryID) {
        try {
            // call method to establish database connection
            connectToDatabase();

            // sql statement
            String SQL = "DELETE FROM categoryTable WHERE categoryID = ?";

            // declare object to execute parameterized query
            PreparedStatement ps = con.prepareStatement(SQL);

            // set the preparestatement parameters
            ps.setString(1, categoryID);

            // call executeUpdate to execute the sql delete statement
            ps.executeUpdate();
            
            //display message
            JOptionPane.showMessageDialog(null, "The category has been deleted");
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Cannot Delete. There is still have items in this category!");
        }
    }
    
    // save order data into database
    public void saveItem_Order() {
        // call getter to assign Product attributes values to the variables
        String orderID;
        String itemID;
        String categoryID;
        String quantity;
        String price;
        String subTotal;
        String date;

        try {
            // call method to establish database connection
            connectToDatabase();

            String SQL = "INSERT INTO ITEM_ORDERTABLE VALUES (?, ?, ?, ?, ?, ?, ?)";

            // declare object to execute parameterized query
            PreparedStatement ps = con.prepareStatement(SQL);
            
            DefaultTableModel dtm = (DefaultTableModel) OrderForm.orderTable.getModel();
            
            for (int i = 0; i < dtm.getRowCount(); i++) 
            {
                orderID = OrderForm.txtOrderID.getText().trim();
                itemID = dtm.getValueAt(i, 0).toString();
                categoryID = dtm.getValueAt(i, 1).toString();
                quantity = dtm.getValueAt(i, 4).toString();
                price = dtm.getValueAt(i, 3).toString();
                subTotal = dtm.getValueAt(i, 5).toString();
                date = OrderForm.txtDate.getText().trim();
                // set the preparestatement parameters
                ps.setString(1, orderID);
                ps.setString(2, itemID);
                ps.setString(3, categoryID);
                ps.setString(4, quantity);
                ps.setString(5, price);
                ps.setString(6, subTotal);
                ps.setString(7, date);
                // call executeUpdate to execute out sql insert statement
                ps.executeUpdate();
            }
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }
    
    // save bill data into database
    public void saveOrder(Bill bill) {
        // call getter to assign Product attributes values to the variables
        String orderID = bill.getOrderID();
        String email = bill.getEmail();
        String quantity = bill.getQuantity();
        String total = bill.getTotal();
        String cash = bill.getCash();
        String change = bill.getChange();
        String date = bill.getDate();
        String time = bill.getTime();

        try {
            // call method to establish database connection
            connectToDatabase();

            String SQL = "INSERT INTO ORDERTABLE VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

            // declare object to execute parameterized query
            PreparedStatement ps = con.prepareStatement(SQL);
            
            // set the preparestatement parameters
            ps.setString(1, orderID);
            ps.setString(2, email);
            ps.setString(3, quantity);
            ps.setString(4, total);
            ps.setString(5, cash);
            ps.setString(6, change);
            ps.setString(7, date);
            ps.setString(8, time);
            // call executeUpdate to execute out sql insert statement
            ps.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "The Order Was Successful!");
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }
    
    // read all customer data from database and return it to the calling function
    public void readAllOrder() {
        try {
            // call method to establish database connection
            connectToDatabase();

            // sql statement
            String SQL = "SELECT * FROM orderTable";

            // declare object to execute parameterized query
            PreparedStatement ps = con.prepareStatement(SQL);

            // execute query and returns a set of results that contains the data
            ResultSet rs = ps.executeQuery();

            DefaultTableModel tableContent = (DefaultTableModel) BillForm.orderTable.getModel();

            String order[] = new String[8];
            // loop to read each data in the rs table
            while (rs.next()) {
                // call setter to assign values to Item attributes
                order[0] = rs.getString("ORDERID");
                order[1] = rs.getString("EMAIL");
                order[2] = rs.getString("QUANTITY");
                order[3] = rs.getString("TOTAL");
                order[4] = rs.getString("CASH");
                order[5] = rs.getString("CHANGE");
                order[6] = rs.getString("DATE");
                order[7] = rs.getString("TIME");

                // Add each Item to the list of item
                tableContent.addRow(order);
            }
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }
    
    // read all customer data from database and return it to the calling function
    public void readAllOrderSeller() {
        try {
            // call method to establish database connection
            connectToDatabase();

            // sql statement
            String SQL = "SELECT * FROM orderTable";

            // declare object to execute parameterized query
            PreparedStatement ps = con.prepareStatement(SQL);

            // execute query and returns a set of results that contains the data
            ResultSet rs = ps.executeQuery();

            DefaultTableModel tableContent = (DefaultTableModel) OrderForm.billTable.getModel();

            String order[] = new String[4];
            // loop to read each data in the rs table
            while (rs.next()) {
                // call setter to assign values to Item attributes
                order[0] = rs.getString("ORDERID");
                order[1] = rs.getString("EMAIL");
                order[2] = rs.getString("QUANTITY");
                order[3] = rs.getString("TOTAL");

                // Add each Item to the list of item
                tableContent.addRow(order);
            }
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }
    
    // add item to cart quantity data into database
    public void addToCartItems() {
        try {
            // call method to establish database connection
            connectToDatabase();
            
            String pcode = OrderForm.txtID.getText();
            // sql statement
            String SQL = "SELECT * FROM itemTable where itemID = ?";

            // declare object to execute parameterized query
            PreparedStatement ps = con.prepareStatement(SQL);
            
            ps.setString(1, pcode);

            // execute query and returns a set of results that contains the data
            ResultSet rs = ps.executeQuery();

            // loop to read each data in the rs table
            while (rs.next()) {
                String itemID = OrderForm.txtID.getText();
                String categoryID = OrderForm.txtCategoryID.getText();
                String title = OrderForm.txtTitle.getText();
                String price = OrderForm.txtPrice.getText();
                String quantity = String.valueOf(OrderForm.txtQuantity.getValue());
                int index = OrderForm.itemTable.getSelectedRow();
                TableModel model = OrderForm.itemTable.getModel();
                int itemsQuantity = Integer.parseInt(model.getValueAt(index, 1).toString());
                int orderQuantity = Integer.parseInt(OrderForm.txtQuantity.getValue().toString());
                
                if (orderQuantity > itemsQuantity) {
                    JOptionPane.showMessageDialog(null, "Not enough quantity for this items!");
                } else {
                    DefaultTableModel dtm = (DefaultTableModel) OrderForm.orderTable.getModel();
                    int row = dtm.getRowCount();
                    int flag = 0;
                    
                    if (row == 0) {
                        //DefaultTableModel dtm = (DefaultTableModel) OrderForm.orderTable.getModel();
                        dtm.addRow(new Object[]{itemID, categoryID, title, price, quantity, OrderForm.itemsTotal});
                        OrderForm.grandTotal = OrderForm.grandTotal + OrderForm.itemsTotal;
                        OrderForm.txtTotal.setText("RM " + String.valueOf(OrderForm.grandTotal).format("%.2f", OrderForm.grandTotal));

                        OrderForm.quantityOrder = 0;
                        for (int j = 0; j < dtm.getRowCount(); j++) {
                            String amount = dtm.getValueAt(j, 4).toString();
                            OrderForm.quantityOrder += Integer.parseInt(amount);
                        }
                        OrderForm.txtQuantityOrder.setText(String.valueOf(OrderForm.quantityOrder));
                    }
                    for (int i = 0; i < row; i++) {
                        String valueIdTabel = dtm.getValueAt(i, 0).toString();
                        if (itemID.equals(valueIdTabel)) {
                            JOptionPane.showMessageDialog(null, "Already added this item into cart!");
                            flag = 0;
                            break;
                        }
                        else
                        {
                            flag = 1;
                        }
                    }
                    if (flag == 1) 
                    {
                        //DefaultTableModel dtm = (DefaultTableModel) OrderForm.orderTable.getModel();
                        dtm.addRow(new Object[]{itemID, categoryID, title, price, quantity, OrderForm.itemsTotal});
                        OrderForm.grandTotal = OrderForm.grandTotal + OrderForm.itemsTotal;
                        OrderForm.txtTotal.setText("RM " + String.valueOf(OrderForm.grandTotal).format("%.2f", OrderForm.grandTotal));

                        OrderForm.quantityOrder = 0;
                        for (int k = 0; k < dtm.getRowCount(); k++) {
                            String amount = dtm.getValueAt(k, 4).toString();
                            OrderForm.quantityOrder += Integer.parseInt(amount);
                        }
                        OrderForm.txtQuantityOrder.setText(String.valueOf(OrderForm.quantityOrder));
                    }
                }
            }
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Cannot Delete. There is still have items in this category!");
        }
    }
    
    // update item stock quantity data into database
    public void updateStock() {
        DefaultTableModel dtm = (DefaultTableModel) OrderForm.orderTable.getModel();
        
        for (int i = 0; i < dtm.getRowCount(); i++) {
            String itemsID = dtm.getValueAt(i, 0).toString();
            String quantity = dtm.getValueAt(i, 4).toString();

            try {
                connectToDatabase();

                String SQL = "SELECT QUANTITY FROM ITEMTABLE WHERE ITEMID = '" + itemsID + "'";

                // declare object to execute parameterized query
                PreparedStatement ps = con.prepareStatement(SQL);

                // execute query and returns a set of results that contains the data
                ResultSet rs = ps.executeQuery();

                // loop to read each data in the rs table
                if (rs.next()) {
                    // call setter to assign values to Item attributes
                    OrderForm.stockQuantity = Integer.parseInt(rs.getString("QUANTITY"));
                }
            } catch (SQLException err) {
                JOptionPane.showMessageDialog(null, err.getMessage());
            }
            
            int stock_quantity = OrderForm.stockQuantity;
            int sell_quantity = Integer.parseInt(quantity);
            int new_quantity = stock_quantity - sell_quantity;
            String newQuantity = String.valueOf(new_quantity);
            
            try {
                connectToDatabase();

                String SQL2 = "UPDATE ITEMTABLE SET QUANTITY = '"+ newQuantity +"' WHERE ITEMID = '" + itemsID + "'";

                // declare object to execute parameterized query
                PreparedStatement ps2 = con.prepareStatement(SQL2);
                
                // call executeUpdate to execute out sql insert statement
                ps2.executeUpdate();
            } catch (SQLException err) {
                JOptionPane.showMessageDialog(null, err.getMessage());
            }
        }
    }
    
    public void countAllItems() {
        try {
            // call method to establish database connection
            connectToDatabase();
            PreparedStatement ps;
            ResultSet rs;

            // sql statement
            ps = con.prepareStatement("SELECT COUNT(*) AS itemsCount FROM ITEMTABLE");

            // execute query and returns a set of results that contains the data
            rs = ps.executeQuery();

            // loop to read each data in the rs table
            while (rs.next()) {
                int count = rs.getInt("itemsCount");
                Dashboard.txtItems.setText(String.valueOf(count));
            }
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }
    
    public void countAllQuantity() {
        try {
            // call method to establish database connection
            connectToDatabase();
            PreparedStatement ps;
            ResultSet rs;

            // sql statement
            ps = con.prepareStatement("SELECT SUM(CAST(Quantity AS DECIMAL(10,2))) AS quantitySum FROM ITEMTABLE");

            // execute query and returns a set of results that contains the data
            rs = ps.executeQuery();

            // loop to read each data in the rs table
            while (rs.next()) {
                int sum = rs.getInt("quantitySum");
                Dashboard.txtQuantity.setText(String.valueOf(sum));
            }
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }
    
    public void countAllCategory() {
        try {
            // call method to establish database connection
            connectToDatabase();
            PreparedStatement ps;
            ResultSet rs;

            // sql statement
            ps = con.prepareStatement("SELECT COUNT(*) AS categoryCount FROM CATEGORYTABLE");

            // execute query and returns a set of results that contains the data
            rs = ps.executeQuery();

            // loop to read each data in the rs table
            while (rs.next()) {
                int count = rs.getInt("categoryCount");
                Dashboard.txtCategory.setText(String.valueOf(count));
            }
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }
    
    public void countAllSeller() {
        try {
            // call method to establish database connection
            connectToDatabase();
            PreparedStatement ps;
            ResultSet rs;

            // sql statement
            ps = con.prepareStatement("SELECT COUNT(*) AS sellerCount FROM userTable WHERE TYPE = 'Seller'");

            // execute query and returns a set of results that contains the data
            rs = ps.executeQuery();

            // loop to read each data in the rs table
            while (rs.next()) {
                int count = rs.getInt("sellerCount");
                Dashboard.txtSellers.setText(String.valueOf(count));
            }
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }
    
    public void countAllSales() {
        try {
            // call method to establish database connection
            connectToDatabase();
            PreparedStatement ps;
            ResultSet rs;

            // sql statement
            ps = con.prepareStatement("SELECT SUM(CAST(SUBTOTAL AS DECIMAL(10,2))) AS subTotalSum FROM ITEM_ORDERTABLE");

            // execute query and returns a set of results that contains the data
            rs = ps.executeQuery();

            // loop to read each data in the rs table
            while (rs.next()) {
                int sum = rs.getInt("subTotalSum");
                Dashboard.txtTotal.setText("RM " + String.valueOf(sum));
            }
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
            String date1 = df.format(ReportForm.txtFrom.getDate());
            String date2 = df.format(ReportForm.txtTo.getDate());
            String name = String.valueOf(ReportForm.comboBoxTitle.getSelectedItem());

            if (n.equals("") && !d1.equals("") && !d2.equals("")) {
                // sql statement
                ps = con.prepareStatement("SELECT ITEMTABLE.TITLE, ITEM_ORDERTABLE.ORDERID, ITEM_ORDERTABLE.DATE, ITEM_ORDERTABLE.QUANTITY, ITEM_ORDERTABLE.PRICE, "
                        + "ITEM_ORDERTABLE.SUBTOTAL, ITEM_ORDERTABLE.ITEMID, CATEGORYTABLE.NAME FROM ITEMTABLE INNER JOIN ITEM_ORDERTABLE ON ITEMTABLE.ITEMID = "
                        + "ITEM_ORDERTABLE.ITEMID INNER JOIN CATEGORYTABLE ON ITEM_ORDERTABLE.CATEGORYID = CATEGORYTABLE.CATEGORYID WHERE ITEM_ORDERTABLE.DATE BETWEEN ? AND ?");
                ps.setString(1, d1);
                ps.setString(2, d2);
            } else {
                // sql statement
                ps = con.prepareStatement("SELECT ITEMTABLE.TITLE, ITEM_ORDERTABLE.ORDERID, ITEM_ORDERTABLE.DATE, ITEM_ORDERTABLE.QUANTITY, ITEM_ORDERTABLE.PRICE, "
                        + "ITEM_ORDERTABLE.SUBTOTAL, ITEM_ORDERTABLE.ITEMID, CATEGORYTABLE.NAME FROM ITEMTABLE INNER JOIN ITEM_ORDERTABLE ON ITEMTABLE.ITEMID = "
                        + "ITEM_ORDERTABLE.ITEMID INNER JOIN CATEGORYTABLE ON ITEM_ORDERTABLE.CATEGORYID = CATEGORYTABLE.CATEGORYID WHERE ITEM_ORDERTABLE.DATE BETWEEN ? AND ? AND ITEMTABLE.TITLE LIKE '%" + n + "%'");
                ps.setString(1, d1);
                ps.setString(2, d2);
            }
            // execute query and returns a set of results that contains the data
            rs = ps.executeQuery();

            DefaultTableModel tableContent = (DefaultTableModel) ReportForm.reportTable.getModel();
            tableContent.setRowCount(0);

            String report[] = new String[7];
            // loop to read each data in the rs table
            while (rs.next()) {
                // call setter to assign values to Item attributes
                report[0] = rs.getString("ORDERID");
                report[1] = rs.getString("TITLE");
                report[2] = rs.getString("NAME");
                report[3] = rs.getString("QUANTITY");
                report[4] = rs.getString("PRICE");
                report[5] = rs.getString("SUBTOTAL");
                report[6] = rs.getString("DATE");

                // Add each Item to the list of item
                tableContent.addRow(report);
            }
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }
    
    // read all customer data from database and return it to the calling function
    public void showChart() {
        try {
            // call method to establish database connection
            connectToDatabase();
            PreparedStatement ps;
            ResultSet rs;

            // sql statement
            String sql = "SELECT DATE, TOTAL FROM ORDERTABLE";
            //ps = con.prepareStatement("SELECT DATE, TOTAL FROM ORDERTABLE");

            // execute query and returns a set of results that contains the data
            //rs = ps.executeQuery();
            
            // loop to read each data in the rs table
            //while (rs.next()) {
                //String total1 = rs.getString("TOTAL");
                //int total2 = Integer.parseInt(total1);
                //String date1 = rs.getString("DATE");
                //int date2 = Integer.parseInt(date1);
                
                CategoryDataset barchartdata = new JDBCCategoryDataset(con, sql);
                //barchartdata.setValue(total2, "", "");
                //barchartdata.setValue(date2, "january", "february");
                //JDBCCategoryDataset dataset = new JDBCCategoryDataset(con, query);
                JFreeChart chart = ChartFactory.createLineChart("Monthly Sales", "Date", "Total", barchartdata, PlotOrientation.VERTICAL, false, false, true);
                BarRenderer renderer = null;
                CategoryPlot plot = null;
                ChartFrame frame = new ChartFrame("Monthly Sales", chart, true);
                frame.setVisible(true);
                frame.setSize(400, 650);
                //ChartPanel chartPanel = new ChartPanel(chart); 
                //jPanel8.removeAll();
                //Dashboard.add(chartPanel);
                // jPanel8.updateUI();
                //Dashboard.jPanel8.validate();
            //}
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }
    
    public void showData() {
        try {
            // call method to establish database connection
            connectToDatabase();
            PreparedStatement ps;
            ResultSet rs;

            // sql statement
            ps = con.prepareStatement("SELECT ITEMTABLE.TITLE, SUM(CAST(ITEM_ORDERTABLE.SUBTOTAL AS DECIMAL(10,2))) AS ALLSUM FROM ITEMTABLE INNER JOIN ITEM_ORDERTABLE ON ITEMTABLE.ITEMID = ITEM_ORDERTABLE.ITEMID INNER JOIN ORDERTABLE ON ITEM_ORDERTABLE.ORDERID = ORDERTABLE.ORDERID GROUP BY ITEMTABLE.TITLE ORDER BY ALLSUM DESC FETCH FIRST 3 ROWS ONLY");
            //ps = con.prepareStatement("SELECT ITEMID, SUM(CAST(SUBTOTAL AS DECIMAL(10,2))) AS ALLSUM FROM ORDERTABLE JOIN ITEM_ORDERTABLE USING (ORDERID) JOIN ITEMTABLE USING (ITEMID) GROUP BY ITEMID");
            //ps = con.prepareStatement("SELECT ITEMTABLE.TITLE, ITEM_ORDERTABLE.ORDERID, "
                        //+ "SUM(CAST(ITEM_ORDERTABLE.PRICE AS DECIMAL(10,2))) AS ALLSUM, ITEM_ORDERTABLE.ITEMID, CATEGORYTABLE.NAME FROM ITEMTABLE INNER JOIN ITEM_ORDERTABLE ON ITEMTABLE.ITEMID = "
                        //+ "ITEM_ORDERTABLE.ITEMID INNER JOIN CATEGORYTABLE ON ITEM_ORDERTABLE.CATEGORYID = CATEGORYTABLE.CATEGORYID GROUP BY ITEM_ORDERTABLE.ITEMID");
            // execute query and returns a set of results that contains the data
            rs = ps.executeQuery();
            int index = 0;
            // loop to read each data in the rs table
            while (rs.next()) {
                String title = rs.getString("TITLE");
                String value = rs.getString("ALLSUM");
                Double values = Double.parseDouble(value);
                Dashboard.pieChart1.addData(new ModelPieChart(title, values, getColor(index++)));
            }
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }
    
    public Color getColor(int index) {
        Color[] color = new Color[] {new Color(128,0,128), new Color(75,0,130), new Color(255,0,255)};
        return color[index];
    }
}
