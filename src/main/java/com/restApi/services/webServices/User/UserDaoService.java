package com.restApi.services.webServices.User;

import com.restApi.services.webServices.repository.UserJpaRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

@Component
public class UserDaoService {

    private final UserJpaRepository repository;
    public UserDaoService(UserJpaRepository repository){
        this.repository = repository;
    }

    public List<User> getAll(){
        return repository.findAll();
    }

    public User save(User user){
        repository.save(user);
        return user;
    }

    public User getById(int id) {
        Optional<User> user = repository.findById(id);
        return user.orElse(null);
    }

    public void removeById(int id){
        repository.deleteById(id);
    }

}
