package com.redhat.training;

import javax.inject.Inject;

// import javax.enterprise.context.control.ActivateRequestContext;
// import javax.inject.Inject;

// import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;

@QuarkusMain
public class SchoolLibraryApp implements QuarkusApplication {

    // @Inject
    // Library library;

    @Override
    public int run(String... args) throws Exception {
        // library.checkOut("student1" , "book1");
        
        return 0;
    }
}
