package me.lorinlee.command;

import me.lorinlee.request.PwdRequest;

/**
 * Created by lorin on 17-5-23.
 */
public class PwdCommand extends Command {
    @Override
    public void run() {
        requestSocket.sendRequest(new PwdRequest());
    }
}
