package me.lorinlee.command;

import me.lorinlee.request.CwdRequest;

/**
 * Created by lorin on 17-5-23.
 */
public class CdCommand extends Command {

    private String path;

    public CdCommand(String path) {
        this.path = path;
    }

    public CdCommand() {

    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public void run() {
        requestSocket.sendRequest(new CwdRequest(path));
    }
}
