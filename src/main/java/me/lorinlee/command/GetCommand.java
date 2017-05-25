package me.lorinlee.command;

import me.lorinlee.config.AppConfig;
import me.lorinlee.data.FileGetDataStream;
import me.lorinlee.request.PasvRequest;
import me.lorinlee.request.RetrRequest;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by lorin on 17-5-22.
 */
public class GetCommand extends Command {

    private String fromFileName;
    private String toFileName;

    public GetCommand() {
    }

    public GetCommand(String fromFileName) {
        this.fromFileName = fromFileName;
        this.toFileName = fromFileName;
    }

    public GetCommand(String fromFileName, String toFileName) {
        this.fromFileName = fromFileName;
        this.toFileName = toFileName;
    }

    public String getFromFileName() {
        return fromFileName;
    }

    public void setFromFileName(String fromFileName) {
        this.fromFileName = fromFileName;
    }

    public String getToFileName() {
        return toFileName;
    }

    public void setToFileName(String toFileName) {
        this.toFileName = toFileName;
    }

    public void run() {
        dataSocketManager.newSocket();
        try {
            Socket socket = dataSocketManager.pollSocket();
            if (socket != null) {
                requestSocket.sendRequest(new RetrRequest(fromFileName));
                FileGetDataStream fileGetDataStream = new FileGetDataStream(socket, toFileName);
                fileGetDataStream.run();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
