package com.redhat.training;

public class BookNotAvailableException extends Exception {

    private static final long serialVersionUID = -5692072907291015767L;

    BookNotAvailableException( String bookId ) {
        super("Book " + bookId + " is not available");
    }

}
