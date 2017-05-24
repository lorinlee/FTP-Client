package me.lorinlee.request;

/**
 * Created by lorin on 17-5-22.
 */
public class ListRequest extends Request {

    private String name;

    public ListRequest(String name) {
        this.name = name;
    }

    public ListRequest() {
    }

    public String getRequest() {
        return "LIST " + name;
    }
}
