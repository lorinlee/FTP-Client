package me.lorinlee.command;

import me.lorinlee.network.RequestSocket;
import me.lorinlee.request.UserRequest;

/**
 * Created by lorin on 17-5-22.
 */
public class UserCommand extends Command {

    private String user;

    public UserCommand(String user) {
        this.user = user;
    }

    public void run() {
        requestSocket.sendRequest(new UserRequest(user));
    }

    @Override
    public String toString() {
        return "UserCommand{" +
                "user='" + user + '\'' +
                '}';
    }
}
