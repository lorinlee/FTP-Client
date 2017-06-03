package me.lorinlee.ui.command;

import me.lorinlee.data.FileGetDataConnector;
import me.lorinlee.network.DataSocket;
import me.lorinlee.request.RetrRequest;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by lorin on 17-5-22.
 */
public class GetCommand extends Command {

    private DataSocket socket;

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

    public void before() {
         socket = DataSocket.getDataSocket();
    }

    public void execute() {
        if (socket != null) {
            requestSocket.sendRequest(new RetrRequest(fromFileName));
            FileGetDataConnector fileGetDataConnector = new FileGetDataConnector(socket, toFileName);
            fileGetDataConnector.run();
        }
    }
}
