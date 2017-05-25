package me.lorinlee.command;

import me.lorinlee.request.QuitRequest;

import java.io.IOException;

/**
 * Created by lorin on 17-5-25.
 */
public class CloseCommand extends Command {
    @Override
    public void run() {
        if (requestSocket.isConnected()) {
            try {
                requestSocket.sendRequest(new QuitRequest());
                requestSocket.close();
            } catch (IOException e) {
                System.out.println("ftp: " + e.toString());
            }
        }
    }
}
