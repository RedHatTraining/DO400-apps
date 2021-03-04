package com.redhat.training.operation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import javax.inject.Inject;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
@Tag("unit")
public class SubstractTest {

    @Inject
    Substract substract;

    @Test
    public void simple_substraction() {
        assertEquals(substract.apply("5-4"),1);
    }

    @Test
    public void unparseable_operation() {
        assertNull(substract.apply("4+5"));
    }

}
