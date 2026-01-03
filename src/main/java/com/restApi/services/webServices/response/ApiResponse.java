package com.restApi.services.webServices.response;

import org.springframework.cglib.core.Local;

import java.time.LocalDate;

public class ApiResponse {
    private LocalDate timeStamp;
    private String message;



    public ApiResponse(LocalDate timeStamp, String message){
        this.timeStamp = timeStamp;
        this.message = message;
    }

    public LocalDate getTimeStamp() {
        return timeStamp;
    }

    public String getMessage() {
        return message;
    }

}
