package me.lorinlee.command;

import me.lorinlee.request.PassRequest;

/**
 * Created by lorin on 17-5-25.
 */
public class PasswordCommand extends Command {

    private String pass;

    public PasswordCommand(String pass) {
        this.pass = pass;
    }

    @Override
    public void run() {
        requestSocket.sendRequest(new PassRequest(pass));
    }
}
