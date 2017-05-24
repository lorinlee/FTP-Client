package me.lorinlee.request;

/**
 * Created by lorin on 17-5-23.
 */
public class StouRequest extends Request {

    private String filename;

    public StouRequest(String filename) {
        this.filename = filename;
    }

    @Override
    public String getRequest() {
        return "STOU " + filename;
    }
}
