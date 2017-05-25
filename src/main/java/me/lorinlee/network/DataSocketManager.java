package me.lorinlee.network;

import me.lorinlee.config.AppConfig;
import me.lorinlee.request.PasvRequest;

import java.net.Socket;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by lorin on 17-5-22.
 */
public class DataSocketManager {

    private RequestSocket requestSocket = RequestSocket.getInstance();

    private BlockingQueue<Socket> socketQueue = new LinkedBlockingQueue<Socket>();

    private DataSocketManager() {

    }

    public static DataSocketManager getInstance() {
        return SocketManagerHolder.DATA_SOCKET_MANAGER;
    }

    private static class SocketManagerHolder {
        private static final DataSocketManager DATA_SOCKET_MANAGER = new DataSocketManager();
    }

    public void putSocket(Socket socket) throws InterruptedException {
        socketQueue.put(socket);
    }

    public Socket takeSocket() throws InterruptedException {
        return socketQueue.take();
    }

    public Socket pollSocket() {
        try {
            return socketQueue.poll(200, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            System.out.println("Connection error.");
            return null;
        }
    }

    public void newSocket() {
        if (AppConfig.getMode() == AppConfig.MODE_PASV) {
            requestSocket.sendRequest(new PasvRequest());
        } else {
            // TODO
        }
    }

    public void clear() {
        socketQueue.clear();
    }

}
