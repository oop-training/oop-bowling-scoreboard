package com.jaeeunna.ui;

import com.jaeeunna.command.Command;

public interface Input {
    Command nextCommand();

    boolean hasNextCommand();

    String nextArgument();

    boolean hasNextArgument();
}
