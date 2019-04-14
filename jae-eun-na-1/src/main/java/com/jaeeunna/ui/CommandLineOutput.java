package com.jaeeunna.ui;

public class CommandLineOutput implements Output {
    @Override
    public void print(final String value) {
        System.out.println(value);
    }
}
