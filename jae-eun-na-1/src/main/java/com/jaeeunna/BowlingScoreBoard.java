package com.jaeeunna;

import com.jaeeunna.command.CommandProcessor;
import com.jaeeunna.ui.CommandLineInput;
import com.jaeeunna.ui.CommandLineOutput;

public class BowlingScoreBoard {
    public static void main(String[] args) {
        new CommandProcessor()
                .start(CommandLineInput.of(System.in), new CommandLineOutput());
    }
}
