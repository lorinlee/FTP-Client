package me.lorinlee.network;

import java.net.Socket;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by lorin on 17-5-22.
 */
public class DataSocketManager {

    private BlockingQueue<Socket> portSocketQueue = new LinkedBlockingQueue<Socket>();

    private BlockingQueue<Socket> pasvSocketQueue = new LinkedBlockingQueue<Socket>();

    private DataSocketManager() {

    }

    public static DataSocketManager getInstance() {
        return SocketManagerHolder.DATA_SOCKET_MANAGER;
    }

    private static class SocketManagerHolder {
        private static final DataSocketManager DATA_SOCKET_MANAGER = new DataSocketManager();
    }

    public void putPortSocket(Socket socket) throws InterruptedException {
        portSocketQueue.put(socket);
    }

    public Socket takePortSocket() throws InterruptedException {
        return portSocketQueue.take();
    }

    public void putPasvSocket(Socket socket) throws InterruptedException {
        pasvSocketQueue.put(socket);
    }

    public Socket takePasvSocket() throws InterruptedException {
        return pasvSocketQueue.take();
    }

}
