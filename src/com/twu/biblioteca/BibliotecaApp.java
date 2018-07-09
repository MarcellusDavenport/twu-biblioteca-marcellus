package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaApp {

    private static Scanner scan = new Scanner(System.in);
    private static Library library = new Library();
    private static UserAccount userLoggedIn = null;

    public static void main(String[] args) {

        boolean userPressedQuit = false;

        while (!userPressedQuit) {
            String loginOrLogout = (userLoggedIn == null) ? "(7) - Login" : "(7) - Logout";
            String viewAccount = (userLoggedIn == null) ? "" : "(8) - View User Information";
            System.out.println("What would you like to do (enter the number associated with the option)?\n The options" +
                    " are:\n(0) - Quit\n(1) - List Books\n(2) - Checkout Book\n(3) - Return Book\n(4) - List Movies\n(5) - Checkout Movie" +
                    "\n(6) - Return Movie\n" + loginOrLogout + "\n" + viewAccount);

            String input = scan.next();
            int commandInt;
            try {
                commandInt = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Select a valid option!\n");
                continue;
            }

            switch (commandInt) {
                case 0:
                    // Quit
                    userPressedQuit = true;
                    System.out.println("Good bye!\n");
                    break;
                case 1:
                    // List Books
                    listBooks();
                    break;
                case 2:
                    // Checkout Book
                    checkoutBook();
                    break;
                case 3:
                    // Return Book
                    returnBook();
                    break;
                case 4:
                    // List Movies
                    listMovies();
                    break;
                case 5:
                    // Checkout Movie
                    checkOutMovie();
                    break;
                case 6:
                    // Return Movie
                    returnMovie();
                    break;
                case 7:
                    // Login or Logout
                    loginOrLogout();
                    break;
                case 8:
                    // View User Information
                    viewUserInformation();
                    break;
                default:
                     System.out.println("Select a valid option!\n");

            }
        }


    }

    private static void viewUserInformation() {
        System.out.println("Name: " + userLoggedIn.getName() + "\nEmail Address: " + userLoggedIn.getEmailAddress()
        + "\nPhone Number: " + userLoggedIn.getPhoneNumber() + "\n");
    }

    private static void loginOrLogout() {
        if (userLoggedIn == null) {
            loginUser();
        } else {
            System.out.println("The logout was successful!\n");
            userLoggedIn = null;
        }
    }

    private static void loginUser() {
        UserAccount validUser = getUserAccount();
        if (validUser == null) {
            System.out.println("The library number or password you entered is incorrect.\n");
        } else {
            System.out.println("The login was successful!\n");
            userLoggedIn = validUser;
        }
    }

    private static UserAccount getUserAccount() {
        System.out.println("Enter your library number.\n");
        String libraryNumber = getString();
        System.out.println("Enter your password.\n");
        String password = scan.nextLine();

        return library.checkIfUserExists(libraryNumber, password);
    }

    private static void returnMovie() {
        if (userLoggedIn == null) {
            System.out.println("You have to be logged-in in order to return a movie.\n");
        } else {
            System.out.println("Enter the name of the movie you would like to return.\n");
            String movieName = getString();
            if (library.returnMovieByName(movieName)) {
                System.out.println("Thank you for returning the movie.\n");
            } else {
                System.out.println("That is not a valid movie to return.\n");
            }
        }
    }

    private static void checkOutMovie() {
        if (userLoggedIn == null) {
            System.out.println("You have to be logged-in in order to checkout a movie.\n");
        } else {
            System.out.println("Enter the name of the movie you would like to check out.\n");
            String movieName = getString();
            if (library.checkoutMovieByName(movieName, userLoggedIn.getLibraryNumber())) {
                System.out.println("Thank you! Enjoy the movie!\n");
            } else {
                System.out.println("That movie is not available.\n");
            }
        }
    }

    private static String getString() {
        scan.nextLine(); // consumes newline character
        return scan.nextLine();
    }

    private static void listMovies() {
        System.out.println("Here are the list of movies:\nName | Year | Director | Movie Rating (from 1-10 or unrated)\n");
        ArrayList<Movie> listOfMovies = library.listMovies();
        printMovies(listOfMovies);
    }

    private static void printMovies(ArrayList<Movie> listOfMovies) {
        for (int i = 0; i < listOfMovies.size(); i++) {
            Movie movie = listOfMovies.get(i);
            if (movie.isAvailable()) {
                System.out.println((i + 1) + ": " + movie.getName() + " | " + movie.getYear() + " | " +
                        movie.getDirector() + " | " + movie.getMovieRating() + "\n");
            }
        }
    }

    private static void returnBook() {
        if (userLoggedIn == null) {
            System.out.println("You have to be logged-in in order to return a book.\n");
        } else {
            System.out.println("Enter the name of the book you would like to return.\n");
            String bookName = getString();
            if (library.returnBookByName(bookName)) {
                System.out.println("Thank you for returning the book.\n");
            } else {
                System.out.println("That is not a valid book to return.\n");
            }
        }

    }

    private static void listBooks() {
        System.out.println("Here are the list of books:\nBook Name | Author | Year Published\n");
        ArrayList<Book> listOfBooks = library.listBooks();
        printBooks(listOfBooks);
    }

    private static void printBooks(ArrayList<Book> listOfBooks) {
        for (int i = 0; i < listOfBooks.size(); i++) {
            Book book = listOfBooks.get(i);
            if (book.isAvailable()) {
                System.out.println((i + 1) + ": " + book.getName() + " | " + book.getAuthor() + " | " +
                        book.getYearPublished() + " \n");
            }
        }
    }

    private static void checkoutBook() {
        if (userLoggedIn == null) {
            System.out.println("You have to be logged-in in order to checkout a book.\n");
        } else {
            System.out.println("Enter the name of the book you would like to check out.\n");
            String bookName = getString();
            if (library.checkoutBookByName(bookName, userLoggedIn.getLibraryNumber())) {
                System.out.println("Thank you! Enjoy the book!\n");
            } else {
                System.out.println("That book is not available.\n");
            }
        }

    }
}
