package com.restApi.services.webServices.helloWorld;


import org.springframework.web.bind.annotation.*;

@RestController
public class HelloWorldController {

    @GetMapping(path = "/hello-world")
    public String helloWorld(){
        return "Hello World";
    }

    @GetMapping(path="/hello-world-bean")
    public HelloWorldBean getHelloWorldBean(){
        return new HelloWorldBean("hi from helloworldbean");
    }

    @GetMapping(path="/hello-world-bean/{name}")
    public HelloWorldBean getHelloWorldBean(@PathVariable String name){
        return new HelloWorldBean(String.format("Hello World, %s", name));
    }

}
