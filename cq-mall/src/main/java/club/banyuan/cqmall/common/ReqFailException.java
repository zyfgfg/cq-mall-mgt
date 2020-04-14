package club.banyuan.cqmall.common;

public class ReqFailException extends RuntimeException {
    public ReqFailException() {
        super();
    }

    public ReqFailException(String message) {
        super(message);
    }

    public ReqFailException(String message, Throwable cause) {
        super(message, cause);
    }

    public ReqFailException(Throwable cause) {
        super(cause);
    }

    protected ReqFailException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
