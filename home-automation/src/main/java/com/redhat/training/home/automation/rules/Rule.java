package com.redhat.training.home.automation.rules;

import com.redhat.training.home.automation.RoomConditions;

public abstract class Rule {
    public abstract boolean meets(RoomConditions conditions);
}
