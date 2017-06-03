package me.lorinlee.network;

import me.lorinlee.request.Request;

import java.io.IOException;

/**
 * Created by lorin on 17-5-22.
 */
public class RequestSocket extends CommonSocket {

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
}
