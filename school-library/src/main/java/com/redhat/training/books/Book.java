package com.redhat.training.books;

public class Book {

    public String isbn;
    public String text;

    public Book(String isbn) {
        this.isbn = isbn;
        text = "";
    }

    public Book(String isbn, String text) {
        this.isbn = isbn;
        this.text = text;
    }

}
