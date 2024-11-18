/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utem.rentalsystem;

/**
 *
 * @author 
 */
public class AdminLogin extends AdminLoginAbstract implements AdminLoginInterface
{
    private String userName;
    private String password;
    
    @Override
    public String getUserName() 
    {
        return userName;
    }

    @Override
    public void setUserName(String userName) 
    {
        this.userName = userName;
    }

    @Override
    public String getPassword() 
    {
        return password;
    }

    @Override
    public void setPassword(String password) 
    {
        this.password = password;
    }

}
