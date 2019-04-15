package com.jaeeunna.command;

import com.jaeeunna.state.BowlingState;

public interface CommandHandler {
    String handle(CommandContext commandContext, BowlingState bowlingState);
}
