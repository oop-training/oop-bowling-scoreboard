package com.jaeeunna.command;

import lombok.RequiredArgsConstructor;

import java.io.InputStream;
import java.util.Objects;
import java.util.Scanner;

@RequiredArgsConstructor
public class CommandProcessor {
    private final InputStream in;

    public void start() {
        if (Objects.isNull(in)) {
            throw new IllegalStateException();
        }

        start(in);
    }

    private void start(final InputStream in) {
        Scanner sc = new Scanner(in);

        while (sc.hasNext()) {
            final Command command = Command.of(sc.nextLine());

            switch (command) {
                case INIT: {
                    System.out.println("----> Input player names, when you finished, input \"@DONE\"\n" +
                            "----> Now, Game Start.\n" +
                            "----> Frame 1.");

                    while (sc.hasNext()) {
                        String player = sc.nextLine();
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
