package me.lorinlee.request;

/**
 * Created by lorin on 17-5-23.
 */
public class SiteRequest extends Request {

    private String params;

    public SiteRequest(String params) {
        this.params = params;
    }

    @Override
    public String getRequest() {
        return "SITE " + params;
    }
}
