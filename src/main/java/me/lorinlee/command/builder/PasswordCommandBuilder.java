package me.lorinlee.command.builder;

import me.lorinlee.command.Command;
import me.lorinlee.command.PasswordCommand;

/**
 * Created by lorin on 17-5-25.
 */
public class PasswordCommandBuilder extends CommandBuilder {
    @Override
    public Command build() {
        System.out.print("Password: ");
        String passwordStr = commandManager.getCommandLine();
        return new PasswordCommand(passwordStr);
    }
}
