package me.lorinlee.ui.command;

import me.lorinlee.request.TypeRequest;

/**
 * Created by lorin on 17-5-23.
 */
public class BinCommand extends Command {
    @Override
    protected void execute() {
        requestSocket.sendRequest(TypeRequest.getBinaryTypeRequest());
    }
}
