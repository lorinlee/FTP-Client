package me.lorinlee.request;

/**
 * Created by lorin on 17-5-23.
 */
public class SmntRequest extends Request {

    private String path;

    public SmntRequest(String path) {
        this.path = path;
    }

    @Override
    public String getRequest() {
        return "SMNT " + path;
    }
}
