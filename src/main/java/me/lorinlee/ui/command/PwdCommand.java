package me.lorinlee.ui.command;

import me.lorinlee.request.PwdRequest;

/**
 * Created by lorin on 17-5-23.
 */
public class PwdCommand extends Command {
    @Override
    protected void execute() {
        requestSocket.sendRequest(new PwdRequest());
    }
}
