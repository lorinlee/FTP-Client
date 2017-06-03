package me.lorinlee.data;

import me.lorinlee.network.DataSocket;

import java.util.List;

import java.io.IOException;

/**
 * Created by lorin on 17-5-22.
 */
public class OutputDataConnector extends DataConnector {

    public OutputDataConnector(DataSocket socket) {
        super(socket);
    }

    public void execute() throws IOException {
        List<String> lines = socket.readLines();
        if (lines != null) lines.forEach(System.out::println);
    }

}
