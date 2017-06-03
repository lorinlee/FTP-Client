package me.lorinlee.ui.command.builder;

import me.lorinlee.ui.command.BinCommand;
import me.lorinlee.ui.command.Command;
import me.lorinlee.ui.command.exception.NotConnected;

/**
 * Created by lorin on 17-5-25.
 */
public class BinCommandBuilder extends CommandBuilder {
    @Override
    public Command build() {
        if (! requestSocket.isConnected()) return new NotConnected();
        return new BinCommand();
    }
}
