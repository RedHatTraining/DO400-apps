package com.redhat.training;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;

import com.redhat.training.books.BookNotAvailableException;
import com.redhat.training.inventory.Inventory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class LibraryWithMockedInventoryTest {

    Inventory inventory;
    Library library;

    @BeforeEach
    public void setUp() {
        inventory = mock(Inventory.class);
        library = new Library(inventory);
    }

    @Test
    public void checkingOutChecksBookAvailability() throws BookNotAvailableException {
        // Given
        when(inventory.isBookAvailable("book1")).thenReturn(true);

        // When
        library.checkOut("student1", "book1");

        // Then
        verify(inventory).isBookAvailable("book1");
    }

    @Test
    public void checkingOutWithdrawsFromInventoryWhenBookIsAvailable() throws BookNotAvailableException {
        // Given
        when(inventory.isBookAvailable("book1")).thenReturn(true);

        // When
        library.checkOut("student1", "book1");

        // Then
        verify(inventory).withdraw("book1");
    }

    @Test
    public void checkingOutDoesNotWithdrawFromInventoryWhenBookIsUnavailable() throws BookNotAvailableException {
        // Given
        when(inventory.isBookAvailable("book1")).thenReturn(false);

        // When
        try {
            library.checkOut("student1", "book1");
        } catch(BookNotAvailableException e) {}

        // Then
        verify(inventory, times(0)).withdraw("book1");
    }
}
