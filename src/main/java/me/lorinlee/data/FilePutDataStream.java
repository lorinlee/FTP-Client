package me.lorinlee.data;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * Created by lorin on 17-5-22.
 */
public class FilePutDataStream extends DataStream {

    private String fromFileName;

    public FilePutDataStream(Socket socket) throws IOException {
        super(socket);
    }

    public FilePutDataStream(Socket socket, String filename) throws IOException {
        super(socket);
        this.fromFileName = filename;
    }

    public void execute() throws IOException {
        FileInputStream fileInputStream = new FileInputStream(new File(fromFileName));
        int data;
        while ((data = fileInputStream.read()) != -1) {
            bufferedWriter.write(data);
        }
        fileInputStream.close();
    }
}
