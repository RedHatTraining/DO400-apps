package com.redhat.training;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.redhat.training.books.Book;
import com.redhat.training.books.BookNotAvailableException;
import com.redhat.training.inventory.InMemoryInventory;


public class LibraryTest {

    InMemoryInventory inventory;
    Library library;

    @BeforeEach
    public void setUp() {
        inventory = new InMemoryInventory();
        library = new Library(inventory);
    }

    @Test
    public void gettingAvailabilityRateReturnsCorrectPercent() throws BookNotAvailableException {
        // Given
        inventory.add(new Book("book1"));
        inventory.add(new Book("book1"));
        inventory.add(new Book("book2"));
        inventory.add(new Book("book2"));

        library.checkOut("student1", "book1");

        // When
        double rate = library.getAvailablityRate();

        // Then
        assertEquals(0.75, rate);
    }

    @Test
    public void checkingOutDecreasesNumberOfBookCopiesFromInventory() throws BookNotAvailableException {
        // Given
        inventory.add(new Book("book1"));
        inventory.add(new Book("book1"));

        // When
        library.checkOut("someStudentId", "book1");

        // Then
        assertEquals(1, inventory.countCopies("book1"));
    }

    @Test
    public void checkingOutUnavailableBookThrowsException() throws BookNotAvailableException {
        // Given
        inventory.add(new Book("book1"));
        inventory.add(new Book("book1"));

        library.checkOut("student1", "book1");
        library.checkOut("student2", "book1");

        // When
        final BookNotAvailableException exception = assertThrows( BookNotAvailableException.class, () -> {
            library.checkOut("student3", "book1");
        } );

        // Then
        assertTrue(exception.getMessage().matches("Book book1 is not available"));
    }
}
