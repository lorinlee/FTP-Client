package me.lorinlee.ui.command;

import me.lorinlee.request.RmdRequest;

/**
 * Created by lorin on 17-5-23.
 */
public class RmCommand extends Command {

    private String dir;

    public RmCommand(String dir) {
        this.dir = dir;
    }

    @Override
    public void execute() {
        requestSocket.sendRequest(new RmdRequest(dir));
    }
}
