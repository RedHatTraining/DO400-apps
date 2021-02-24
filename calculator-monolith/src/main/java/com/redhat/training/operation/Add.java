package com.redhat.training.operation;

import java.util.regex.Matcher;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public final class Add extends MatcherOperation {

    public Add() {
        super("(.+)\\+(.+)");
    }

    @Override
    public Float apply(final String equation) {
        Matcher matcher = getMatcher(equation);
        if (matcher.matches()) {
            return solve(matcher.group(1)) + solve(matcher.group(2));
        }
        return null;
    }

    @Override
    public boolean appliesTo(final String equation) {
        return getMatcher(equation).matches();
    }
}
