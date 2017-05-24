package me.lorinlee;

import me.lorinlee.command.*;
import me.lorinlee.handler.OutputHandler;
import me.lorinlee.network.RequestSocket;
import java.util.List;

import java.io.*;
import java.net.Socket;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by lorin on 17-5-22.
 */
public class FTPClient {

    public static Scanner scanner = new Scanner(System.in);

    private String host;
    private int port;

    public FTPClient(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public Socket getSocket() throws IOException {
        return new Socket(host, port);
    }

    public void connect() throws IOException {
        Socket socket = new Socket(host, port);
        RequestSocket.getInstance().setSocket(socket);
    }

    public void sendCommand(Command command) {
        command.run();
    }

    public void commandLoop() throws InterruptedException, IOException {

        boolean flag = true;

        while (flag) {
            OutputHandler.outputAll();
            if (! RequestSocket.getInstance().isStatus()) {
                RequestSocket.getInstance().close();
                System.exit(0);
            }
            System.out.print("ftp> ");
            String cmd = scanner.next();
            Command command = CommandManager.getCommand(cmd);
            if (command == null) {
                System.out.println("?Invalid command");
            } else {
                this.sendCommand(command);
            }
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        FTPClient ftpClient = new FTPClient("127.0.0.1", 21);
        ftpClient.connect();

        ftpClient.commandLoop();

    }


}
