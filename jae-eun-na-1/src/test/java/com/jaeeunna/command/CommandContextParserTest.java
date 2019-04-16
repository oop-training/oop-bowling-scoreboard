package com.jaeeunna.command;

import com.jaeeunna.ui.CommandLineInput;
import com.jaeeunna.ui.Input;
import org.junit.jupiter.api.Test;

import static com.jaeeunna.command.Command.SHOW;
import static com.jaeeunna.util.InputOutputUtils.mockStandardInputOutputStream;
import static org.assertj.core.api.Assertions.assertThat;

public class CommandContextParserTest {
    @Test
    void parsing_command_alone() {
        final String userInputLine = "show\n";
        mockStandardInputOutputStream(userInputLine);

        final Input input = CommandLineInput.of(System.in);
        final CommandContextParser parser = CommandContextParser.of(input);

        final CommandContext context = parser.next();
        final CommandContext expected = CommandContext.builder().command(SHOW).build();

        assertThat(context).isEqualToIgnoringNullFields(expected);
    }
}
