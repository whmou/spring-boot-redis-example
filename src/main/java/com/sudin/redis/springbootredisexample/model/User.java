package com.sudin.redis.springbootredisexample.model;

import lombok.Data;
import java.io.Serializable;

@Data
public class User implements Serializable{

    private String id;
    private String firstName;

    public User() {
    }

    public User(String id, String firstName) {
        this.id = id;
        this.firstName = firstName;
    }

    public User(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

}
