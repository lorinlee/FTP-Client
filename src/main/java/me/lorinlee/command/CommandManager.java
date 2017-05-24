package me.lorinlee.command;

import me.lorinlee.FTPClient;

import java.util.Scanner;

/**
 * Created by lorin on 17-5-22.
 */
public class CommandManager {

    public static Scanner scanner = FTPClient.scanner;

    public static Command getCommand(String cmd) {
        cmd = cmd.toLowerCase();
        Command command = null;
        String arg1 = null;
        switch (cmd) {
            case "ls":
                command = new LsCommand();
                break;
            case "lsd":
                command = new LsCommand(scanner.next());
                break;
            case "cd":
                command = new CdCommand(scanner.next());
                break;
            case "cdup":
                command = new CdupCommand(scanner.next());
                break;
            case "mkdir":
                command = new MkdirCommand(scanner.next());
                break;
            case "pwd":
                command = new PwdCommand();
                break;
            case "rm":
                command = new RmCommand(scanner.next());
                break;
            case "rmd":
                command = new RmdCommand(scanner.next());
                break;
            case "get":
                command = new GetCommand(scanner.next());
                break;
            case "put":
                command = new PutCommand(scanner.next());
                break;
            case "user":
                command = new UserCommand(scanner.next());
                break;
            case "pass":
                command = new PassCommand(scanner.next());
                break;
            case "stat":
                command = new StatCommand();
                break;
            case "statp":
                command = new StatCommand(scanner.next());
                break;
            case "quit":
            case "exit":
                command = new QuitCommand();
                break;
        }
        return command;
    }


}
