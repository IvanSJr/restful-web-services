package com.github.ivansjr.restfulwebservices.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDaoService {

    private static List<User> users = new ArrayList<>();
    private static Integer usersCount = 1;

    public List<User> findAll(){
        return users;
    }

    public User findOne(int id) {
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        return users.stream().filter(predicate).findFirst().get();
    }

    public User save(User user){
        user.setId(usersCount++);
        users.add(user);
        return user;
    }

    static {
        users.add(new User(usersCount++, "Ivan", LocalDate.of(2001, 6, 27)));
        users.add(new User(usersCount++, "João Victor", LocalDate.of(2009, 5, 21)));
        users.add(new User(usersCount++, "João Paulo", LocalDate.of(2013, 6, 30)));
    }

}

