package com.redhat.training.operation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public final class Identity implements Operation {

    public Identity() {
        super();
    }

    @Override
    public Float apply(final String equation) {
        try {
            return Float.valueOf(equation);
        } catch (final NumberFormatException e) {
            return null;
        }
    }

}
