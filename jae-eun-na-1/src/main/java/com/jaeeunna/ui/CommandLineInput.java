package com.jaeeunna.ui;

import com.jaeeunna.command.Command;


import java.util.Scanner;

public class CommandLineInput implements Input {
    private final Scanner sc = new Scanner(System.in);

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
