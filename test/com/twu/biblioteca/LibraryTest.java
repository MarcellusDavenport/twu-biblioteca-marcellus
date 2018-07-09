package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class LibraryTest {

    @Test
    public void testListBooks() {
        Library library = new Library();

        assertEquals(11, library.listBooks().size());
    }

    @Test
    public void checkoutBook() {
        Library library = new Library();

        assertTrue(library.checkoutBookByName("Book 1", "123-1234"));
        assertFalse(library.checkoutBookByName("Book", "123-1234"));
    }

    @Test
    public void returnBook() {
        Library library = new Library();

        assertFalse(library.returnBookByName("Book 1"));
        assertFalse(library.returnBookByName("Book"));

        library.checkoutBookByName("Book 1", "123-1234");
        assertTrue(library.returnBookByName("Book 1"));
    }

    @Test
    public void testListMovies() {
        Library library = new Library();

        assertEquals(10, library.listMovies().size());
    }

    @Test
    public void checkoutMovie() {
        Library library = new Library();

        assertTrue(library.checkoutMovieByName("Movie 1", "123-1234"));
        assertFalse(library.checkoutMovieByName("Movie", "123-1234"));
    }

    @Test
    public void returnMovie() {
        Library library = new Library();

        assertFalse(library.returnMovieByName("Movie 1"));
        assertFalse(library.returnMovieByName("Movie"));

        library.checkoutMovieByName("Movie 1", "123-1234");
        assertTrue(library.returnMovieByName("Movie 1"));
    }

    @Test
    public void authenticateUser() {
        Library library = new Library();

        UserAccount user = library.checkIfUserExists("123-1234","password1");
        assertFalse(user == null);
        user = library.checkIfUserExists("123-1234", "badpassword");
        assertTrue(user == null);
    }
}

