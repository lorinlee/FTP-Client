package me.lorinlee.ui.command.builder;

import me.lorinlee.ui.command.Command;
import me.lorinlee.ui.command.GetCommand;
import me.lorinlee.ui.command.exception.NotConnected;

/**
 * Created by lorin on 17-5-25.
 */
public class GetCommandBuilder extends CommandBuilder {
    @Override
    public Command build() {
        if (! requestSocket.isConnected()) return new NotConnected();

        Command command = null;
        if (cmdAndParam.length >= 3) {
            command = new GetCommand(cmdAndParam[1], cmdAndParam[2]);
        } else if (cmdAndParam.length == 2) {
            command = new GetCommand(cmdAndParam[1]);
        } else {
            System.out.print("(remote-file) ");
            String srcAndDestFileStr = commandManager.getCommandLine();
            if ("".equals(srcAndDestFileStr)) {
                System.out.println("usage: get remote-file [ local-file ]");
            } else {
                String[] srcAndDestFile = srcAndDestFileStr.split(" ");
                if (srcAndDestFile.length >= 2) {
                    command = new GetCommand(srcAndDestFile[0], srcAndDestFile[1]);
                } else {
                    command = new GetCommand(srcAndDestFile[0]);
                }
            }
        }
        return command;
    }
}
