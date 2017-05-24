package me.lorinlee.request;

/**
 * Created by lorin on 17-5-23.
 */
public class NoopRequest extends Request {
    @Override
    public String getRequest() {
        return "NOOP";
    }
}
