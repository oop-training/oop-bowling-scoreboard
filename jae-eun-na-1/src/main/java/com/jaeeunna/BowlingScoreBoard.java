package com.jaeeunna;

import com.jaeeunna.command.CommandProcessor;

public class BowlingScoreBoard {
    public static void main(String[] args) {
        new CommandProcessor(System.in).start();
    }
}
