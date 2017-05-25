package me.lorinlee.handler;

import me.lorinlee.command.Command;
import me.lorinlee.command.builder.PasswordCommandBuilder;

/**
 * Created by lorin on 17-5-25.
 */
public class PasswordHandler extends Handler {

    public PasswordHandler(String info) {
        super(info);
    }

    @Override
    protected void execute() {
        Command command = new PasswordCommandBuilder().build();
        if (command != null) command.run();
        try {
            HandlerManager.getInstance().handle();
        } catch (InterruptedException e) {
            System.out.println("ftp: " + e.toString());
        }
    }
}
