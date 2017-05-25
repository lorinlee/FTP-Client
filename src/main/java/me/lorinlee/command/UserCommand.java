package me.lorinlee.command;

import me.lorinlee.request.UserRequest;

/**
 * Created by lorin on 17-5-25.
 */
public class UserCommand extends Command {

    private String user;

    public UserCommand(String user) {
        this.user = user;
    }

    @Override
    public void run() {
        requestSocket.sendRequest(new UserRequest(user));
    }
}
