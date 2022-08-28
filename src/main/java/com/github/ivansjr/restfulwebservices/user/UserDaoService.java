package com.github.ivansjr.restfulwebservices.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDaoService {

    private static List<User> users = new ArrayList<>();

    public List<User> findAll(){
        return users;
    }

    static {
        users.add(new User(1, "Ivan", LocalDate.of(2001, 6, 27)));
        users.add(new User(2, "João Victor", LocalDate.of(2009, 5, 21)));
        users.add(new User(3, "João Paulo", LocalDate.of(2013, 6, 30)));
    }

}

