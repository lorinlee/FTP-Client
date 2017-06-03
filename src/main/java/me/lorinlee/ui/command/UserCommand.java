package me.lorinlee.ui.command;

import me.lorinlee.request.UserRequest;
import me.lorinlee.ui.command.builder.CommandBuilder;
import me.lorinlee.ui.command.builder.PasswordCommandBuilder;

import java.util.List;

/**
 * Created by lorin on 17-5-25.
 */
public class UserCommand extends Command {

    private String user;

    public UserCommand(String user) {
        this.user = user;
    }

    @Override
    protected void execute() {
        requestSocket.sendRequest(new UserRequest(user));
    }

    protected void after() {
        List<String> lines = requestSocket.readLines();
        lines.forEach((line) -> {
            System.out.println(line);
            if (line.startsWith("331")) {
                CommandBuilder commandBuilder = new PasswordCommandBuilder();
                Command command = commandBuilder.build();
                command.run();
            }
        });
    }
}
