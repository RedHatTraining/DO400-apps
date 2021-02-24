package com.redhat.training.operation;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public final class Multiply extends Operation {

    public Multiply() {
        super("(.+)\\*(.+)", (lhs, rhs) -> lhs * rhs);
    }

}
