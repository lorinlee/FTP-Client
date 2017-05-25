package me.lorinlee.command;

/**
 * Created by lorin on 17-5-25.
 */
public class InvalidCommand extends Command {
    @Override
    public void run() {
        System.out.println("?Invalid command");
    }
}
