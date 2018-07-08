package com.twu.biblioteca;

public class Book {
    private String name;
    private String author;
    private int yearPublished;
    private boolean available;
    private String userCheckedOutByLibraryNumber;

    public Book(String name, String author, int yearPublished) {
        this.name = name;
        this.author = author;
        this.yearPublished = yearPublished;
        userCheckedOutByLibraryNumber = "none";
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

    public void setUserCheckedOutByLibraryNumber(String user) {
        userCheckedOutByLibraryNumber = user;
    }

    public boolean isAvailable() {
        return userCheckedOutByLibraryNumber.equals("none");
    }

    public String getUserCheckedOutByLibraryNumber() {
        return userCheckedOutByLibraryNumber;
    }
}
