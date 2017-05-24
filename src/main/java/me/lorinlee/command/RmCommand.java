package me.lorinlee.command;

import me.lorinlee.request.DeleRequest;

/**
 * Created by lorin on 17-5-23.
 */
public class RmCommand extends Command {

    private String filename;

    public RmCommand(String filename) {
        this.filename = filename;
    }

    @Override
    public void run() {
        requestSocket.sendRequest(new DeleRequest(filename));
    }
}
