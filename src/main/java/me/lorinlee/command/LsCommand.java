package me.lorinlee.command;

import me.lorinlee.config.AppConfig;
import me.lorinlee.data.OutputData;
import me.lorinlee.request.ListRequest;
import me.lorinlee.request.PasvRequest;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by lorin on 17-5-22.
 */
public class LsCommand extends Command {

    private String path;

    public LsCommand() {
        this.path = "";
    }

    public LsCommand(String path) {
        this.path = path;
    }

    public void run() {
        dataSocketManager.newSocket();
        try {
            Socket socket = dataSocketManager.pollSocket();
            if (socket != null) {
                requestSocket.sendRequest(new ListRequest(path));
                OutputData outputData = new OutputData(socket);
                outputData.run();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
