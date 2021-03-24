package com.redhat.training;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import javax.inject.Inject;
import javax.ws.rs.WebApplicationException;

import com.redhat.training.service.SolverService;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
@Tag("unit")
public class SolverTest {
    @Inject
    SolverService solverService;

    @Test
    public void solve_number() {
        assertEquals(solverService.solve("5"), 5);
    }

    @Test
    public void solve_add() {
        assertEquals(solverService.solve("5+3"), 8);
    }

    @Test
    public void solve_substract() {
        assertEquals(solverService.solve("5-3"), 2);
    }

    @Test
    public void solve_multiply() {
        assertEquals(solverService.solve("5*3"), 15);
    }

    @Test
    public void solve_composition() {
        assertEquals(solverService.solve("20+5+3+2"), 30);
    }

    @Test
    public void solve_addition_overprioritize_substraction() {
        assertEquals(solverService.solve("20-5+3+2"), 10);
    }

    @Test
    public void solve_multiplication_overprioritize_addition() {
        assertEquals(solverService.solve("10-5*3+2"), -7);
    }

    @Test
    public void solve_error() {
        assertThrows(WebApplicationException.class, () -> solverService.solve("5+"));
    }
}
