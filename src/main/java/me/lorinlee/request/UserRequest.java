package me.lorinlee.request;

/**
 * Created by lorin on 17-5-22.
 */
public class UserRequest extends Request {

    private String user;

    public UserRequest(String user) {
        this.user = user;
    }

    public String getRequest() {
        return "USER " + user;
    }
}
