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

        assertTrue(library.checkoutBookByName("Book 1"));
        assertFalse(library.checkoutBookByName("Book"));
    }

    
}

