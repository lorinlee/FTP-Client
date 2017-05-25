package me.lorinlee.command;

/**
 * Created by lorin on 17-5-25.
 */
public class AlreadyConnectedCommand extends Command {
    @Override
    public void run() {
        System.out.println("Already connected to " + requestSocket.getHost() + ", use close first.");
    }
}
