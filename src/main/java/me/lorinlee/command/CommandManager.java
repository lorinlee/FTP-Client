package me.lorinlee.command;

import me.lorinlee.command.builder.*;
import me.lorinlee.handler.HandlerManager;
import me.lorinlee.network.RequestSocket;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by lorin on 17-5-22.
 */
public class CommandManager {

    private Scanner scanner = new Scanner(System.in);

    public static CommandManager getInstance() {
        return CommandManagerHolder.COMMAND_MANAGER;
    }

    private static class CommandManagerHolder {
        public static final CommandManager COMMAND_MANAGER = new CommandManager();
    }

    public String getCommandLine() {
        return scanner.nextLine();
    }

    public String getCommandStr() {
        return scanner.next();
    }

    public void commandLoop() throws InterruptedException, IOException {
        boolean flag = true;

        while (flag) {
            HandlerManager.getInstance().handle();
            if (! RequestSocket.getInstance().isStatus()) {
                System.exit(0);
            }
            System.out.print("ftp> ");
            String cmdLine = scanner.nextLine();
            Command command = this.getCommand(cmdLine);
            if (command != null) command.run();
        }
    }

    public Command getCommand(String cmdLine) {
        String[] cmdAndParam = cmdLine.split(" ");
        String cmd = cmdAndParam[0].toLowerCase();

        CommandBuilder commandBuilder = null;

        switch (cmd) {
            case "ls":
                commandBuilder = new LsCommandBuilder();
                break;
            case "cd":
                commandBuilder = new CdCommandBuilder();
                break;
            case "cdup":
                commandBuilder = new CdupCommandBuilder();
                break;
            case "mkdir":
                commandBuilder = new MkdirCommandBuilder();
                break;
            case "pwd":
//                commandBuilder = new PwdCommandB();
                break;
            case "rm":
//                commandBuilder = new RmCommand(scanner.next());
                break;
            case "rmd":
//                command = new RmdCommand(scanner.next());
                break;
            case "get":
                commandBuilder = new GetCommandBuilder();
                break;
            case "put":
//                commandBuilder = new PutCommandB(scanner.next());
                break;
            case "stat":
//                command = new StatCommand();
                break;
            case "quit":
            case "exit":
                commandBuilder = new QuitCommandBuilder();
                break;
            case "open":
                commandBuilder = new OpenCommandBuilder();
                break;
            case "user":
                commandBuilder = new UserCommandBuilder();
                break;
            case "close":
                commandBuilder = new CloseCommandBuilder();
                break;
            default:
                commandBuilder = new InvalidCommandBuilder();
        }
        commandBuilder.setCmdAndParam(cmdAndParam);
        return commandBuilder.build();
    }


}
