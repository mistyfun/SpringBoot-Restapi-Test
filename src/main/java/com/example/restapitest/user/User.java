package com.example.restapitest.user;

import java.util.UUID;

public record User(String id, String name, String email) {
    // we use record, so we don't have to create the getter, setter etc.
    // User is like VO, it's a set of data
    public User(String name, String email) {
        this(UUID.randomUUID().toString(), name, email);
    }

}
