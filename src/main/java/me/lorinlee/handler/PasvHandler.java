package me.lorinlee.handler;

import me.lorinlee.network.DataSocketManager;

import java.io.IOException;
import java.net.Socket;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by lorin on 17-5-22.
 */
public class PasvHandler extends Handler {

    private static Pattern pattern = Pattern.compile("\\((.*)\\)");

    private String host;
    private int port;

    public PasvHandler(String info) {
        super(info);
    }

    private void parseHostAndPort() throws IOException, InterruptedException {
        Matcher matcher = pattern.matcher(info);

        if (matcher.find()) {
            String[] hostPort = matcher.group(1).split(",");
            if (hostPort.length < 6) return ;

            StringBuilder stringBuilder = new StringBuilder(hostPort[0]);
            for (int i = 1; i < 4; ++i) {
                stringBuilder.append(".");
                stringBuilder.append(hostPort[i]);
            }
            host = stringBuilder.toString();

            int prefix = Integer.parseInt(hostPort[4]);
            int suffix = Integer.parseInt(hostPort[5]);
            port = prefix*256 + suffix;

            DataSocketManager.getInstance().putSocket(new Socket(host, port));

        } else {
            System.out.println(info);
        }
    }

    public void execute() {
        try {
            parseHostAndPort();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
