package com.jaeeunna.command;

import com.jaeeunna.ui.Input;

public class CommandContextParser {
    private Input input;

    private CommandContextParser() {
    }

    public static CommandContextParser of(final Input input) {
        final CommandContextParser instance = new CommandContextParser();
        instance.input = input;

        return instance;
    }

    public CommandContext next() {
        return CommandContext.builder().command(Command.SHOW).build();
    }
}
