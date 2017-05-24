package me.lorinlee.request;

/**
 * Created by lorin on 17-5-22.
 */
public abstract class Request {

    public abstract String getRequest();

    @Override
    public final String toString() {
        return this.getRequest() + "\r\n";
    }

}
