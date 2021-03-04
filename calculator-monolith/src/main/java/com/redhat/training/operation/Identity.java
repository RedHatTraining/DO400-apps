package com.redhat.training.operation;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public final class Identity implements Operation {

    @Override
    public Float apply(final String equation) {
        try {
            return Float.valueOf(equation);
        } catch (final NumberFormatException e) {
            return null;
        }
    }

}
