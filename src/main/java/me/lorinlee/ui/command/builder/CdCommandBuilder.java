package me.lorinlee.ui.command.builder;

import me.lorinlee.ui.command.CdCommand;
import me.lorinlee.ui.command.Command;
import me.lorinlee.ui.command.exception.NotConnected;

/**
 * Created by lorin on 17-5-25.
 */
public class CdCommandBuilder extends CommandBuilder {
    @Override
    public Command build() {
        if (! requestSocket.isConnected()) return new NotConnected();

        Command command = null;
        if (cmdAndParam.length >= 2) {
            command = new CdCommand(cmdAndParam[1]);
        } else {
            System.out.print("(remote-directory) ");
            String srcAndDestDirStr = commandManager.getCommandLine();
            if ("".equals(srcAndDestDirStr)) {
                System.out.println("usage: cd remote-directory");
            } else {
                String[] srcAndDestDir = srcAndDestDirStr.split(" ");
                command = new CdCommand(srcAndDestDir[0]);
            }
        }
        return command;
    }
}
