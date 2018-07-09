package com.twu.biblioteca;

import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books;
    private ArrayList<Movie> movies;
    private ArrayList<UserAccount> users;

    public Library() {
        // library setup
        generateStarterBooks();
        generateStarterMovies();
        generateStarterUsers();
    }

    private void generateStarterUsers() {
        this.users = new ArrayList<UserAccount>();
        UserAccount user1 = new UserAccount("Bob", "bob@gmail.com", "(301)363-2236",
                "123-1234", "password1");
        UserAccount user2 = new UserAccount("Henry", "henry@gmail.com", "(240)292-4589",
                "444-4444", "password2");
        this.users.add(user1);
        this.users.add(user2);
    }

    private void generateStarterBooks() {
        this.books = new ArrayList<Book>();
        for (int i = 0; i < 11; i++) {
            this.books.add(new Book("Book " + String.valueOf(i), "Author " + String.valueOf(i), i));
        }
    }

    private void generateStarterMovies() {
        this.movies = new ArrayList<Movie>();
        for (int i = 0; i < 10; i++) {
            this.movies.add(new Movie("Movie " + String.valueOf(i), i, "Director " + String.valueOf(i),
                    "Rating: " + String.valueOf(i + 1)));
        }
    }

    public ArrayList<Book> listBooks() {
        return books;
    }

    public ArrayList<Movie> listMovies() {
        return movies;
    }

    public boolean checkoutBookByName(String bookName, String userByLibraryNumber) {
        for (Book book : books) {
            if (book.getName().equals(bookName) && book.isAvailable()) {
                book.setUserCheckedOutByLibraryNumber(userByLibraryNumber);
                return true;
            }
        }
        return false;
    }

    public boolean returnBookByName(String bookName) {
        for (Book book : books) {
            if (book.getName().equals(bookName) && !book.isAvailable()) {
                book.setUserCheckedOutByLibraryNumber("none");
                return true;
            }
        }
        return false;
    }


    public boolean checkoutMovieByName(String movieName, String userByLibraryNumber) {
        for (Movie movie : movies) {
            if (movie.getName().equals(movieName) && movie.isAvailable()) {
                movie.setUserCheckedOutByLibraryNumber(userByLibraryNumber);
                return true;
            }
        }
        return false;
    }

    public boolean returnMovieByName(String movieName) {
        for (Movie movie : movies) {
            if (movie.getName().equals(movieName) && !movie.isAvailable()) {
                movie.setUserCheckedOutByLibraryNumber("none");
                return true;
            }
        }
        return false;
    }

    public UserAccount checkIfUserExists(String libraryNumber, String password) {
        for (UserAccount user : users) {
            if (user.getLibraryNumber().equals(libraryNumber) && user.getPassword().equals(password)) {
                return user;
            }
        }

        return null;
    }
}

