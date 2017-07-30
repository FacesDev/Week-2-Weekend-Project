package com.company;

/**
 * Created by solderedmachd on 7/27/17.
 */
public enum Status {
    INITIAL("INITIAL"),
    ASSIGNED("ASSIGNED"),
    IN_PROGRESS("IN PROGRESS"),
    DONE("DONE");

    private String statusText;

    Status(String statusText) {
        this.statusText = statusText;
    }


    public String getStatusText(){
        return statusText;
    }


}
