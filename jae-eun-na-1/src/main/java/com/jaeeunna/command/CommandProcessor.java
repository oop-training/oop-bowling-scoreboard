package com.jaeeunna.command;

import com.jaeeunna.ui.Input;
import com.jaeeunna.ui.Output;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CommandProcessor {
    public void start(Input input, Output output) {
        while (input.hasNextCommand()) {
            final Command command = input.nextCommand();

            switch (command) {
                case INIT: {
                    output.println("----> Input player names, when you finished, input \"@DONE\"\n" +
                            "----> Now, Game Start.\n" +
                            "----> Frame 1.");

                    while (input.hasNextArgument()) {
                        String player = input.nextArgument();
                        if (player.equalsIgnoreCase("@DONE")) {
                            break;
                        }
                    }
                    break;
                }
                case SHOW: {
                    output.println("----> [ERROR] nothing to show");
                    break;
                }
                case UNKNOWN: {
                    output.println("----> [ERROR] unknown command");
                    break;
                }
                default: {
                    throw new RuntimeException("should not reach here");
                }
            }
        }
    }
}
