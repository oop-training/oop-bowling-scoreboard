package com.jaeeunna.ui;

import java.io.OutputStream;
import java.io.PrintStream;

public class CommandLineOutput implements Output {
    private PrintStream out;

    private CommandLineOutput() {
    }

    public static CommandLineOutput of(final OutputStream printStream) {
        final CommandLineOutput instance = new CommandLineOutput();
        instance.out = new PrintStream(printStream);

        return instance;
    }

    @Override
    public void print(final String value) {
        out.print(value);
    }

    @Override
    public void println(final String value) {
        out.println(value);
    }
}
