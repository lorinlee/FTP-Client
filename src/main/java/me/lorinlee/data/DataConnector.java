package me.lorinlee.data;

import me.lorinlee.network.CommonSocket;
import me.lorinlee.network.DataSocket;

import javax.xml.crypto.Data;
import java.io.*;
import java.net.Socket;

/**
 * Created by lorin on 17-5-22.
 */
public abstract class DataConnector implements Runnable {

    protected DataSocket socket;

    public DataConnector(DataSocket socket) {
        this.socket = socket;
    }

    public abstract void execute() throws IOException;

    public void run() {
        try {
            this.execute();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
