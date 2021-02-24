package com.redhat.training;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.inject.Inject;

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
    public void solve_composed() {
        assertEquals(solverService.solve("20-5*3+3"), 8);
    }

    @Test
    public void solve_composed_multiplication_priority() {
        assertEquals(solverService.solve("5*3+3"), 18);
    }

}
