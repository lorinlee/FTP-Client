package me.lorinlee.request;

/**
 * Created by lorin on 17-5-22.
 */
public class PassRequest extends Request {

    private String password;

    public PassRequest(String password) {
        this.password = password;
    }

    public String getRequest() {
        return "PASS " + password;
    }
}
