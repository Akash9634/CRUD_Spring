package com.restApi.services.webServices.Exception;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ErrorDetails {
    //timestamp
    private LocalDateTime timeStamp;
    //error message
    private String message;
    //details of the error
    private String details;


    ErrorDetails(LocalDateTime timeStamp, String message, String details){
        this.timeStamp = timeStamp;
        this.message = message;
        this.details = details;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public String getDetails() {
        return details;
    }

    public String getMessage() {
        return message;
    }





}
