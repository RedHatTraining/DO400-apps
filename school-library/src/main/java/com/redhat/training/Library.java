package com.redhat.training;

import com.redhat.training.inventory.BookInventory;


public class Library {

    private final BookInventory inventory;

    public Library( BookInventory inventory ) {
        this.inventory = inventory;
    }

    public double getAvailablityRate() {
        return (double) inventory.countAvailableCopies() / inventory.countTotalCopies();
    }

    public void checkOut( String string, String bookId ) throws BookNotAvailableException {

        if (!inventory.isBookAvailable(bookId)) {
            throw new BookNotAvailableException(bookId);
        }

        inventory.withdraw(bookId);
    }

}
