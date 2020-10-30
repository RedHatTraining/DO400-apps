package com.redhat.training.home.automation.rules;

import java.util.Arrays;

public class InMemoryRulesRepository implements RulesRepository {
    @Override
    public Iterable<Rule> getAll() {
        return Arrays.asList(new DaylightRule(), new PresenceRule());
    }
}
