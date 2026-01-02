package com.restApi.services.webServices.User;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserResource {
    private final UserDaoService userDaoService;
    UserResource(UserDaoService userDaoService){
        this.userDaoService=userDaoService;
    }

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userDaoService.findAll();
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable  int id){
        return userDaoService.findOne(id);
    }

    @PostMapping("/user")
    public ResponseEntity<User> saveUser(@RequestBody User user){
        userDaoService.save(user);
        return ResponseEntity.created(null).build();
    }

}
