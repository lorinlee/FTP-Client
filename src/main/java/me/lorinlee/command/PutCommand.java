package me.lorinlee.command;

import me.lorinlee.config.AppConfig;
import me.lorinlee.data.FilePutDataStream;
import me.lorinlee.request.PasvRequest;
import me.lorinlee.request.StorRequest;

import java.io.IOException;

/**
 * Created by lorin on 17-5-22.
 */
public class PutCommand extends Command {

    private String fromFileName;
    private String toFileName;

    public PutCommand(String fromFileName, String toFileName) {
        this.fromFileName = fromFileName;
        this.toFileName = toFileName;
    }

    public PutCommand(String fromFileName) {
        this.fromFileName = fromFileName;
        this.toFileName = fromFileName;
    }

    public void run() {
        if (AppConfig.getMode() == AppConfig.MODE_PASV || true) {
            requestSocket.sendRequest(new PasvRequest());
        }
        try {
            FilePutDataStream filePutDataStream = new FilePutDataStream(dataSocketManager.takePasvSocket(), fromFileName);
            filePutDataStream.run();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        requestSocket.sendRequest(new StorRequest(toFileName));
    }
}
