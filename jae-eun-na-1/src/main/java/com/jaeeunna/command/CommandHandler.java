package com.jaeeunna.command;

import com.jaeeunna.state.BowlingContext;

public interface CommandHandler {
    String handle(CommandContext commandContext, BowlingContext bowlingContext);
}
