package com.example.oceanbatapp;

public class UserHelperClass {

    String email, password, Username, Birthday;

    public UserHelperClass() {
    }

    public UserHelperClass(String email, String password, String username, String birthday) {
        this.email = email;
        this.password = password;
        Username = username;
        Birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getBirthday() {
        return Birthday;
    }

    public void setBirthday(String birthday) {
        Birthday = birthday;
    }

}
