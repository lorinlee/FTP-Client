package me.lorinlee.data;

import me.lorinlee.handler.Handler;
import me.lorinlee.handler.OutputHandler;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by lorin on 17-5-22.
 */
public class OutputData extends DataStream {

    public OutputData(Socket socket) throws IOException {
        super(socket);
    }

    public void execute() throws IOException {
        String readLine;
        while ((readLine = bufferedReader.readLine()) != null) {
            Handler handler = new OutputHandler(readLine);
            handler.handle();
        }
    }

}
