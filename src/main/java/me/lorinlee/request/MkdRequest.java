package me.lorinlee.request;

/**
 * Created by lorin on 17-5-23.
 */
public class MkdRequest extends Request {

    private String dir;

    public MkdRequest(String dir) {
        this.dir = dir;
    }

    @Override
    public String getRequest() {
        return "MKD " + dir;
    }
}
