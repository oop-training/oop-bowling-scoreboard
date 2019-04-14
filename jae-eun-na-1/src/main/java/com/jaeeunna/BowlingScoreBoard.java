package com.jaeeunna;

import java.util.Scanner;

public class BowlingScoreBoard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String line = sc.nextLine();

            switch (line) {
                case "init": {
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
                case "show": {
                    System.out.println("----> [ERROR] nothing to show");
                    break;
                }
                default: {
                    System.out.println("----> [ERROR] unknown command");
                    break;
                }
            }
        }
    }
}
