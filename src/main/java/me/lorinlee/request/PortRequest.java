package me.lorinlee.request;

/**
 * Created by lorin on 17-5-23.
 */
public class PortRequest extends Request {

    private String address;


    public PortRequest(String host, int port) {
        address = parseHostAndPort(host, port);
    }

    private String parseHostAndPort(String host, int port) {
        StringBuilder stringBuilder = new StringBuilder();
        String[] hostArray = host.split("\\.");
        for (String hostSeg: hostArray) {
            stringBuilder.append(hostSeg);
            stringBuilder.append(",");
        }

        int portPrefix = port / 256;
        int portSuffix = port % 256;
        stringBuilder.append(portPrefix);
        stringBuilder.append(",");
        stringBuilder.append(portSuffix);

        return stringBuilder.toString();
    }

    @Override
    public String getRequest() {
        return "PORT " + this.address;
    }
}
