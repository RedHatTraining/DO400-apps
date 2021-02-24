package com.redhat.training.operation;

import java.util.function.BinaryOperator;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public final class Substract extends Operation {
    private static final String REGEX = "(.+)\\-(.+)";
    private static final BinaryOperator<Float> OPERATOR = (lhs, rhs) -> lhs - rhs;

    public Substract() {
        super(REGEX, OPERATOR);
    }

}
