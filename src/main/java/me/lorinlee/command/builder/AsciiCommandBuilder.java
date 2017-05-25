package me.lorinlee.command.builder;

import me.lorinlee.command.AsciiCommand;
import me.lorinlee.command.Command;
import me.lorinlee.command.NotConnectedCommand;

/**
 * Created by lorin on 17-5-25.
 */
public class AsciiCommandBuilder extends CommandBuilder {
    @Override
    public Command build() {
        if (! requestSocket.isConnected()) return new NotConnectedCommand();
        return new AsciiCommand();
    }
}
