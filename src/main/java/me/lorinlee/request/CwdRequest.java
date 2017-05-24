package me.lorinlee.request;

/**
 * Created by lorin on 17-5-23.
 */
public class CwdRequest extends Request {

    private String path;

    public CwdRequest(String path) {
        this.path = path;
    }

    @Override
    public String getRequest() {
        return "CWD " + this.path;
    }
}
