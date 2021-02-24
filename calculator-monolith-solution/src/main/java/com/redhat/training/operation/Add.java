package com.redhat.training.operation;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public final class Add extends Operation {

    public Add() {
        super("(.+)\\+(.+)", Float::sum);
    }
}
