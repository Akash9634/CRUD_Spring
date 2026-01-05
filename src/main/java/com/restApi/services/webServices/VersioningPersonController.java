package com.restApi.services.webServices;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {

    @GetMapping("v1/person")
    public PersonV1 getFirstVersionPerson(){
        return new PersonV1("akash kush");
    }

    @GetMapping("v2/person")
    public PersonV2 getSecondVersionPerson(){
        return new PersonV2("akash", "kush");
    }

    @GetMapping(path="/person", params = "version=1")
    public PersonV1 getFirstVersionPersonRequestParam(){
        return new PersonV1("aditya kush");
    }

    @GetMapping(path="/person", params = "version=2")
    public PersonV2 getSecondVersionPersonRequestParam(){
        return new PersonV2("aditya", "kush");
    }
}
