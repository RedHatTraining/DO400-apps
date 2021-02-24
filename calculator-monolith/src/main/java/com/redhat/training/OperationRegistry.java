package com.redhat.training;

import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.redhat.training.operation.Add;
import com.redhat.training.operation.Multiply;
import com.redhat.training.operation.Operation;
import com.redhat.training.operation.Substract;

@ApplicationScoped
public final class OperationRegistry {

    @Inject
    Add add;

    @Inject
    Multiply multiply;

    @Inject
    Substract substract;

    private List<Operation> values;

    @PostConstruct
    public void init() {
        values = Collections.unmodifiableList(
            List.of(add, substract, multiply));
    }

    public List<Operation> getValues() {
        return values;
    };

}
