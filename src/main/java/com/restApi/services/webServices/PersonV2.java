package com.restApi.services.webServices;

public class PersonV2 {
    private String firstName;
    private String secondName;



    public PersonV2(String firstName, String secondName){
        this.firstName = firstName;
        this.secondName = secondName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }


}
