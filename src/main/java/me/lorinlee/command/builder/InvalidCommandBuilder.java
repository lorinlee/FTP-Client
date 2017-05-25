package me.lorinlee.command.builder;

import me.lorinlee.command.Command;
import me.lorinlee.command.InvalidCommand;

/**
 * Created by lorin on 17-5-25.
 */
public class InvalidCommandBuilder extends CommandBuilder {
    @Override
    public Command build() {
        return new InvalidCommand();
    }
}
