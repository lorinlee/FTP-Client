package me.lorinlee.request;

/**
 * Created by lorin on 17-5-23.
 */
public class AcctRequest extends Request {

    private String account;

    public AcctRequest(String account) {
        this.account = account;
    }

    @Override
    public String getRequest() {
        return "ACCT " + this.account;
    }
}
