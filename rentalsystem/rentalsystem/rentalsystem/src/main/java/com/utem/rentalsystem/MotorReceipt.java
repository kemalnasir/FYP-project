/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utem.rentalsystem;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 *
 * @author 
 */
public class MotorReceipt extends VehicleReceiptAbstract
{
    private Date date;
    private static int receiptNo = 1;
    private double totalPrice = 0;
    private  ArrayList <MotorBooking> mB;
  
    public MotorReceipt(ArrayList<MotorBooking> mB) 
    {
        this.mB = mB;
    }

    @Override
    public String getTitle () 
    {
        String title = "CAR RENTAL RECEIPT";
        return title;
    }
      
    @Override
    public String getDate() 
    {
       date = new Date();
        SimpleDateFormat Datefor = new SimpleDateFormat("dd MMMM yyyy");
        String stringdate = Datefor.format(date);
        return stringdate;
    }

    @Override
    public String getReceiptNo() 
    {
       Date d = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);
        date = new Date();
        SimpleDateFormat Tarikh = new SimpleDateFormat ("yy");
        String stringDate = Tarikh.format(date);
        return (receiptNo++) + "/" + stringDate;
    }

}
