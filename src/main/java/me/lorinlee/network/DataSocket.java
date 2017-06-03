package me.lorinlee.network;

import me.lorinlee.config.AppConfig;
import me.lorinlee.request.PasvRequest;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by lorin on 17-6-3.
 */
public class DataSocket extends CommonSocket {

    private static RequestSocket requestSocket = RequestSocket.getInstance();

    private static Pattern pattern = Pattern.compile("\\((.*)\\)");

    public static DataSocket getDataSocket() {
        if (AppConfig.getMode() == AppConfig.MODE_PASV) return getPasvSocket();
        else return null;
    }

    private static DataSocket getPasvSocket() {
        requestSocket.sendRequest(new PasvRequest());

        String host = null;
        int port = 0;
        DataSocket socket = null;
        List<String> lines = requestSocket.readLines();
        if (lines == null) return null;

        for (String line : lines) {
            if (!line.startsWith("227")) {
                System.out.println(line);
                continue;
            }
            Matcher matcher = pattern.matcher(line);

            if (matcher.find()) {
                String[] hostPort = matcher.group(1).split(",");
                if (hostPort.length < 6) return socket;

                StringBuilder stringBuilder = new StringBuilder(hostPort[0]);
                for (int i = 1; i < 4; ++i) {
                    stringBuilder.append(".");
                    stringBuilder.append(hostPort[i]);
                }
                host = stringBuilder.toString();

                int prefix = Integer.parseInt(hostPort[4]);
                int suffix = Integer.parseInt(hostPort[5]);
                port = prefix * 256 + suffix;

                socket = new DataSocket(host, port);
                break;
            }
        }

        if (socket != null) {
            try {
                socket.connect();
            } catch (IOException e) {

            }
        }

        return socket;
    }

    public DataSocket(String host, int port) {
        super(host, port);
    }

    public Reader getReader() {
        return this.bufferedReader;
    }

    public Writer getWriter() {
        return this.bufferedWriter;
    }
}
