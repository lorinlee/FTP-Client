package me.lorinlee;

import me.lorinlee.command.CommandManager;

import java.io.IOException;
import java.util.Map;

/**
 * Created by lorin on 17-5-22.
 */
public class FTPClient {

    public static void main(String[] args) throws IOException, InterruptedException {
        CommandManager.getInstance().commandLoop();
    }


}
