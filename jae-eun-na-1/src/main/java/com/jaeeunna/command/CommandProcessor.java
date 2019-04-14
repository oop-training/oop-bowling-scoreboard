package com.jaeeunna.command;

import com.jaeeunna.ui.Input;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CommandProcessor {
    public void start(Input input) {
        while (input.hasNextCommand()) {
            final Command command = input.nextCommand();

            switch (command) {
                case INIT: {
                    System.out.println("----> Input player names, when you finished, input \"@DONE\"\n" +
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
                    System.out.println("----> [ERROR] nothing to show");
                    break;
                }
                case UNKNOWN: {
                    System.out.println("----> [ERROR] unknown command");
                    break;
                }
                default: {
                    throw new RuntimeException("should not reach here");
                }
            }
        }
    }
}
