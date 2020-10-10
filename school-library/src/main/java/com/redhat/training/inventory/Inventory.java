package com.redhat.training.inventory;

import com.redhat.training.books.Book;

public interface Inventory {
    void add(Book book);

    Book withdraw(String isbn);

    boolean isBookAvailable(String isbn);

    int count();
}
