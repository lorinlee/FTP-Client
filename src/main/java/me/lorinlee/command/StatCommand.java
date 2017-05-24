package me.lorinlee.command;

import me.lorinlee.request.StatRequest;

/**
 * Created by lorin on 17-5-23.
 */
public class StatCommand extends Command {

    private String dir = ".";

    public StatCommand(String dir) {
        this.dir = dir;
    }

    public StatCommand() {
    }

    @Override
    public void run() {
        requestSocket.sendRequest(new StatRequest(dir));
    }
}
