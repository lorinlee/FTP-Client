package me.lorinlee.network;

import me.lorinlee.request.Request;

import java.io.IOException;
import java.net.SocketException;

/**
 * Created by lorin on 17-5-22.
 */
public class RequestSocket extends CommonSocket {

    private static final int SHORT_READ_MODE = 200;
    private static final int LONG_READ_MODE = 10000;

    private boolean status = true;

    private static class RequestSocketHolder {
        private final static RequestSocket REQUEST_SOCKET = new RequestSocket();
    }

    public static RequestSocket getInstance() {
        return RequestSocketHolder.REQUEST_SOCKET;
    }

    public void sendRequest(Request request) {
        try {
            bufferedWriter.write(request.toString());
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setShortReadMode() throws SocketException {
        socket.setSoTimeout(SHORT_READ_MODE);
    }

    public void setLongReadMode() throws SocketException {
        socket.setSoTimeout(LONG_READ_MODE);
    }

    public String readLine() throws IOException {
        return bufferedReader.readLine();
    }
}
