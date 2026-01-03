package com.restApi.services.webServices.Exception;

import java.time.LocalDate;

public class ErrorDetails {
    //timestamp
    private LocalDate timeStamp;
    //error message
    private String message;
    //details of the error
    private String details;


    ErrorDetails(LocalDate timeStamp, String message, String details){
        this.timeStamp = timeStamp;
        this.message = message;
        this.details = details;
    }

    public LocalDate getTimeStamp() {
        return timeStamp;
    }

    public String getDetails() {
        return details;
    }

    public String getMessage() {
        return message;
    }





}
