package me.lorinlee.ui.command;

import me.lorinlee.request.TypeRequest;

/**
 * Created by lorin on 17-5-23.
 */
public class AsciiCommand extends Command {
    @Override
    public void execute() {
        requestSocket.sendRequest(TypeRequest.getAsciiTypeRequest());
    }
}
