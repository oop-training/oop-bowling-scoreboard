package com.jaeeunna.command;

import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.Set;

@Getter
@Builder
public class CommandContext {
    private Command command;
    private Set<CommandOption> options;
    private List<CommandArgument> arguments;
}
