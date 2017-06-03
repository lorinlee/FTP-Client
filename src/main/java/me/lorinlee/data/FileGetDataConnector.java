package me.lorinlee.data;

import me.lorinlee.network.DataSocket;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * Created by lorin on 17-5-22.
 */
public class FileGetDataConnector extends DataConnector {

    private String toFileName;

    public FileGetDataConnector(DataSocket socket, String toFileName) {
        super(socket);
        this.toFileName = toFileName;
    }

    public void setToFileName(String toFileName) {
        this.toFileName = toFileName;
    }

    public void execute() throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(new File(toFileName));
        int data;
        while ((data = socket.getReader().read()) != -1) {
            fileOutputStream.write(data);
        }
        fileOutputStream.close();
    }
}
