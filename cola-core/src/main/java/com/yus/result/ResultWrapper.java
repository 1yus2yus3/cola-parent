package com.yus.result;


import com.yus.exception.ApiException;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @description
 */
public class ResultWrapper {
    /**
     * 成功返回（带提示信息）
     */
    public static Map<String, Object> success(String message) {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("success", true);
        map.put("message", message);
        return map;
    }

    /**
     * 成功返回（带有返回值）
     */
    public static Map<String, Object> success(Object data) {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("success", true);
        map.put("data", data);
        return map;
    }

    /**
     * 失败返回（带错误信息）
     */
    public static Map<String, Object> fail(String errorMsg) {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("success", false);
        map.put("message", errorMsg);
        return map;
    }

    /**
     * 失败返回（带标准错误code与信息）
     */
    public static Map<String, Object> fail(BaseResultCode baseResultCode) {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("success", false);
        map.put("code", baseResultCode.getCode());
        map.put("message", baseResultCode.getMessage());
        return map;
    }

    /**
      * @author Clark
      * @date 2018/5/2 17:42
      * @param
      * @return
      * @description 返回 ApiException 错误信息
    **/
    public static Map<String, Object> fail(ApiException apiException) {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("success", false);
        if (apiException.getErrCode() != null) {
            map.put("code", apiException.getErrCode());
        }
        map.put("message", apiException.getMessage());
        return map;
    }
}
