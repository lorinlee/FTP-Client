package me.lorinlee.ui.command;

import me.lorinlee.request.CdupRequest;

/**
 * Created by lorin on 17-5-23.
 */
public class CdupCommand extends Command {

    private String path = "";

    public CdupCommand(String path) {
        this.path = path;
    }

    public CdupCommand() {

    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public void execute() {
        requestSocket.sendRequest(new CdupRequest(path));
    }
}
