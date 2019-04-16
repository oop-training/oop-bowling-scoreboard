package com.jaeeunna.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

public class InputOutputUtils {
    public static OutputStream mockStandardInputOutputStream(String input) {
        final OutputStream out = new ByteArrayOutputStream();

        System.setIn(new ByteArrayInputStream(input.getBytes()));
        System.setOut(new PrintStream(out));

        return out;
    }
}
