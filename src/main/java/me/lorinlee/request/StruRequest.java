package me.lorinlee.request;

/**
 * Created by lorin on 17-5-23.
 */
public class StruRequest extends Request {

    public static final String TYPE_FILE = "F";
    public static final String TYPE_RECORD = "R";
    public static final String TYPE_PAGE = "P";

    private String type;

    public StruRequest(String type) {
        this.type = type;
    }

    public static StruRequest getFileStruRequest() {
        return new StruRequest(TYPE_FILE);
    }

    public static StruRequest getRecordStruRequest() {
        return new StruRequest(TYPE_RECORD);
    }

    public static StruRequest getPageStruRequest() {
        return new StruRequest(TYPE_PAGE);
    }

    @Override
    public String getRequest() {
        return "STRU " + type;
    }
}
