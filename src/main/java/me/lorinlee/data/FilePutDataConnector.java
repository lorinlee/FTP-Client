package me.lorinlee.data;

import me.lorinlee.network.DataSocket;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * Created by lorin on 17-5-22.
 */
public class FilePutDataConnector extends DataConnector {

    private String fromFileName;

    public FilePutDataConnector(DataSocket socket) {
        super(socket);
    }

    public FilePutDataConnector(DataSocket socket, String filename) {
        super(socket);
        this.fromFileName = filename;
    }

    public void execute() throws IOException {
        FileInputStream fileInputStream = new FileInputStream(new File(fromFileName));
        int data;
        while ((data = fileInputStream.read()) != -1) {
            socket.getWriter().write(data);
        }
        fileInputStream.close();
    }
}
