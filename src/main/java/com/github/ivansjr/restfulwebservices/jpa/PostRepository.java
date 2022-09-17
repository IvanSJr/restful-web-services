package com.github.ivansjr.restfulwebservices.jpa;

import com.github.ivansjr.restfulwebservices.user.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {
}
