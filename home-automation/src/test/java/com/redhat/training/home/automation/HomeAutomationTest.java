package com.redhat.training.home.automation;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import com.redhat.training.home.automation.lights.Lights;
import com.redhat.training.home.automation.lights.FakeConsoleLights;
import com.redhat.training.home.automation.rules.InMemoryRulesRepository;
import com.redhat.training.home.automation.rules.RulesRepository;


public class HomeAutomationTest {

    Lights lights;
    HomeAutomation home;
    RulesRepository rulesRepository;

    @BeforeEach
    public void setUp() {
        lights = new FakeConsoleLights();
        rulesRepository = new InMemoryRulesRepository();
        home = new HomeAutomation(lights, rulesRepository);
    }

    @Test
    public void switchOffLightsUnderEnoughDaylight() {
        home.processConditions(new RoomConditions(0.2, true));

        assertFalse(lights.areOn());
    }

    @Test
    public void switchOnLightsUnderLowDaylight() {
        home.processConditions(new RoomConditions(0.19, true));

        assertTrue(lights.areOn());
    }

    @Test
    public void lightsShouldTransitionToOff() {
        lights.switchOn();

        home.processConditions(new RoomConditions(0.3, true));

        assertFalse(lights.areOn());
    }

    @Test
    public void switchOffLightsAtNightIfNotPresenceDetected() {
        home.processConditions(new RoomConditions(0.1, false));

        assertFalse(lights.areOn());
    }

}