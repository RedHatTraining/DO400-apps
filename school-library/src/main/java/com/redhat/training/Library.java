package com.redhat.training;

import java.util.ArrayList;
import java.util.HashMap;

import javax.enterprise.context.ApplicationScoped;

import com.redhat.training.inventory.Inventory;

@ApplicationScoped
public class Library {

    private final Inventory inventory;
    private HashMap<String, ArrayList<String>> loans = new HashMap<>();

    public Library(Inventory inventory) {
        this.inventory = inventory;
    }

    public void checkOut(String studentId, String bookId) throws BookNotAvailableException {
        if (!inventory.isBookAvailable( bookId )) {
            throw new BookNotAvailableException( bookId );
        }

        inventory.withdraw(bookId);
        markBookAsBorrowedByStudent(studentId, bookId);
    }

    public double getAvailablityRate() {
        return 1 - ((double) countBookLoans() / inventory.countTotalCopies());
    }

    private void markBookAsBorrowedByStudent(String studentId, String bookId) {
        if (!loans.containsKey(studentId)) {
            loans.put(studentId, new ArrayList<String>());
        }
        loans.get(studentId).add(bookId);
    }

    private int countBookLoans() {
        int count = 0;
        for (ArrayList<String> studentLoans: loans.values()) {
            count += studentLoans.size();
        }

        return count;
    }

}
