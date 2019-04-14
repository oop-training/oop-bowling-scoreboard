package com.jaeeunna;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Program should handle")
class MainTest {

    @Test
    @DisplayName("init command")
    void init_command() {
        // given
        final String userInputLine = "init\n" +
                "JaeEun\n" +
                "Gil-dong\n" +
                "Computer\n" +
                "@DONE\n";
        final OutputStream out = new ByteArrayOutputStream();
        System.setIn(new ByteArrayInputStream(userInputLine.getBytes()));
        System.setOut(new PrintStream(out));

        // when
        Main.main(null);

        // then
        final String expected = "----> Input player names, when you finished, input \"@DONE\"\n" +
                "----> Now, Game Start.\n" +
                "----> Frame 1.\n";
        assertThat(out).asString().isEqualTo(expected);
    }
}