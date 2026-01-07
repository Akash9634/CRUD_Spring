package com.restApi.services.webServices.repository;

import com.restApi.services.webServices.User.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Integer> {
}
