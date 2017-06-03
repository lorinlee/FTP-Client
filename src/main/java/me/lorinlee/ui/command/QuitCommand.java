package me.lorinlee.ui.command;

import java.io.IOException;

/**
 * Created by lorin on 17-5-23.
 */
public class QuitCommand extends Command {
    @Override
    public void execute() {
        try {
            if (requestSocket.isConnected()) requestSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        requestSocket.setStatus(false);
    }
}
