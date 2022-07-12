package com.example.demo1;

public class User {
    private String login;
    private String password;
    private String post;
    private String count_quotes;

    public User(String login, String password, String post, String count_quotes) {
        this.login = login;
        this.password = password;
        this.post = post;
        this.count_quotes = count_quotes;
    }

    public User() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getCount() {
        return count_quotes;
    }

    public void setCount(String count_quotes) {
        this.count_quotes = count_quotes;
    }
}