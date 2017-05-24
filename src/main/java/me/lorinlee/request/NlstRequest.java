package me.lorinlee.request;

/**
 * Created by lorin on 17-5-23.
 */
public class NlstRequest extends Request {

    private String dir;

    public NlstRequest(String dir) {
        this.dir = dir;
    }

    @Override
    public String getRequest() {
        return "NLST " + dir;
    }
}
