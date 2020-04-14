package club.banyuan.cqmall.common;

public class CommonResult {
    private int code;
    private Object data;
    private String message;

    public CommonResult() {
    }

    public CommonResult(int code, Object data, String message) {
        this.code = code;
        this.data = data;
        this.message = message;
    }

    public CommonResult(Object data, CodeResult codeResult) {
        this(codeResult.getCode(), data, codeResult.getMessage());
    }

    public CommonResult(CodeResult codeResult) {
        this(codeResult.getCode(), codeResult.getMessage(), codeResult.getMessage());
    }

    public static CommonResult success(Object data) {
        return new CommonResult(data,CodeResult.SUCCESS);
    }

    public static CommonResult failed(Object data) {
        return new CommonResult(data,CodeResult.FAILED);
    }

    public static CommonResult failed() {
        return new CommonResult("未知错误",CodeResult.FAILED);
    }

    public static CommonResult unauthorized(Object data) {
        return new CommonResult(data,CodeResult.UNAUTHORIZED);
    }

    public static CommonResult unauthorized() {
        return new CommonResult(CodeResult.UNAUTHORIZED.getMessage(),CodeResult.UNAUTHORIZED);
    }

    public static CommonResult forbidden() {
        return new CommonResult(CodeResult.FORBIDDEN);
    }

    public static CommonResult badRuquest(Object data) {
        return new CommonResult(data,CodeResult.BAD_REQUEST);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "CommonResult{" +
                "code='" + code + '\'' +
                ", data='" + data + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
