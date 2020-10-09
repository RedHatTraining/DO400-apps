package com.redhat.training;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.redhat.training.inventory.Inventory;

// import javax.enterprise.context.control.ActivateRequestContext;
// import javax.inject.Inject;

// import io.quarkus.runtime.Quarkus;
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
        inventory.add("book1", 10);
        library.checkOut("student1" , "book1");
        System.out.println(library.getAvailablityRate() * 100 + "% of the library books are available");

        return 0;
    }
}
