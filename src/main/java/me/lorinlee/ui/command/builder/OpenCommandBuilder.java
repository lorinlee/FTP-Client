package me.lorinlee.ui.command.builder;

import me.lorinlee.ui.command.exception.AlreadyConnected;
import me.lorinlee.ui.command.Command;
import me.lorinlee.ui.command.OpenCommand;

/**
 * Created by lorin on 17-5-25.
 */
public class OpenCommandBuilder extends CommandBuilder {
    @Override
    public Command build() {
        if (requestSocket.isConnected()) return new AlreadyConnected();

        Command command = null;
        if (cmdAndParam.length >= 3) {
            command = new OpenCommand(cmdAndParam[1], Integer.parseInt(cmdAndParam[2]));
        } else if (cmdAndParam.length == 2) {
            command = new OpenCommand(cmdAndParam[1]);
        } else {
            System.out.print("(to) ");
            String hostAndPortStr = commandManager.getCommandLine();
            if ("".equals(hostAndPortStr)) {
                System.out.println();
            } else {
                String[] hostAndPort = hostAndPortStr.split(" ");
                if (hostAndPort.length >= 2) {
                    command = new OpenCommand(hostAndPort[0], Integer.parseInt(hostAndPort[1]));
                } else {
                    command = new OpenCommand(hostAndPort[0]);
                }
            }
        }

        return command;
    }
}
