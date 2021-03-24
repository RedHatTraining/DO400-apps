package com.redhat.training.operation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import javax.inject.Inject;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
@Tag("unit")
public class MultiplyTest {

    @Inject
    Multiply multiply;

    @Test
    public void simple_multiplication() {
        assertEquals(multiply.apply("4*5"),20);
    }

    @Test
    public void unparseable_operation() {
        assertNull(multiply.apply("4-5"));
    }
}
