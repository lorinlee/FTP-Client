package me.lorinlee.ui;

import java.io.IOException;

/**
 * Created by lorin on 17-6-3.
 */
public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        CommandManager.getInstance().commandLoop();
    }
}
