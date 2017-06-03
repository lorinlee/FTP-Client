package me.lorinlee.ui.command.builder;

import me.lorinlee.ui.command.Command;
import me.lorinlee.ui.command.exception.NotConnected;
import me.lorinlee.ui.command.StatCommand;

/**
 * Created by lorin on 17-5-25.
 */
public class StatCommandBuilder extends CommandBuilder {
    @Override
    public Command build() {
        if (! requestSocket.isConnected()) return new NotConnected();
        return new StatCommand();
    }
}
