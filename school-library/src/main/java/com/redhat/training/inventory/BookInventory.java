package com.redhat.training.inventory;


public interface BookInventory {
    void add( String string, int numCopies );

    void withdraw( String bookId );

    boolean isBookAvailable( String bookId );

    int countAvailableCopies();

    int countTotalCopies();
}
