package me.lorinlee.command;

import me.lorinlee.request.QuitRequest;

import java.io.IOException;

/**
 * Created by lorin on 17-5-23.
 */
public class QuitCommand extends Command {
    @Override
    public void run() {
        try {
            if (requestSocket.isConnected()) requestSocket.exit();
        } catch (IOException e) {
            e.printStackTrace();
        }
        requestSocket.setStatus(false);
    }
}
