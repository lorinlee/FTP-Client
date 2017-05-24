package me.lorinlee.request;

/**
 * Created by lorin on 17-5-23.
 */
public class HelpRequest extends Request {

    private String command;

    public HelpRequest(String command) {
        this.command = command;
    }

    @Override
    public String getRequest() {
        return "HELP " + command;
    }
}
