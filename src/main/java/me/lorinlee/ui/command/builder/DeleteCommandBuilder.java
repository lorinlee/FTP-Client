package me.lorinlee.ui.command.builder;

import me.lorinlee.ui.command.Command;
import me.lorinlee.ui.command.DeleteCommand;
import me.lorinlee.ui.command.exception.NotConnected;

/**
 * Created by lorin on 17-5-25.
 */
public class DeleteCommandBuilder extends CommandBuilder {
    @Override
    public Command build() {
        if (! requestSocket.isConnected()) return new NotConnected();

        Command command = null;
        if (cmdAndParam.length >= 2) {
            command = new DeleteCommand(cmdAndParam[1]);
        } else {
            System.out.print("(remote-file) ");
            String fileStr = commandManager.getCommandLine();

            if ("".equals(fileStr)) {
                System.out.println("usage: delete remote-file");
            } else {
                String[] file = fileStr.split(" ");
                command = new DeleteCommand(file[0]);
            }
        }
        return command;
    }
}
