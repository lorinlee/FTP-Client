package me.lorinlee.ui.command;

import me.lorinlee.request.MkdRequest;

/**
 * Created by lorin on 17-5-23.
 */
public class MkdirCommand extends Command {

    private String dir;

    public MkdirCommand() {
        this.dir = "";
    }

    public MkdirCommand(String dir) {
        this.dir = dir;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    @Override
    protected void execute() {
        requestSocket.sendRequest(new MkdRequest(dir));
    }
}
