package me.lorinlee.ui.command.builder;

import me.lorinlee.ui.command.Command;
import me.lorinlee.ui.command.exception.NotConnected;
import me.lorinlee.ui.command.UserCommand;

/**
 * Created by lorin on 17-5-25.
 */
public class UserCommandBuilder extends CommandBuilder {
    @Override
    public Command build() {
        if (! requestSocket.isConnected()) return new NotConnected();

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
