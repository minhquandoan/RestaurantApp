package minhquan.com.exception;

public enum ErrorType {

    BAD_REQUEST_EXCEPTION(4004, "The input was not valid"),
    INTERNAL_EXCEPTION(5000, "Something went wrong"),
    ;
    private final int errorCode;
    private final String description;

    private ErrorType(int code, String description) {
        this.errorCode = code;
        this.description = description;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getDescription() {
        return description;
    }
}
