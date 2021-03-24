package com.redhat.training.home.automation;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import com.redhat.training.home.automation.lights.LightSystem;
import com.redhat.training.home.automation.lights.ConsoleLightSystem;
import com.redhat.training.home.automation.rules.InMemoryRulesRepository;
import com.redhat.training.home.automation.rules.RulesRepository;

public class HomeAutomationTest {
    LightSystem light;
    HomeAutomation home;
    RulesRepository rulesRepository;

    @BeforeEach
    public void setUp() {
        light = new ConsoleLightSystem();
        rulesRepository = new InMemoryRulesRepository();
        home = new HomeAutomation(light, rulesRepository);
    }

    @Test
    public void switchOffLightsUnderEnoughDaylight() {
        home.processConditions(new RoomConditions(0.20, true));

        assertFalse(light.isOn());
    }

    @Test
    public void switchOnLightsUnderLowDaylight() {
        home.processConditions(new RoomConditions(0.19, true));

        assertTrue(light.isOn());
    }

    @Test
    public void transitionToLightsOnUnderEnoughDaylight() {
        light.switchOn();

        home.processConditions(new RoomConditions(0.30, true));

        assertFalse(light.isOn());
    }

    @Test
    public void switchOffLightsAtNightIfNoPresenceDetected() {
        home.processConditions(new RoomConditions(0.1, false));

        assertFalse(light.isOn());
    }
}
