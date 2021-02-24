package com.redhat.training;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.PathParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import com.redhat.training.operation.Add;
import com.redhat.training.operation.Multiply;
import com.redhat.training.operation.Operation;
import com.redhat.training.operation.Substract;
import com.redhat.training.service.SolverService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class SolverResource implements SolverService {
    private static final Logger LOG = LoggerFactory.getLogger(SolverResource.class);

    @Inject
    Add add;

    @Inject
    Substract substract;

    @Inject
    Multiply multiply;

    @Override
    public Float solve(@PathParam("equation") final String equation) {
        try {
            return solveValue(equation);
        } catch (final NumberFormatException e) {
            return solveOperation(equation);
        }
    }

    private Float solveValue(final String equation) {
        return Float.valueOf(equation);
    }

    private Float solveOperation(final String equation) {
        LOG.info("Solving '{}'", equation);
        List<Operation> values = List.of(substract, add, multiply);
        for (Operation operation : values) {
            Float result = operation.apply(equation);
            if (result != null) {
                LOG.info("Solved '{} = {}'", equation, result);
                return result;
            }
        }

        throw new WebApplicationException(
                Response.status(Response.Status.BAD_REQUEST).entity("Unable to parse: " + equation).build());
    }

}
