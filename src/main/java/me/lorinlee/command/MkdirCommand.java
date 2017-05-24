package me.lorinlee.command;

import me.lorinlee.request.MkdRequest;

/**
 * Created by lorin on 17-5-23.
 */
public class MkdirCommand extends Command {

    private String dir;

    public MkdirCommand(String dir) {
        this.dir = dir;
    }

    @Override
    public void run() {
        requestSocket.sendRequest(new MkdRequest(dir));
    }
}
