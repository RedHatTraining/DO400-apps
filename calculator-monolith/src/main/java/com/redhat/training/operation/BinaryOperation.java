package com.redhat.training.operation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.inject.Inject;

import com.redhat.training.service.SolverService;

public abstract class BinaryOperation implements Operation {

    private final BinaryOperator<Float> operator;
    private final String regex;

    public BinaryOperation(final BinaryOperator<Float> operatorParam, final String regexParam) {
        this.operator = operatorParam;
        this.regex = regexParam;
    }

    public Float apply(final String equation) {
        return solveGroups(equation).stream().reduce(operator).orElse(null);
    }

    private List<Float> solveGroups(final String equation) {
        Matcher matcher = Pattern.compile(regex).matcher(equation);
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

    @Inject
    SolverService solverService;

    private Float solve(final String equation) {
        return solverService.solve(equation);
    }
}
