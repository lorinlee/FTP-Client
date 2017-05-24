package me.lorinlee.request;

/**
 * Created by lorin on 17-5-23.
 */
public class DeleRequest extends Request {

    private String filename;

    public DeleRequest(String filename) {
        this.filename = filename;
    }

    @Override
    public String getRequest() {
        return "DELE " + this.filename;
    }
}
