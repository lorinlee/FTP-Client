package me.lorinlee.command.builder;

import me.lorinlee.command.Command;
import me.lorinlee.command.NotConnectedCommand;
import me.lorinlee.command.RmCommand;

/**
 * Created by lorin on 17-5-25.
 */
public class RmCommandBuilder extends CommandBuilder {
    @Override
    public Command build() {
        if (! requestSocket.isConnected()) return new NotConnectedCommand();

        Command command = null;
        if (cmdAndParam.length >= 2) {
            command = new RmCommand(cmdAndParam[1]);
        } else {
            System.out.print("(directory-name) ");
            String dirStr = commandManager.getCommandLine();

            if ("".equals(dirStr)) {
                System.out.println("usage: rm directory-name");
            } else {
                String[] dir = dirStr.split(" ");
                command = new RmCommand(dir[0]);
            }
        }
        return command;
    }
}
