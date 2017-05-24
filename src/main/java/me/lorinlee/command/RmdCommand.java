package me.lorinlee.command;

import me.lorinlee.request.RmdRequest;

/**
 * Created by lorin on 17-5-23.
 */
public class RmdCommand extends Command {

    private String dir;

    public RmdCommand(String dir) {
        this.dir = dir;
    }

    @Override
    public void run() {
        requestSocket.sendRequest(new RmdRequest(dir));
    }
}
