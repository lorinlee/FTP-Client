package me.lorinlee.ui.command.builder;

import me.lorinlee.ui.command.Command;
import me.lorinlee.ui.CommandManager;
import me.lorinlee.network.RequestSocket;

/**
 * Created by lorin on 17-5-25.
 */
public abstract class CommandBuilder {

    protected String[] cmdAndParam;

    protected RequestSocket requestSocket = RequestSocket.getInstance();

    protected CommandManager commandManager = CommandManager.getInstance();


    public CommandBuilder(String[] cmdAndParam) {
        this.cmdAndParam = cmdAndParam;
    }

    public CommandBuilder() {
    }

    public void setCmdAndParam(String[] cmdAndParam) {
        this.cmdAndParam = cmdAndParam;
    }

    public abstract Command build();
}
