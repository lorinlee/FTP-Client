package me.lorinlee.ui.command;

import me.lorinlee.data.OutputDataConnector;
import me.lorinlee.network.DataSocket;
import me.lorinlee.request.ListRequest;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by lorin on 17-5-22.
 */
public class LsCommand extends Command {

    DataSocket socket;

    private String path;

    public LsCommand() {
        this.path = "";
    }

    public LsCommand(String path) {
        this.path = path;
    }

    protected void before() {
        socket = DataSocket.getDataSocket();
    }

    protected void execute() {
        if (socket != null) {
            requestSocket.sendRequest(new ListRequest(path));
            OutputDataConnector outputDataConnector = new OutputDataConnector(socket);
            outputDataConnector.run();
        }
    }

}
