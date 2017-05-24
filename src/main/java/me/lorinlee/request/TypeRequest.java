package me.lorinlee.request;

/**
 * Created by lorin on 17-5-23.
 */
public class TypeRequest extends Request {

    public static final String DATATYPE_ASCII = "A";
    public static final String DATATYPE_EBCDIC = "E";
    public static final String DATATYPE_BINARY = "I";

    private String datatype;

    public TypeRequest(String datatype) {
        this.datatype = datatype;
    }

    public static TypeRequest getAsciiTypeRequest() {
        return new TypeRequest(DATATYPE_ASCII);
    }

    public static TypeRequest getEbcdicTypeRequest() {
        return new TypeRequest(DATATYPE_EBCDIC);
    }

    public static TypeRequest getBinaryTypeRequest() {
        return new TypeRequest(DATATYPE_BINARY);
    }

    @Override
    public String getRequest() {
        return "TYPE " + datatype;
    }
}
