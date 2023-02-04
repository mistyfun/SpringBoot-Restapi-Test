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
                    new User("1", "Sandy", "0987654321@email.com"),
                    new User("2", "Tom", "1122334455@email.com"),
                    new User("3", "Jerry", "12345@email.com")
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
}