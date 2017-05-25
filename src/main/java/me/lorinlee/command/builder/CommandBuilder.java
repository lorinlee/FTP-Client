package me.lorinlee.command.builder;

import me.lorinlee.command.Command;
import me.lorinlee.command.CommandManager;
import me.lorinlee.network.DataSocketManager;
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
