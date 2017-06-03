package me.lorinlee.ui.command;

import me.lorinlee.network.RequestSocket;
import me.lorinlee.ui.CommandManager;

import java.util.List;

/**
 * Created by lorin on 17-5-22.
 */
public abstract class Command implements Runnable {

    protected RequestSocket requestSocket = RequestSocket.getInstance();
    protected CommandManager commandManager = CommandManager.getInstance();

    protected void before() {

    }

    protected abstract void execute();

    protected void after() {
        List<String> lines = requestSocket.readLines();
        if (lines != null) {
            lines.forEach(System.out::println);
        }
    }

    public void run() {
        this.before();
        this.execute();
        this.after();
    }
}
