package me.lorinlee.network;

import me.lorinlee.handler.Handler;
import me.lorinlee.handler.HandlerDispatcher;
import me.lorinlee.handler.HandlerManager;
import me.lorinlee.request.Request;

import java.io.*;
import java.net.Socket;

/**
 * Created by lorin on 17-5-22.
 */
public class RequestSocket {

    private Socket socket = null;

    private String host;

    private int port;

    private BufferedReader bufferedReader = null;

    private BufferedWriter bufferedWriter = null;

    private HandleThread handleThread = null;

    private volatile boolean status = true;

    private RequestSocket() {

    }

    private static class RequestSocketHolder {
        private final static RequestSocket REQUEST_SOCKET = new RequestSocket();
    }

    public static RequestSocket getInstance() {
        return RequestSocketHolder.REQUEST_SOCKET;
    }

    public void connect(String host, int port) throws IOException {
        if (this.socket != null) this.close();
        this.host = host;
        this.port = port;
        this.socket = new Socket(host, port);
        this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        this.handleThread = new HandleThread(bufferedReader);
        this.handleThread.start();
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
        DataSocketManager.getInstance().clear();
        HandlerManager.getInstance().clear();
    }

    public void sendRequest(Request request) {
        try {
            bufferedWriter.write(request.toString());
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
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

    private class HandleThread extends Thread {

        private BufferedReader bufferedReader;

        private volatile boolean flag = true;

        public HandleThread(BufferedReader bufferedReader) {
            this.bufferedReader = bufferedReader;
        }

        public void setFlag(boolean flag) {
            this.flag = flag;
        }

        @Override
        public void run() {
            String readLine;
            try {
                while ((readLine = bufferedReader.readLine()) != null && flag) {
                    HandlerDispatcher.getInstance().dispatch(readLine);
                }
            } catch (IOException e) {

            }
        }

        public void close() {
            this.setFlag(false);
        }

    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void exit() throws IOException {
        this.close();
        handleThread.close();
    }
}
