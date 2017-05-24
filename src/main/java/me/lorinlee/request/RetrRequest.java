package me.lorinlee.request;

/**
 * Created by lorin on 17-5-22.
 */
public class RetrRequest extends Request {

    private String filename;

    public RetrRequest(String filename) {
        this.filename = filename;
    }

    public String getRequest() {
        return "RETR " + filename;
    }
}
