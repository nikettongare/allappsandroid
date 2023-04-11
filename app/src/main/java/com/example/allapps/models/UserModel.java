package com.example.allapps.models;

import org.jetbrains.annotations.NotNull;

public class UserModel {
    private int id;
    private String name;
    private String email;

    public UserModel(@NotNull int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }
}
