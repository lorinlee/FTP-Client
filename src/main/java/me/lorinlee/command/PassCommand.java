package me.lorinlee.command;

import me.lorinlee.network.RequestSocket;
import me.lorinlee.request.PassRequest;

/**
 * Created by lorin on 17-5-22.
 */
public class PassCommand extends Command {

    private String password;

    public PassCommand(String password) {
        this.password = password;
    }

    public void run() {
        requestSocket.sendRequest(new PassRequest(password));
    }
}
