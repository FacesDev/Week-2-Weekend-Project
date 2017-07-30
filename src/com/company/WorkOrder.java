package com.company;

import jdk.net.SocketFlow;

/**
 * Created by solderedmachd on 7/27/17.
 */
public class WorkOrder {
    double id;
    String description;
    String senderName;
    Status status;

    public WorkOrder(double id, String description, String senderName, Status status) {
        this.id = id;
        this.description = description;
        this.senderName = senderName;
        this.status = status;
    }

    public WorkOrder(){

    }


    public double getId() {
        return id;
    }

    public void setId(double id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "WorkOrder{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", senderName='" + senderName + '\'' +
                ", status=" + status +
                '}';
    }
}
