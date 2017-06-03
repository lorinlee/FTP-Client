package me.lorinlee.ui.command;

import me.lorinlee.request.QuitRequest;

/**
 * Created by lorin on 17-5-23.
 */
public class ByeCommand extends Command {
    @Override
    public void execute() {
        requestSocket.sendRequest(new QuitRequest());
    }
}
