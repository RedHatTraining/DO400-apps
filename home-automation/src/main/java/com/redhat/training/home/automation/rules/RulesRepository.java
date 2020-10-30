package com.redhat.training.home.automation.rules;

public interface RulesRepository {
    Iterable<Rule> getAll();
}
