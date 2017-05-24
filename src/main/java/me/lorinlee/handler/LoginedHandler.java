package me.lorinlee.handler;

import me.lorinlee.command.BinCommand;
import me.lorinlee.command.Command;
import me.lorinlee.command.SystCommand;

/**
 * Created by lorin on 17-5-23.
 */
public class LoginedHandler extends Handler {

    public LoginedHandler(String info) {
        super(info);
    }

    @Override
    protected void execute() {
        Command command = new SystCommand();
        command.run();
        command = new BinCommand();
        command.run();
    }
}
