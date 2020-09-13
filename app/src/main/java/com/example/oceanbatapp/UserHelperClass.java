package com.example.oceanbatapp;

public class UserHelperClass {

    String email, password, Username, Birthday, phoneNo;

    public UserHelperClass() {
    }

    public UserHelperClass(String email, String password, String username, String birthday, String phoneNo) {
        this.email = email;
        this.password = password;
        Username = username;
        Birthday = birthday;
        this.phoneNo = phoneNo;

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

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
}
