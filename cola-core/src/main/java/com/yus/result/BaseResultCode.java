package com.yus.result;

/**
 * @description
 */
public interface BaseResultCode {
    /**
     * 获取错误码
     */
    public int getCode();

    /**
     * 获取错误消息
     */
    public String getMessage();
}
