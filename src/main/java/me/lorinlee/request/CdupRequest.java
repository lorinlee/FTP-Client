package me.lorinlee.request;

/**
 * Created by lorin on 17-5-23.
 */
public class CdupRequest extends Request {

    private String path;

    public CdupRequest(String path) {
        this.path = path;
    }

    @Override
    public String getRequest() {
        return "CDUP " + this.path;
    }
}
