package club.banyuan.cqmall.common;

public enum CodeResult {

    SUCCESS (200,"请求成功"),
    BAD_REQUEST(400,"请求失败"),
    UNAUTHORIZED(401,"认证失败"),
    FORBIDDEN(403,"未授权"),
    FAILED(500,"服务器异常");


    private int code;
    private String message;

    CodeResult(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "CodeResult{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
