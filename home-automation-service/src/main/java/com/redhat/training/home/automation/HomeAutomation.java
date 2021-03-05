package com.redhat.training.home.automation;

import javax.enterprise.context.ApplicationScoped;

import com.redhat.training.home.automation.lights.LightSystem;
import com.redhat.training.home.automation.rules.Rule;
import com.redhat.training.home.automation.rules.RulesRepository;

@ApplicationScoped
class HomeAutomation {
    private LightSystem lightSystem;
    private RulesRepository rulesRepository;

    public HomeAutomation(LightSystem lightSystem, RulesRepository rulesRepository) {
        this.lightSystem = lightSystem;
        this.rulesRepository = rulesRepository;
    }

    public void processConditions(RoomConditions conditions) {
        Iterable<Rule> rules = rulesRepository.getAll();

        for (Rule rule : rules) {
            if (!rule.meets(conditions)) {
                lightSystem.switchOff();
                return;
            }
        }

        lightSystem.switchOn();
    }
}
