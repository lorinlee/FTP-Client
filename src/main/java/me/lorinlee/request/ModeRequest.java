package me.lorinlee.request;

/**
 * Created by lorin on 17-5-23.
 */
public class ModeRequest extends Request {

    public static final String MODE_STREAM = "S";
    public static final String MODE_BLOCK = "B";
    public static final String MODE_COMPRESS = "C";

    private String mode;

    public ModeRequest(String mode) {
        this.mode = mode;
    }

    public static ModeRequest getStreamModeRequest() {
        return new ModeRequest(MODE_STREAM);
    }

    public static ModeRequest getBlockModeRequest() {
        return new ModeRequest(MODE_BLOCK);
    }

    public static ModeRequest getCompressModeRequest() {
        return new ModeRequest(MODE_COMPRESS);
    }

    @Override
    public String getRequest() {
        return "MODE " + this.mode;
    }
}
