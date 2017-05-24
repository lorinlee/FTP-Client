package me.lorinlee.data;

import java.io.*;
import java.net.Socket;

/**
 * Created by lorin on 17-5-22.
 */
public abstract class DataStream implements Runnable {

    protected Socket socket;

    protected BufferedReader bufferedReader;

    protected BufferedWriter bufferedWriter;

    public DataStream(Socket socket) throws IOException {
        this.socket = socket;
        bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
    }

    public abstract void execute() throws IOException;

    public void run() {
        try {
            this.execute();
            this.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void close() throws IOException {
        if (this.bufferedWriter != null) {
            this.bufferedWriter.close();
            this.bufferedWriter = null;
        }
        if (this.bufferedReader != null) {
            this.bufferedReader.close();
            this.bufferedReader = null;
        }
        if (this.socket != null) {
            this.socket.close();
            this.socket = null;
        }
    }
}
