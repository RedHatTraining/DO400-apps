package com.redhat.training.inventory;

import java.util.HashMap;

import javax.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class InMemoryInventory implements Inventory {

    int totalCopies = 0;
    HashMap<String, Integer> copiesByBook = new HashMap<>();

    @Override
    public void add(String bookId, int numCopies) {
        copiesByBook.put(bookId, numCopies);
        totalCopies += numCopies;
    }

    @Override
    public void withdraw(String bookId) {
        copiesByBook.put(bookId, copiesByBook.get(bookId) - 1);
    }

    @Override
    public boolean isBookAvailable(String bookId) {
        if (copiesByBook.containsKey(bookId)) {
            return copiesByBook.get(bookId) > 0;
        }
        return false;
    }

    @Override
    public int countTotalCopies() {
        return totalCopies;
    }

    public Integer getCopies(String bookId) {
        return copiesByBook.get(bookId);
    }

}
