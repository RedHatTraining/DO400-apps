package com.redhat.training.inventory;

import java.util.ArrayList;
import java.util.HashMap;

import javax.enterprise.context.ApplicationScoped;

import com.redhat.training.books.Book;


@ApplicationScoped
public class InMemoryInventory implements Inventory {

    int totalCopies = 0;
    HashMap<String, ArrayList<Book>> books = new HashMap<>();

    @Override
    public void add(Book book) {
        if (!books.containsKey(book.isbn)) {
            books.put(book.isbn, new ArrayList<Book>());
        }
        books.get(book.isbn).add(book);
        totalCopies++;
    }

    @Override
    public Book withdraw(String bookId) {
        return books.get(bookId).remove(0);
    }

    @Override
    public boolean isBookAvailable(String isbn) {
        if (books.containsKey(isbn)) {
            return books.get(isbn).size() > 0;
        }

        return false;
    }

    @Override
    public int count() {
        return totalCopies;
    }

    public Integer countCopies(String isbn) {
        return books.get(isbn).size();
    }
}
