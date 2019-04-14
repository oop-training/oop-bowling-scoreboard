package com.jaeeunna.command;

import lombok.ToString;

@ToString
public enum Command {
    INIT, SHOW, UNKNOWN;

    public static Command of(final String value) {
        try {
            return valueOf(value.trim().toUpperCase());
        } catch (IllegalArgumentException e) {

        }

        return UNKNOWN;
    }
}
