package me.lorinlee.command.builder;

import me.lorinlee.command.Command;
import me.lorinlee.command.NotConnectedCommand;
import me.lorinlee.command.PutCommand;

/**
 * Created by lorin on 17-5-25.
 */
public class PutCommandBuilder extends CommandBuilder {
    @Override
    public Command build() {
        if (! requestSocket.isConnected()) return new NotConnectedCommand();

        Command command = null;
        if (cmdAndParam.length >= 3) {
            command = new PutCommand(cmdAndParam[1], cmdAndParam[2]);
        } else if (cmdAndParam.length == 2) {
            command = new PutCommand(cmdAndParam[1]);
        } else {
            System.out.print("(local-file) ");
            String srcAndDestFileStr = commandManager.getCommandLine();
            if ("".equals(srcAndDestFileStr)) {
                System.out.println("usage: get local-file [ remote-file ]");
            } else {
                String[] srcAndDestFile = srcAndDestFileStr.split(" ");
                if (srcAndDestFile.length >= 2) {
                    command = new PutCommand(srcAndDestFile[0], srcAndDestFile[1]);
                } else {
                    command = new PutCommand(srcAndDestFile[0]);
                }
            }
        }
        return command;
    }
}
