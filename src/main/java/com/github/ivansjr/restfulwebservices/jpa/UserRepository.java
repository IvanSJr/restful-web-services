package com.github.ivansjr.restfulwebservices.jpa;

import com.github.ivansjr.restfulwebservices.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
