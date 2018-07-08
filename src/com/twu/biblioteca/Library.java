package com.twu.biblioteca;

import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books;
    private ArrayList<Movie> movies;

    public Library() {
        // library setup
        // generate users
        // generate books
        // generate movies
        this.books = new ArrayList<Book>();

        // generates 11 starter books
        for (int i = 0; i < 11; i++) {
            this.books.add(new Book("Book " + String.valueOf(i), "Author " + String.valueOf(i), i));
        }

        // generates 11 starter movies
        this.movies = new ArrayList<Movie>();



    }

    public ArrayList<Book> listBooks() {
        return books;
    }

    public ArrayList<Movie> listMovies() {
        return movies;
    }

    public boolean checkoutBookByName(String bookName, String userByLibraryNumber) {
        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            if (book.getName().equals(bookName) && book.isAvailable()) {
                book.setUserCheckedOutByLibraryNumber(userByLibraryNumber);
                return true;
            }
        }
        return false;
    }

    public boolean returnBookByName(String bookName) {
        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            if (book.getName().equals(bookName) && !book.isAvailable()) {
                book.setUserCheckedOutByLibraryNumber("none");
                return true;
            }
        }
        return false;
    }


    public boolean checkoutMovieByName(String movieName, String userByLibraryNumber) {
        for (int i = 0; i < movies.size(); i++) {
            Movie movie = movies.get(i);
            if (movie.getName().equals(movieName) && movie.isAvailable()) {
                movie.setUserCheckedOutByLibraryNumber(userByLibraryNumber);
                return true;
            }
        }
        return false;
    }
}

