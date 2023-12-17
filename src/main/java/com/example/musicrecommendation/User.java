package com.example.musicrecommendation;

public class User {
    private String username;
    private int id;
    private String login;

    public User(String username) {
        this.username = username;
        this.id = id;
        this.login = login;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }
}
