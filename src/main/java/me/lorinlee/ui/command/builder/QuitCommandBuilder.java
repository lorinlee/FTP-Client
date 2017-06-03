package me.lorinlee.ui.command.builder;

import me.lorinlee.ui.command.Command;
import me.lorinlee.ui.command.QuitCommand;

/**
 * Created by lorin on 17-5-25.
 */
public class QuitCommandBuilder extends CommandBuilder {
    @Override
    public Command build() {
        return new QuitCommand();
    }
}
