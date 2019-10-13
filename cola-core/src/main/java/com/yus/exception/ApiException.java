package com.yus.exception;

import org.apache.commons.lang3.StringUtils;

/**
 * @description API接口请求的统一异常类【SOA所提供的服务采用此异常来统一处理错误信息的返回】
 * 通过该异常类统一将出错信息返回给消费端
 */
public class ApiException extends RuntimeException {
    private static final long serialVersionUID = 2685287081293576410L;
    private String errCode;
    private String message;
    private Object[] args;
    private boolean runtime;

    public ApiException() {
    }

    public ApiException(String message) {
        super(message);
        this.message = message;
    }

    public ApiException(String code, String message) {
        super(message);
        this.errCode = code;
        this.message = message;
    }

    public ApiException(String message, Throwable cause) {
        super(message, cause);
        this.message = message;
    }

    public ApiException(String errCode, String message, Throwable cause) {
        super(message, cause);
        this.errCode = errCode;
    }

    public ApiException(Throwable e) {
        super(e);
        this.errCode = e.getClass().getName();
        this.message = StringUtils.join(new String[]{this.errCode, " - ", e.getMessage()});
        this.runtime = true;
    }

    /**
     * 当带有参数时，文本将通过 String.format 进行相应格式化
     */
    public ApiException(String code, String message, Object... args) {
        this.errCode = code;
        this.message = message;
        this.args = args;
        this.resolveMessage();
    }

    /**
     * 当带有参数时，文本将通过 String.format 进行相应格式化
     */
    public ApiException(BaseExceptionCode baseExceptionCode, Object... args) {
        this.errCode = baseExceptionCode.getCode();
        this.message = baseExceptionCode.getMessage();
        this.args = args;
        this.resolveMessage();
    }

    @Override
    public Throwable fillInStackTrace() {
        return this;
    }

    private void resolveMessage() {
        if (StringUtils.isBlank(this.message) || this.args == null || this.args.length < 1)
            return;
        this.message = String.format(this.message, this.args);
    }


    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object[] getArgs() {
        return args;
    }

    public void setArgs(Object[] args) {
        this.args = args;
    }

    public boolean isRuntime() {
        return this.runtime;
    }

    public void setRuntime(boolean runtime) {
        this.runtime = runtime;
    }
}
