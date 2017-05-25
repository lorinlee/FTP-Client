package me.lorinlee.command;

import me.lorinlee.command.builder.CommandBuilder;
import me.lorinlee.command.builder.UserCommandBuilder;
import me.lorinlee.handler.HandlerManager;
import me.lorinlee.handler.OutputHandler;

import java.io.IOException;

/**
 * Created by lorin on 17-5-24.
 */
public class OpenCommand extends Command {

    private String host;
    private int port;

    public OpenCommand(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public OpenCommand(String host) {
        this.host = host;
        this.port = 21;
    }

    public OpenCommand() {
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

    @Override
    public void run() {
        try {
            requestSocket.connect(host, port);
            HandlerManager.getInstance().handle();
            String localUser = System.getenv("USER");
            System.out.print("Name (" + requestSocket.getHost() + ":" + localUser + "):" );
            String user = commandManager.getCommandLine();
            if ("".equals(user)) {
                user = localUser;
            }
            CommandBuilder commandBuilder = new UserCommandBuilder();
            commandBuilder.setCmdAndParam(new String[]{"user", user});
            Command command = commandBuilder.build();
            command.run();
        } catch (IOException e) {
            System.out.println("ftp: " + e.toString());
        } catch (InterruptedException e) {
//            e.printStackTrace();
        }
    }
}
