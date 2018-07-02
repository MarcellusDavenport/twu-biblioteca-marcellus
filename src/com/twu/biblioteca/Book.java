package com.twu.biblioteca;

public class Book {
    private String name;
    private String author;
    private int yearPublished;
    private boolean available;

    public Book(String name, String author, int yearPublished) {
        this.name = name;
        this.author = author;
        this.yearPublished = yearPublished;
        this.available = true;
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

    public void setAvailability(boolean bool) {
        available = bool;
    }

    public boolean isAvailable() {
        return available;
    }
}
