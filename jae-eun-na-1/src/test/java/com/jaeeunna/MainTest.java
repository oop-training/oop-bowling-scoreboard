package com.jaeeunna;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Program should handle")
class MainTest {
    @Nested
    @DisplayName("init command")
    class InitCommand {
        @Test
        @DisplayName("when clean start")
        void init_command_clean_start() {
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

    @Nested
    @DisplayName("show command")
    class ShowCommand {
        @Test
        @DisplayName("when nothing to show")
        void show_command() {
            // given
            final String userInputLine = "show\n";
            final OutputStream out = new ByteArrayOutputStream();
            System.setIn(new ByteArrayInputStream(userInputLine.getBytes()));
            System.setOut(new PrintStream(out));

            // when
            Main.main(null);

            // then
            final String expected = "----> [ERROR] nothing to show";
            assertThat(out).asString().isEqualTo(expected);
        }
    }

    @Test
    @DisplayName("unknown command")
    void unknownCommand() {
        // given
        final String userInputLine = "something_unknown_command\n";
        final OutputStream out = new ByteArrayOutputStream();
        System.setIn(new ByteArrayInputStream(userInputLine.getBytes()));
        System.setOut(new PrintStream(out));

        // when
        Main.main(null);

        // then
        final String expected = "----> [ERROR] unknown command";
        assertThat(out).asString().isEqualTo(expected);
    }
}