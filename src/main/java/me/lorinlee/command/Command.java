package me.lorinlee.command;

import me.lorinlee.network.DataSocketManager;
import me.lorinlee.network.RequestSocket;

/**
 * Created by lorin on 17-5-22.
 */
public abstract class Command implements Runnable {

    protected RequestSocket requestSocket = RequestSocket.getInstance();
    protected DataSocketManager dataSocketManager = DataSocketManager.getInstance();
    protected CommandManager commandManager = CommandManager.getInstance();

    public abstract void run();

    public static Command build(String[] cmdAndParam) throws IllegalAccessException, InstantiationException {
        return Command.class.newInstance();
    }

}
