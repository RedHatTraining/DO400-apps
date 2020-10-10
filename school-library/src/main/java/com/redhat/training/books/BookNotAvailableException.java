package com.redhat.training.books;

public class BookNotAvailableException extends Exception {

    private static final long serialVersionUID = -5692072907291015767L;

    public BookNotAvailableException(String bookId) {
        super("Book " + bookId + " is not available");
    }

}
