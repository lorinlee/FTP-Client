package me.lorinlee.command;

import me.lorinlee.request.DeleRequest;

/**
 * Created by lorin on 17-5-23.
 */
public class DeleteCommand extends Command {

    private String dir;

    public DeleteCommand(String dir) {
        this.dir = dir;
    }

    @Override
    public void run() {
        requestSocket.sendRequest(new DeleRequest(dir));
    }
}
