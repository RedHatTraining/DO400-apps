package com.redhat.training.operation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class MatcherOperation extends Operation {
    private final Pattern pattern;

    /**
     * Returns the associated matcher for the operation.
     * The matcher is created based on the regular expression
     * provided during construction and the equation.
     * @param equation
     * @return The matcher for the provided equation.
     */
    protected Matcher getMatcher(final String equation) {
        return pattern.matcher(equation);
    }

    public MatcherOperation(final String regex) {
        this.pattern = Pattern.compile(regex);
    }

}
