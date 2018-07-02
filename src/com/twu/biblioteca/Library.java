package com.twu.biblioteca;

import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books;

    public Library() {
        this.books = new ArrayList<Book>();
        // adds 11 books to available books
        for (int i = 0; i < 11; i++) {
            this.books.add(new Book("Book " + String.valueOf(i), "Author " + String.valueOf(i), i));
        }

    }

    public ArrayList<Book> listBooks() {
        return books;
    }

    public boolean checkoutBookByName(String bookName) {
        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            if (book.getName().equals(bookName) && book.isAvailable()) {
                book.setAvailability(false);
                return true;
            }
        }
        return false;
    }

    public boolean returnBookByName(String bookName) {
        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            if (book.getName().equals(bookName) && !book.isAvailable()) {
                book.setAvailability(true);
                return true;
            }
        }
        return false;
    }


}

