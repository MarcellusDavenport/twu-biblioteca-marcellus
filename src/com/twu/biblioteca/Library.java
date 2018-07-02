package com.twu.biblioteca;

import java.util.ArrayList;

public class Library {
    private ArrayList<Book> availableBooks;

    public Library() {
        this.availableBooks = new ArrayList<Book>();
        // adds 11 books to available books
        for (int i = 0; i < 11; i++) {
            this.availableBooks.add(new Book("Book " + String.valueOf(i), "Author " + String.valueOf(i), i));
        }

    }

    public ArrayList<Book> listBooks() {
        return availableBooks;
    }

    public boolean checkoutBookByName(String bookName) {
        for (int i = 0; i < availableBooks.size(); i++) {
            Book book = availableBooks.get(i);
            if (book.getName().equals(bookName) && book.isAvailable()) {
                book.setAvailability(false);
                return true;
            }
        }
        return false;
    }
}

