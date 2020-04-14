package club.banyuan.cqmall.advice;

import club.banyuan.cqmall.common.CommonResult;
import club.banyuan.cqmall.common.ReqFailException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RequestExceptionHandler {
    @ExceptionHandler(ReqFailException.class)
    public CommonResult runtimeException(RuntimeException runtimeException){
        return CommonResult.failed(runtimeException.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public CommonResult ArgumentNotValidException(MethodArgumentNotValidException arguement){
        return CommonResult.badRuquest(arguement.getMessage());
    }
}
