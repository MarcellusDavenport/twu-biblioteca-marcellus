package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Library library = new Library();

        System.out.println("Welcome, Customer\n");

        boolean userPressedQuit = false;

        while (!userPressedQuit) {
            System.out.println("What would you like to do (enter the number associated with the option)? The options" +
                    " are: (1) - List Books, (2) - Checkout Book, (3) - Return Book, or (4) - Quit\n");
            int commandInt = scan.nextInt();

            switch (commandInt) {
                case 1:
                    // List Books
                    listBooks(library);
                    break;
                case 2:
                    // Checkout Book
                    checkoutBook(library, scan);
                    break;
                case 3:
                    // Return Book
                    returnBook(library, scan);
                    break;
                case 4:
                    // Quit
                    userPressedQuit = true;
                    System.out.println("Good bye!\n");
                    break;
                 default:
                     System.out.println("Select a valid option!\n");

            }
        }


    }

    private static void returnBook(Library library, Scanner scanner) {
        System.out.println("Enter the name of the book you would like to return.\n");
        scanner.nextLine(); // consumes newline character
        String bookName = scanner.nextLine();
        if (library.returnBookByName(bookName)) {
            System.out.println("Thank you for returning the book.\n");
        } else {
            System.out.println("That is not a valid book to return.\n");
        }
    }

    private static void listBooks(Library library) {
        System.out.println("Here are the list of books:/nBook Name | Author | Year Published\n");
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

    private static void checkoutBook(Library library, Scanner scanner) {
        System.out.println("Enter the name of the book you would like to check out.\n");
        scanner.nextLine(); // consumes newline character
        String bookName = scanner.nextLine();
        System.out.println(bookName);
        if (library.checkoutBookByName(bookName)) {
            System.out.println("Thank you! Enjoy the book!\n");
        } else {
            System.out.println("That book is not available.\n");
        }
    }
}
