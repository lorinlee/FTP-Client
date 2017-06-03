package me.lorinlee.network;

import java.io.*;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by lorin on 17-6-3.
 */
public class CommonSocket {
    protected Socket socket = null;

    protected String host;

    protected int port;

    protected BufferedReader bufferedReader = null;

    protected BufferedWriter bufferedWriter = null;

    public CommonSocket() {

    }

    public CommonSocket(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void connect() throws IOException {
        if (this.socket != null) this.close();
        this.socket = new Socket(host, port);
        socket.setSoTimeout(200);
        this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
    }

    public boolean isConnected() {
        return socket != null && socket.isConnected();
    }

    public void close() throws IOException {
        if (this.socket != null ) {
            this.socket.close();
            this.socket = null;
        }
        if (this.bufferedWriter != null) {
            this.bufferedWriter = null;
        }
        if (this.bufferedReader != null) {
            this.bufferedReader = null;
        }
    }

    public List<String> readLines() {
        List<String> lines = new LinkedList<>();
        try {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                lines.add(line);
            }
        } catch (Exception e) {

        } finally {
            return lines;
        }
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
