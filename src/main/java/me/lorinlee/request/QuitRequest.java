package me.lorinlee.request;

/**
 * Created by lorin on 17-5-23.
 */
public class QuitRequest extends Request {
    @Override
    public String getRequest() {
        return "QUIT";
    }
}
