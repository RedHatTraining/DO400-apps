package com.redhat.training;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.redhat.training.inventory.InMemoryInventory;


public class LibraryTest {

    InMemoryInventory inventory;

    @BeforeEach
    public void setUp() {
        inventory = new InMemoryInventory();
    }

    @Test
    public void test_getAvailabilityRate() throws BookNotAvailableException {
        // Given
        inventory.add("book1", 2);
        inventory.add("book2", 2);
        Library library = new Library(inventory);
        library.checkOut("student1", "book1");

        // When
        double rate = library.getAvailablityRate();

        // Then
        assertEquals(0.75, rate);
    }

    @Test
    public void test_checkout_withdrawsACopyOfTheBook() throws BookNotAvailableException {
        // Given
        InMemoryInventory inventory = new InMemoryInventory();
        inventory.add("book1", 2);
        Library library = new Library(inventory);

        // When
        library.checkOut("student1", "book1");

        // Then
        assertEquals(1, inventory.getCopies("book1"));
    }

    @Test
    public void test_checkout_throwsException_whenBookIsNotAvailable() throws BookNotAvailableException {
        // Given
        InMemoryInventory inventory = new InMemoryInventory();
        inventory.add("book1", 2);
        Library library = new Library(inventory);
        library.checkOut("student1", "book1");
        library.checkOut("student2", "book1");

        // When
        final BookNotAvailableException exception = assertThrows( BookNotAvailableException.class, () -> {
            library.checkOut("student1", "book1");
        } );


        // Then
        assertTrue(exception.getMessage().matches("(?i).* book1 .* not available"));
    }


}