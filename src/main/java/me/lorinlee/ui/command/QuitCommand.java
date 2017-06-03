package me.lorinlee.ui.command;

import me.lorinlee.request.QuitRequest;
import me.lorinlee.ui.command.exception.ExceptionHandler;

import java.io.IOException;

/**
 * Created by lorin on 17-5-23.
 */
public class QuitCommand extends Command {
    @Override
    protected void execute() {
        if (requestSocket.isConnected()) requestSocket.sendRequest(new QuitRequest());
    }

    protected void after() {
        try {
            if (requestSocket.isConnected()) requestSocket.close();
        } catch (IOException e) {
            ExceptionHandler.handle(e);
        }
        requestSocket.setStatus(false);
    }
}
