package com.redhat.training.inventory;


public interface Inventory {
    void add( String string, int numCopies );

    void withdraw( String bookId );

    boolean isBookAvailable( String bookId );

    int countTotalCopies();
}
