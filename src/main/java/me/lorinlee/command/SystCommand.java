package me.lorinlee.command;

import me.lorinlee.request.SystRequest;

/**
 * Created by lorin on 17-5-22.
 */
public class SystCommand extends Command {
    public void run() {
        requestSocket.sendRequest(new SystRequest());
    }
}
