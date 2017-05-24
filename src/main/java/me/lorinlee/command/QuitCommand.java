package me.lorinlee.command;

import me.lorinlee.request.QuitRequest;

/**
 * Created by lorin on 17-5-23.
 */
public class QuitCommand extends Command {
    @Override
    public void run() {
        requestSocket.sendRequest(new QuitRequest());
        requestSocket.setStatus(false);
    }
}
