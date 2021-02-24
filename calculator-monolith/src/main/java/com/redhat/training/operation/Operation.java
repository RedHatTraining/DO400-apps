package com.redhat.training.operation;

import java.util.function.Function;

import javax.inject.Inject;

import com.redhat.training.service.SolverService;

public abstract class Operation implements Function<String, Float> {

    @Inject
    protected SolverService solverService;

    /**
     * Solves the equation passed by sending it to the solver service.
     * Do not overwrite unless the operation requires a different way
     * of solving equations.
     * @param equation
     * @return The result of the operation
     */
    protected Float solve(final String equation) {
        return solverService.solve(equation);
    }

    public abstract boolean appliesTo(String equation);
}
