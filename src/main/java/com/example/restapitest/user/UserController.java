package com.example.restapitest.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
// this is like a Servlet
@RestController
public class UserController {
    private final UserService userService;

    @Autowired
    // this means create a service and put it into the controller
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    // this means to add a path on the webserver
    // by default, spring serializes objects into json
    public ResponseEntity<Set<User>> users() {
        // users
        Set<User> users = userService.users;
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<User> getUser(@PathVariable String userId) {
        User user = userService.getUser(userId);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/users/{userId}")
    public ResponseEntity<User> deleteUser(@PathVariable String userId) {
        User user = userService.getUser(userId);
        boolean deleted = userService.removeUser(userId);
        if (deleted) {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User userRequest) {
        User user = userService.createUser(userRequest.name(), userRequest.email());
        if (user != null) {
            return new ResponseEntity<>(null, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}