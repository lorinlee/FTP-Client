package me.lorinlee.command.builder;

import me.lorinlee.command.CloseCommand;
import me.lorinlee.command.Command;
import me.lorinlee.command.NotConnectedCommand;

/**
 * Created by lorin on 17-5-25.
 */
public class CloseCommandBuilder extends CommandBuilder {
    @Override
    public Command build() {
        if (! requestSocket.isConnected()) return new NotConnectedCommand();

        return new CloseCommand();
    }
}
