package me.lorinlee.command.builder;

import me.lorinlee.command.ByeCommand;
import me.lorinlee.command.Command;

/**
 * Created by lorin on 17-5-25.
 */
public class ByeCommandBuilder extends CommandBuilder {
    @Override
    public Command build() {
        return new ByeCommand();
    }
}
