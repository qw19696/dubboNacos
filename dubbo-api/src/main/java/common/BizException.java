package common;
import common.IErrorCode;

public class BizException extends RuntimeException {

    private int code;

    public static BizException create(IErrorCode errorCode) {
        return new BizException(errorCode);
    }

    public static BizException create(IErrorCode errorCode, String msg) {
        return create(errorCode.getCode(), msg);
    }

    public static BizException create(int code, String msg) {
        return new BizException(code, msg);
    }

    public BizException(Integer code, String msg) {
        super(msg);
        this.code = code;
    }

    public BizException(IErrorCode errorCode) {
        super(errorCode.getMessage());
        this.code = errorCode.getCode();
    }

    public int getCode() {
        return code;
    }

}
