package me.lorinlee.ui;

import me.lorinlee.network.RequestSocket;
import me.lorinlee.ui.command.Command;
import me.lorinlee.ui.command.builder.*;

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

    public void commandLoop() throws InterruptedException, IOException {
        while (true) {
            if (! RequestSocket.getInstance().isAlive()) break;
            System.out.print("ftp> ");
            String cmdLine = scanner.nextLine();
            Command command = this.getCommand(cmdLine);
            if (command != null) {
                command.run();
            }
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
                commandBuilder = new PwdCommandBuilder();
                break;
            case "rm":
                commandBuilder = new RmCommandBuilder();
                break;
            case "delete":
                commandBuilder = new DeleteCommandBuilder();
                break;
            case "get":
                commandBuilder = new GetCommandBuilder();
                break;
            case "put":
                commandBuilder = new PutCommandBuilder();
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
            case "bin":
                commandBuilder = new BinCommandBuilder();
                break;
            case "ascii":
                commandBuilder = new AsciiCommandBuilder();
                break;
            default:
                commandBuilder = new InvalidCommandBuilder();
        }
        commandBuilder.setCmdAndParam(cmdAndParam);
        return commandBuilder.build();
    }


}
