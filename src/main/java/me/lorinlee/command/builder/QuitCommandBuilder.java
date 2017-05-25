package me.lorinlee.command.builder;

import me.lorinlee.command.CloseCommand;
import me.lorinlee.command.Command;
import me.lorinlee.command.QuitCommand;

/**
 * Created by lorin on 17-5-25.
 */
public class QuitCommandBuilder extends CommandBuilder {
    @Override
    public Command build() {
        return new QuitCommand();
    }
}
