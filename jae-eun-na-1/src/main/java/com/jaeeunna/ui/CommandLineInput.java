package com.jaeeunna.ui;

import com.jaeeunna.command.Command;


import java.io.InputStream;
import java.util.Scanner;

public class CommandLineInput implements Input {
    private Scanner sc;

    private CommandLineInput() {
    }

    public static Input of(final InputStream inputStream) {
        final CommandLineInput instance = new CommandLineInput();
        instance.sc = new Scanner(inputStream);

        return instance;
    }

    @Override
    public Command nextCommand() {
        return Command.of(sc.nextLine());
    }

    @Override
    public boolean hasNextCommand() {
        return sc.hasNext();
    }

    @Override
    public String nextArgument() {
        return sc.nextLine();
    }

    @Override
    public boolean hasNextArgument() {
        return sc.hasNext();
    }
}
