package com.twu.biblioteca;

public class Book {
    private String name;
    private String author;
    private int yearPublished;
    private boolean available;
    private String userCheckedOut;

    public Book(String name, String author, int yearPublished) {
        this.name = name;
        this.author = author;
        this.yearPublished = yearPublished;
        userCheckedOut = "none";
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public void setUserCheckedOut(String user) {
        userCheckedOut = user;
    }

    public boolean isAvailable() {
        return userCheckedOut.equals("none");
    }

    public String getUserCheckedOut() {
        return userCheckedOut;
    }
}
