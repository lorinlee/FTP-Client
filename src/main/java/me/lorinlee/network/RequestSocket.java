package me.lorinlee.network;

import me.lorinlee.handler.Handler;
import me.lorinlee.handler.HandlerDispatcher;
import me.lorinlee.request.Request;

import java.io.*;
import java.net.Socket;

/**
 * Created by lorin on 17-5-22.
 */
public class RequestSocket {

    private Socket socket = null;

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

    public void setSocket(Socket socket) throws IOException {
        if (this.socket != null) this.close();
        this.socket = socket;
        this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        this.handleThread = new HandleThread(bufferedReader);
        this.handleThread.start();
    }

    public void close() throws IOException {
        if (this.bufferedWriter != null) {
            this.bufferedWriter.close();
            this.bufferedWriter = null;
        }
        if (this.bufferedReader != null) {
            this.bufferedReader.close();
            this.bufferedReader = null;
        }
        if (this.socket != null ) {
            this.socket.close();
            this.socket = null;
        }
        if (this.handleThread != null) {
            this.handleThread.setFlag(false);
            this.handleThread = null;
        }
    }

    public void sendRequest(Request request) {
        try {
            bufferedWriter.write(request.toString());
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
                    Handler handler = HandlerDispatcher.getHandler(readLine);
                    handler.handle();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
