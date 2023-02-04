package com.example.restapitest.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
        return new ResponseEntity<>(userService.users, HttpStatus.OK);
    }
}
