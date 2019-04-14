package com.jaeeunna;

import com.jaeeunna.command.CommandProcessor;
import com.jaeeunna.ui.CommandLineInput;

public class BowlingScoreBoard {
    public static void main(String[] args) {
        new CommandProcessor().start(new CommandLineInput());
    }
}
