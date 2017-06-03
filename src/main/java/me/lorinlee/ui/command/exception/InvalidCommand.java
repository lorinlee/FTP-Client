package me.lorinlee.ui.command.exception;

import me.lorinlee.ui.command.Command;

/**
 * Created by lorin on 17-5-25.
 */
public class InvalidCommand extends Command {
    @Override
    public void execute() {
        System.out.println("?Invalid command");
    }
}
