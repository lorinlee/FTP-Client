package me.lorinlee.ui.command.builder;

import me.lorinlee.ui.command.Command;
import me.lorinlee.ui.command.LsCommand;
import me.lorinlee.ui.command.exception.NotConnected;

/**
 * Created by lorin on 17-5-25.
 */
public class LsCommandBuilder extends CommandBuilder {
    @Override
    public Command build() {
        if (! requestSocket.isConnected()) return new NotConnected();

        Command command = null;
        if (cmdAndParam.length >= 2) {
            command = new LsCommand(cmdAndParam[1]);
        } else {
            command = new LsCommand();
        }

        return command;
    }
}
