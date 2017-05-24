package me.lorinlee.request;

/**
 * Created by lorin on 17-5-23.
 */
public class StatRequest extends Request {

    private String dir;

    public StatRequest(String dir) {
        this.dir = dir;
    }

    public StatRequest() {
    }

    @Override
    public String getRequest() {
        return "STAT " + dir;
    }
}
