package com.restApi.services.webServices.repository;

import com.restApi.services.webServices.User.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<User,Integer> {
}
