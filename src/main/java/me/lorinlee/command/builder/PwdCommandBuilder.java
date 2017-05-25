package me.lorinlee.command.builder;

import me.lorinlee.command.Command;
import me.lorinlee.command.NotConnectedCommand;
import me.lorinlee.command.PwdCommand;

/**
 * Created by lorin on 17-5-25.
 */
public class PwdCommandBuilder extends CommandBuilder {
    @Override
    public Command build() {
        if (! requestSocket.isConnected()) return new NotConnectedCommand();
        return new PwdCommand();
    }
}
