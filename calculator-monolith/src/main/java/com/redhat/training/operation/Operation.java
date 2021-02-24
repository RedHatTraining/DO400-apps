package com.redhat.training.operation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.inject.Inject;

import com.redhat.training.service.SolverService;

public abstract class Operation {


    public abstract Float apply(String equation);

}
