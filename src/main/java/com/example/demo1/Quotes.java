package com.example.demo1;


public class Quotes {
    private String quotes;
    private String teacher;
    private String subject;
    private String date;
    private String user_id;

    public Quotes(String quotes, String teacher, String subject, String date, String user_id) {
        this.quotes = quotes;
        this.teacher = teacher;
        this.subject = subject;
        this.date = date;
        this.user_id = user_id;
    }

    public String getQuotes() {
        return quotes;
    }

    public void setQuotes(String quotes) {
        this.quotes = quotes;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
}

