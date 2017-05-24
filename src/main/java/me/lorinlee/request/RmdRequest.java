package me.lorinlee.request;

/**
 * Created by lorin on 17-5-23.
 */
public class RmdRequest extends Request {

    private String dir;

    public RmdRequest(String dir) {
        this.dir = dir;
    }

    @Override
    public String getRequest() {
        return "RMD " + dir;
    }
}
