package me.lorinlee.ui.command.exception;

/**
 * Created by lorin on 17-6-4.
 */
public class ExceptionHandler {
    public static void handle(Exception e) {
        System.out.println("ftp:" + e.toString());
    }
}
