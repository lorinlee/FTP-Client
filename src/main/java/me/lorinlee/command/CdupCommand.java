package me.lorinlee.command;

import me.lorinlee.request.CdupRequest;

/**
 * Created by lorin on 17-5-23.
 */
public class CdupCommand extends Command {

    private String path;

    public CdupCommand(String path) {
        this.path = path;
    }

    @Override
    public void run() {
        requestSocket.sendRequest(new CdupRequest(path));
    }
}
