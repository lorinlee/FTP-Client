package me.lorinlee.ui.command;

import me.lorinlee.ui.command.builder.CommandBuilder;
import me.lorinlee.ui.command.builder.UserCommandBuilder;

import java.io.IOException;
import java.util.List;

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

    public void before() {
        requestSocket.setHost(host);
        requestSocket.setPort(port);
    }

    @Override
    public void execute() {
        try {
            requestSocket.connect();
            List<String> lines = requestSocket.readLines();
            lines.forEach(System.out::println);
        } catch (IOException e) {
            try {
                requestSocket.close();
                System.out.println("ftp: " + e.toString());
            } catch (IOException e1) {

            }
        }
    }

    public void after() {
        if (requestSocket.isConnected()) {
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
        }
    }
}
