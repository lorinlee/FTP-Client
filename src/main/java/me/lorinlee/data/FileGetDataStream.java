package me.lorinlee.data;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * Created by lorin on 17-5-22.
 */
public class FileGetDataStream extends DataStream {

    private String toFileName;

    public FileGetDataStream(Socket socket) throws IOException {
        super(socket);
    }

    public FileGetDataStream(Socket socket, String filename) throws IOException {
        super(socket);
        this.toFileName = filename;
    }

    public void setToFileName(String toFileName) {
        this.toFileName = toFileName;
    }

    public void execute() throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(new File(toFileName));
        int data;
        while ((data = bufferedReader.read()) != -1) {
            fileOutputStream.write(data);
        }
        fileOutputStream.close();
    }
}
