package me.lorinlee.ui.command;

import me.lorinlee.request.QuitRequest;
import me.lorinlee.ui.command.exception.ExceptionHandler;

import java.io.IOException;

/**
 * Created by lorin on 17-5-25.
 */
public class CloseCommand extends Command {
    @Override
    protected void execute() {
        if (requestSocket.isConnected()) {
            requestSocket.sendRequest(new QuitRequest());
        }
    }

    protected void after() {
        super.after();
        try {
            requestSocket.close();
        } catch (IOException e) {
            ExceptionHandler.handle(e);
        }
    }
}
