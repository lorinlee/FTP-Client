package me.lorinlee.command.builder;

import me.lorinlee.command.Command;
import me.lorinlee.command.NotConnectedCommand;
import me.lorinlee.command.UserCommand;

/**
 * Created by lorin on 17-5-25.
 */
public class UserCommandBuilder extends CommandBuilder {
    @Override
    public Command build() {
        if (! requestSocket.isConnected()) return new NotConnectedCommand();

        Command command = null;
        if (cmdAndParam.length >= 2) {
            command = new UserCommand(cmdAndParam[1]);
        } else {
            System.out.print("(username) ");
            String userStr = commandManager.getCommandLine();
            if ("".equals(userStr)) {
                System.out.println("usage: user username");
            } else {
                String[] user = userStr.split(" ");
                command = new UserCommand(user[0]);
            }
        }
        return command;
    }
}
