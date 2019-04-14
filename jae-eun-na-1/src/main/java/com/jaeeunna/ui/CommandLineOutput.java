package com.jaeeunna.ui;

public class CommandLineOutput implements Output {
    @Override
    public void print(final String value) {
        System.out.print(value);
    }

    @Override
    public void println(final String value) {
        System.out.println(value);
    }
}
