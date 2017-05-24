package me.lorinlee.command;

import me.lorinlee.request.TypeRequest;

/**
 * Created by lorin on 17-5-23.
 */
public class BinCommand extends Command {
    @Override
    public void run() {
        requestSocket.sendRequest(TypeRequest.getBinaryTypeRequest());
    }
}
