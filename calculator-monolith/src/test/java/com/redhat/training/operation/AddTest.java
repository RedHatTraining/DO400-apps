package com.redhat.training.operation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import javax.inject.Inject;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
@Tag("unit")
public class AddTest {

    @Inject
    Add add;

    @Test
    public void simple_addition() {
        assertEquals(add.apply("4+5"),9);
    }

    @Test
    public void unparseable_operation() {
        assertNull(add.apply("4*5"));
    }

}
