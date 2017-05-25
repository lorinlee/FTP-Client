package me.lorinlee.command.builder;

import me.lorinlee.command.CdCommand;
import me.lorinlee.command.Command;
import me.lorinlee.command.CommandManager;
import me.lorinlee.command.NotConnectedCommand;

/**
 * Created by lorin on 17-5-25.
 */
public class CdCommandBuilder extends CommandBuilder {
    @Override
    public Command build() {
        if (! requestSocket.isConnected()) return new NotConnectedCommand();

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
