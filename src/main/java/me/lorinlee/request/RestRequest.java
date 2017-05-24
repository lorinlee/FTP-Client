package me.lorinlee.request;

/**
 * Created by lorin on 17-5-23.
 */
public class RestRequest extends Request {

    private int offset;

    public RestRequest(int offset) {
        this.offset = offset;
    }

    @Override
    public String getRequest() {
        return "REST " + offset;
    }
}
