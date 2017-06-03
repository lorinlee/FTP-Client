package me.lorinlee.ui.command;

import me.lorinlee.request.PassRequest;
import me.lorinlee.ui.command.builder.CommandBuilder;
import me.lorinlee.ui.command.exception.ExceptionHandler;

import java.io.IOException;
import java.net.SocketException;

/**
 * Created by lorin on 17-5-25.
 */
public class PasswordCommand extends Command {

    private String pass;

    public PasswordCommand(String pass) {
        this.pass = pass;
    }

    @Override
    protected void execute() {
        requestSocket.sendRequest(new PassRequest(pass));
    }

    protected void after() {
        try {
            requestSocket.setLongReadMode();
            String line = requestSocket.readLine();
            System.out.println(line);
            requestSocket.setShortReadMode();
            super.after();
            Command command = new SystCommand();
            command.run();
            command = new BinCommand();
            command.run();
        } catch (IOException e) {
            ExceptionHandler.handle(e);
        }
    }
}
