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

    private String path = ".";

    public LsCommand() {
    }

    public LsCommand(String path) {
        this.path = path;
    }

    public void run() {
        if (AppConfig.getMode() == AppConfig.MODE_PASV || true) {
            requestSocket.sendRequest(new PasvRequest());
        }
        try {
            requestSocket.sendRequest(new ListRequest(path));
            OutputData outputData = new OutputData(dataSocketManager.takePasvSocket());
            outputData.run();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
