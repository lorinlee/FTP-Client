package me.lorinlee.request;

/**
 * Created by lorin on 17-5-22.
 */
public class StorRequest extends Request {

    private String filename;

    public StorRequest(String filename) {
        this.filename = filename;
    }

    public String getRequest() {
        return "STOR " + filename;
    }
}
