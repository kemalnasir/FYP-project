/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utem.rentalsystem;

/**
 *
 * @author                                      
 */
public class FeedbackWebsite extends FeedbackAbstract implements FeedbackWebsiteInterface
{
    private String visitReason;
    private String visit;
    private String satisfaction;

    public FeedbackWebsite() {
    }

    /**
     *
     * @return
     */
    @Override
    public String getVisitReason() {
        return visitReason;
    }

    @Override
    public void setVisitReason(String visitReason) {
        this.visitReason = visitReason;
    }

    public String getVisit() {
        return visit;
    }

    public void setVisit(String visit) {
        this.visit = visit;
    }

    @Override
    public String getSatisfaction() {
        return satisfaction;
    }

    @Override
    public void setSatisfaction(String satisfaction) {
        this.satisfaction = satisfaction;
    }
  
}

