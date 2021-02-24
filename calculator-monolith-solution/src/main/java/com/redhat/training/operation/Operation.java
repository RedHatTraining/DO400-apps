package com.redhat.training.operation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.inject.Inject;

import com.redhat.training.service.SolverService;

public abstract class Operation {

    @Inject
    protected SolverService solverService;

    private final Pattern pattern;
    private final BinaryOperator<Float> operator;

    public Operation(final String regex, final BinaryOperator<Float> binaryOperator) {
        this.pattern = Pattern.compile(regex);
        this.operator = binaryOperator;
    }

    public Float apply(final String equation) {
        return solveGroups(equation).stream().reduce(operator).orElse(null);
    };

    private List<Float> solveGroups(final String equation) {
        Matcher matcher = pattern.matcher(equation);
        if (matcher.matches()) {
            List<Float> result = new ArrayList<>(matcher.groupCount());
            for (int groupNum = 1; groupNum <= matcher.groupCount(); groupNum++) {
                result.add(solve(matcher.group(groupNum)));
            }
            return result;
        } else {
            return Collections.emptyList();
        }
    }

    private Float solve(final String equation) {
        return solverService.solve(equation);
    }

}
