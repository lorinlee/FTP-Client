package me.lorinlee.request;

/**
 * Created by lorin on 17-5-23.
 */
public class RntoRequest extends Request {

    private String path;

    public RntoRequest(String path) {
        this.path = path;
    }

    @Override
    public String getRequest() {
        return "RNTO " + path;
    }
}
