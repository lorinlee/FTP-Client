package me.lorinlee.ui.command.exception;

import me.lorinlee.ui.command.Command;

/**
 * Created by lorin on 17-5-25.
 */
public class AlreadyConnected extends Command {
    @Override
    public void execute() {
        System.out.println("Already connected to " + requestSocket.getHost() + ", use close first.");
    }
}
