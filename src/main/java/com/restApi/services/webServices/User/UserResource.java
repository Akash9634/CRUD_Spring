package com.restApi.services.webServices.User;


import com.restApi.services.webServices.repository.PostRepository;
import com.restApi.services.webServices.repository.UserJpaRepository;
import com.restApi.services.webServices.response.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
public class UserResource {
    private final UserDaoService userDaoService;
    private final UserJpaRepository repository;
    private final PostRepository postRepository;
    UserResource(UserDaoService userDaoService, UserJpaRepository repository, PostRepository postRepository){
        this.repository=repository;
        this.userDaoService=userDaoService;
        this.postRepository=postRepository;
    }

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userDaoService.getAll();
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable  int id){

        User user = userDaoService.getById(id);
        if(user==null){
            throw new UserNotFoundException("user not found id:" + id);
        }
        return user;
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<ApiResponse> removeUserById(@PathVariable  int id){
        userDaoService.removeById(id);

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

    @GetMapping("/user/{id}/posts")
    public List<Post> retrievePostForUser(@PathVariable  int id){

        Optional<User> user = repository.findById(id);
        if(user.isEmpty()){
            throw new UserNotFoundException("id: "+id);
        }
        return user.get().getPosts();
    }

    @Transactional
    @PostMapping("/user/{id}/posts")
    public List<Post> createPostForUser(@PathVariable int id, @Valid @RequestBody Post post){

        Optional<User> user = repository.findById(id);
        if(user.isEmpty()){
            throw new UserNotFoundException("id: "+id);
        }
        post.setUser(user.get());
        postRepository.save(post);
        return user.get().getPosts();
    }

}
