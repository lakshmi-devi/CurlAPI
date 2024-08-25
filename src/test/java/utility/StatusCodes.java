package utility;

public enum StatusCodes {


    SUCCESS(200, "request processed successfully");

    public final int code;
    public final String msg;


    StatusCodes(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}


