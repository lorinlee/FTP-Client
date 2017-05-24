package me.lorinlee.request;

/**
 * Created by lorin on 17-5-23.
 */
public class AlloRequest extends Request {

    private int bytes;

    public AlloRequest(int bytes) {
        this.bytes = bytes;
    }

    @Override
    public String getRequest() {
        return "ALLO " + bytes;
    }
}
