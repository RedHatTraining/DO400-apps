package com.redhat.training.home.automation;

import javax.enterprise.context.ApplicationScoped;
import com.redhat.training.home.automation.lights.Lights;
import com.redhat.training.home.automation.rules.Rule;
import com.redhat.training.home.automation.rules.RulesRepository;

@ApplicationScoped
class HomeAutomation {

    private final Lights lights;
    private final RulesRepository rulesRepository;

    public HomeAutomation(Lights lights, RulesRepository rulesRepository) {
        this.lights = lights;
        this.rulesRepository = rulesRepository;
    }

    public void processConditions(RoomConditions conditions) {
        Iterable<Rule> rules = rulesRepository.getAll();

        for (Rule rule : rules) {
            if (!rule.passes(conditions)) {
                lights.switchOff();
                return;
            }
        }

        lights.switchOn();
    }

}