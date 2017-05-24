package me.lorinlee.config;

/**
 * Created by lorin on 17-5-22.
 */
public class AppConfig {

    public final static int MODE_PORT = 0;
    public final static int MODE_PASV = 1;

    private static int mode = MODE_PASV;

    public static int getMode() {
        return mode;
    }

    public static void setMode(int mode) {
        AppConfig.mode = mode;
    }
}
