package com.redhat.training;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.redhat.training.books.Book;
import com.redhat.training.inventory.Inventory;

import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;


@QuarkusMain
@ApplicationScoped
public class SchoolLibraryApp implements QuarkusApplication {

    @Inject
    Library library;

    @Inject
    Inventory inventory;

    @Override
    public int run(String... args) throws Exception {
        inventory.add(new Book("book1"));
        inventory.add(new Book("book1"));
        inventory.add(new Book("book1"));

        library.checkOut("student1" , "book1");
        System.out.println(library.getAvailablityRate() * 100 + "% of the library books are available");

        return 0;
    }
}
