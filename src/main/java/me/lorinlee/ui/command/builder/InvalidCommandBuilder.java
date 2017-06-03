package me.lorinlee.ui.command.builder;

import me.lorinlee.ui.command.Command;
import me.lorinlee.ui.command.exception.InvalidCommand;

/**
 * Created by lorin on 17-5-25.
 */
public class InvalidCommandBuilder extends CommandBuilder {
    @Override
    public Command build() {
        return new InvalidCommand();
    }
}
