package com.redhat.training.home.automation;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import com.redhat.training.home.automation.rules.PresenceRule;

public class PresenceRuleTest {

    @Test
    public void passesWhenThereIsPresenceDetected() {
        PresenceRule rule = new PresenceRule();

        RoomConditions conditions = new RoomConditions(0, true);
        conditions.presenceDetected = true;

        assertTrue(rule.passes(conditions));
    }


    @Test
    public void failsWhenThereIsPresenceDetected() {
        PresenceRule rule = new PresenceRule();

        RoomConditions conditions = new RoomConditions(0, false);

        assertFalse(rule.passes(conditions));
    }

}