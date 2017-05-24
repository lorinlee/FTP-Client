package me.lorinlee.command;

import me.lorinlee.config.AppConfig;
import me.lorinlee.data.FileGetDataStream;
import me.lorinlee.request.PasvRequest;
import me.lorinlee.request.RetrRequest;

import java.io.IOException;

/**
 * Created by lorin on 17-5-22.
 */
public class GetCommand extends Command {

    private String fromFileName;
    private String toFileName;

    public GetCommand(String fromFileName) {
        this.fromFileName = fromFileName;
        this.toFileName = fromFileName;
    }

    public GetCommand(String fromFileName, String toFileName) {
        this.fromFileName = fromFileName;
        this.toFileName = toFileName;
    }

    public void run() {
        if (AppConfig.getMode() == AppConfig.MODE_PASV || true) {
            requestSocket.sendRequest(new PasvRequest());
        }
        requestSocket.sendRequest(new RetrRequest(fromFileName));
        try {
            FileGetDataStream fileGetDataStream = new FileGetDataStream(dataSocketManager.takePasvSocket(), toFileName);
            fileGetDataStream.run();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
