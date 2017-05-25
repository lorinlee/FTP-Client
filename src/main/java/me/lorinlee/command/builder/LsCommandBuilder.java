package me.lorinlee.command.builder;

import me.lorinlee.command.Command;
import me.lorinlee.command.LsCommand;
import me.lorinlee.command.NotConnectedCommand;

/**
 * Created by lorin on 17-5-25.
 */
public class LsCommandBuilder extends CommandBuilder {
    @Override
    public Command build() {
        if (! requestSocket.isConnected()) return new NotConnectedCommand();

        Command command = null;
        if (cmdAndParam.length >= 2) {
            command = new LsCommand(cmdAndParam[1]);
        } else {
            command = new LsCommand();
        }

        return command;
    }
}
