package com.keisse.test.moatje.models;

public class User {
    private String username;
    private String password;
    boolean isBanned;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean createAccount(String username, String password) {
        setUsername(username);
        setPassword(password);
        return false;
    }

    public boolean login(String username, String password) {
        return false;
    }

    public void setBanned(boolean isBanned) {
        this.isBanned = isBanned;
    }
}
