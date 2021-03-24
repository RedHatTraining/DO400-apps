package com.redhat.training.home.automation.rules;

import java.util.List;

public class InMemoryRulesRepository implements RulesRepository {
    @Override
    public Iterable<Rule> getAll() {
        return List.of(new DaylightRule(), new PresenceRule());
    }
}
