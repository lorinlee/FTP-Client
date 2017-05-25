package me.lorinlee.command.builder;

import me.lorinlee.command.Command;
import me.lorinlee.command.CommandManager;
import me.lorinlee.command.MkdirCommand;
import me.lorinlee.command.NotConnectedCommand;

/**
 * Created by lorin on 17-5-25.
 */
public class MkdirCommandBuilder extends CommandBuilder {
    @Override
    public Command build() {
        if (! requestSocket.isConnected()) return new NotConnectedCommand();

        Command command = null;
        if (cmdAndParam.length >= 2) {
            command = new MkdirCommand(cmdAndParam[1]);
        } else {
            System.out.print("(directory-name) ");
            String destDirStr = commandManager.getCommandLine();

            if ("".equals(destDirStr)) {
                System.out.println("usage: mkdir directory-name");
            } else {
                String[] destDir = destDirStr.split(" ");
                command = new MkdirCommand(destDir[0]);
            }
        }
        return command;
    }
}
