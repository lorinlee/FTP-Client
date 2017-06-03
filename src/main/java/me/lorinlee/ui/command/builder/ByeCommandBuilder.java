package me.lorinlee.ui.command.builder;

import me.lorinlee.ui.command.ByeCommand;
import me.lorinlee.ui.command.Command;

/**
 * Created by lorin on 17-5-25.
 */
public class ByeCommandBuilder extends CommandBuilder {
    @Override
    public Command build() {
        return new ByeCommand();
    }
}
