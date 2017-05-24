package me.lorinlee.request;

/**
 * Created by lorin on 17-5-23.
 */
public class AppeRequest extends Request {

    private String filename;

    public AppeRequest(String filename) {
        this.filename = filename;
    }

    @Override
    public String getRequest() {
        return "APPE " + this.filename;
    }
}
