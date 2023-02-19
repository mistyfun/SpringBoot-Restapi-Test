package com.example.restapitest.user;

import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserService {
    //UserService is where the business logics are
    public Set<User> users = new HashSet<>(
            List.of(
                    new User("Sandy", "0987654321@email.com"),
                    new User("Tom", "1122334455@email.com"),
                    new User("Jerry", "12345@email.com")
            )
    );

    public Boolean removeUser(String userId) {
        return users.removeIf(user -> user.id().equals(userId));
    }

    public User getUser(String userId) {
        for (User user : users) {
            if (userId.equals(user.id())) {
                return user;
            }
        }
        return null;
    }

    public User createUser(String name, String email) {
        if (name == null || email == null) return null;
        User user = new User(name, email);
        users.add(user);
        return user;
    }

    public User updateUser(User user) {
        if (user.id() == null || user.name() == null || user.email() == null) return null;
        removeUser(user.id());
        users.add(user);
        return user;
    }

}