package me.lorinlee.ui.command;

import me.lorinlee.config.AppConfig;
import me.lorinlee.data.FilePutDataConnector;
import me.lorinlee.network.DataSocket;
import me.lorinlee.request.PasvRequest;
import me.lorinlee.request.StorRequest;

import java.io.IOException;

/**
 * Created by lorin on 17-5-22.
 */
public class PutCommand extends Command {

    DataSocket socket;

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

    public void before() {
        socket = DataSocket.getDataSocket();
    }

    public void execute() {
        if (socket != null) {
            FilePutDataConnector filePutDataConnector = new FilePutDataConnector(socket, fromFileName);
            filePutDataConnector.run();
            requestSocket.sendRequest(new StorRequest(toFileName));
        }
    }
}
