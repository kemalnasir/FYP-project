/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utem.rentalsystem;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author 
 */
public class CarReceipt extends VehicleReceiptAbstract
{
    private Date date;
    private static int receiptNo = 1;
    private double totalPrice = 0;
    private  ArrayList <CarBooking> c;
  
    public CarReceipt(ArrayList<CarBooking> c) 
    {
        this.c = c;
    }

    @Override
    public String getTitle () {
        String title = "CAR RENTAL RECEIPT";
        return title;
    }
      
    @Override
    public String getDate() {
       date = new Date();
        SimpleDateFormat Datefor = new SimpleDateFormat("dd MMMM yyyy");
        String stringdate = Datefor.format(date);
        return stringdate;
    }

    @Override
    public String getReceiptNo() {
       Date d = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);
        date = new Date();
        SimpleDateFormat Tarikh = new SimpleDateFormat ("yy");
        String stringDate = Tarikh.format(date);
        return (receiptNo++) + "/" + stringDate;
    }

}
