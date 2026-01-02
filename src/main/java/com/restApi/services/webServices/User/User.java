package com.restApi.services.webServices.User;

import java.time.LocalDate;

public class User {
    private Integer id;
    private String name;
    private LocalDate birthDate;



    User(Integer id, String name, LocalDate birthDate){
        this.id=id;
        this.name=name;
        this.birthDate=birthDate;
    }

    //no args constructor
    User(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
