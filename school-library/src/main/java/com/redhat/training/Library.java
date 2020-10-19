package com.redhat.training;

import java.util.ArrayList;
import java.util.HashMap;

import javax.enterprise.context.ApplicationScoped;

import com.redhat.training.books.Book;
import com.redhat.training.books.BookNotAvailableException;
import com.redhat.training.inventory.Inventory;


@ApplicationScoped
public class Library {

    private final Inventory inventory;
    private final LoanRegistry loans = new LoanRegistry();

    public Library(Inventory inventory) {
        this.inventory = inventory;
    }

    public Book checkOut(String studentId, String isbn) throws BookNotAvailableException {
        if (!inventory.isBookAvailable(isbn)) {
            throw new BookNotAvailableException(isbn);
        }

        Book book = inventory.withdraw(isbn);
        loans.markAsBorrowed(studentId, book);

        return book;
    }

    public double getAvailablityRate() {
        return 1 - ((double) loans.count() / inventory.count());
    }
}

class LoanRegistry {

    private final HashMap<String, ArrayList<Book>> loans = new HashMap<>();

    public void markAsBorrowed(String studentId, Book book) {
        if (!loans.containsKey(studentId)) {
            loans.put(studentId, new ArrayList<Book>());
        }
        loans.get(studentId).add(book);
    }

    public int count() {
        int count = 0;
        for (ArrayList<Book> studentLoans: loans.values()) {
            count += studentLoans.size();
        }
        return count;
    }
}
