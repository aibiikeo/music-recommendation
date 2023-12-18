package com.example.musicrecommendation;

public class User {
    private int id;
    private String username;
    private String login;

    public User(String username) {
        this.id = id;
        this.username = username;
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
