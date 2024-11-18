/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utem.rentalsystem;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author 
 */
public abstract class VehicleReceiptAbstract {
    
    private Date date;
    
    public String getTitle () {
        String title = "CAR RENTAL RECEIPT";
        return title;
    }
      
    public String getDate() {
       date = new Date();
        SimpleDateFormat Datefor = new SimpleDateFormat("dd MMMM yyyy");
        String stringdate = Datefor.format(date);
        return stringdate;
    }
    
    public abstract String getReceiptNo();
}
