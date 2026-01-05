package com.restApi.services.webServices.User;


import com.restApi.services.webServices.response.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDate;
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

        User user = userDaoService.findOne(id);
        if(user==null){
            throw new UserNotFoundException("user not found id:" + id);
        }
        return user;
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<ApiResponse> removeUserById(@PathVariable  int id){
        userDaoService.deleteById(id);

        ApiResponse response = new ApiResponse(
                LocalDate.now(),
                "user deleted successfully"
        );
         return  ResponseEntity.ok(response);
    }

    @PostMapping("/user")
    public ResponseEntity<User> createUser(@Valid  @RequestBody User user){
        User savedUser = userDaoService.save(user);
        //buiding the URI of the resource to send along with the request
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        //sending body and URI as header named location
        //http://localhost:8080/user/4
        return ResponseEntity.created(location).body(savedUser);
    }

}
