package com.redhat.training.inventory;

import java.util.HashMap;


public class InMemoryInventory implements BookInventory {

    int totalCopiesAdded = 0;
    HashMap<String, Integer> copies = new HashMap<>();

    @Override
    public void add( String bookId, int numCopies ) {
        copies.put(bookId, numCopies);
        totalCopiesAdded += numCopies;
    }

    @Override
    public void withdraw( String bookId ) {
        copies.put(bookId, copies.get(bookId) - 1);
    }

    @Override
    public boolean isBookAvailable( String bookId ) {
        return copies.get(bookId) > 0;
    }

    @Override
    public int countAvailableCopies() {
        int count = 0;
        for (int bookCopies: copies.values()) {
            count += bookCopies;
        }

        return count;
    }

    @Override
    public int countTotalCopies() {
        return totalCopiesAdded;
    }

    public Integer getCopies( String bookId ) {
        return copies.get(bookId);
    }

}
