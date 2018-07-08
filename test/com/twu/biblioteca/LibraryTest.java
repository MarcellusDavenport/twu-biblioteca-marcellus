package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class LibraryTest {

    @Test
    public void testListOfBooks() {
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

        assertEquals(11, library.listMovies().size());
    }
}

