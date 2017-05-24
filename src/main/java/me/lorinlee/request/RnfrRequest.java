package me.lorinlee.request;

/**
 * Created by lorin on 17-5-23.
 */
public class RnfrRequest extends Request {

    private String path;

    public RnfrRequest(String path) {
        this.path = path;
    }

    @Override
    public String getRequest() {
        return "RNFR " + path;
    }
}
