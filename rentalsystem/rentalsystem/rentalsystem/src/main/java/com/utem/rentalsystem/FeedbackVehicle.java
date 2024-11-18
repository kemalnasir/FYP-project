/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utem.rentalsystem;

/**
 *
 * @author 
 */
public class FeedbackVehicle extends FeedbackAbstract implements FeedbackVehicleInterface
{
    private String vehicleType;
    private String Satisfaction;
    private String rental;
    private String problem;
    
    @Override
    public String getVehicleType() {
        return vehicleType;
    }

    @Override
    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    @Override
    public String getSatisfaction() {
        return Satisfaction;
    }

    @Override
    public void setSatisfaction(String Satisfaction) {
        this.Satisfaction = Satisfaction;
    }

    public String getRental() {
        return rental;
    }

    public void setRental(String rental) {
        this.rental = rental;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }
 
}
