/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utem.rentalsystem;

/**
 *
 * @author
 */
public abstract class FeedbackAbstract {
    public String improvement;
    public String message;
    
    public String getImprovement() {
        return improvement;
    }

    public void setImprovement(String improvement) {
        this.improvement = improvement;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    public abstract String getSatisfaction();
    public abstract void setSatisfaction(String satisfaction);
}
