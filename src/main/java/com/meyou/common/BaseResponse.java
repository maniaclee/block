package com.meyou.common;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * Created by lipeng on 16/8/6.
 */
public class BaseResponse<T> extends AbstractDTO implements Serializable {
    private static final long serialVersionUID = 5457463874268777284L;
    private boolean success = true;

    private String errorMsg;
    private String errorCode;
    private Map<String,Object > extra;
    private T data;

    public static <T> BaseResponse<T> success(T data) {
        BaseResponse<T> re = new BaseResponse<>();
        re.setData(data);
        re.setSuccess(true);
        return re;
    }

    public BaseResponse<T> put(String key, Object value) {
        if (extra == null) {
            extra = new HashMap<>();
        }
        extra.put(key, value);
        return this;
    }

    public BaseResponse<T> extra(Map<String, Object> extra) {
        this.extra = extra;
        return this;
    }

    public static <T> BaseResponse<T> error(String errorMsg) {
        return error(null,errorMsg);
    }
    public static <T> BaseResponse<T> error(String errorCode,String errorMsg) {
        BaseResponse<T> re = new BaseResponse<>();
        re.setSuccess(false);
        re.setErrorMsg(errorMsg);
        re.setErrorCode(errorCode);
        return re;
    }

    public boolean isSuccessAndNotNull() {
        return success && data != null;
    }

    public T fetchResultNotNullOrThrow(Function<BaseResponse,RuntimeException> ex) {
        if (!isSuccessAndNotNull()) {
            throw ex.apply(this);
        }
        return getData();
    }
    public T fetchResultOrThrow(Function<BaseResponse,RuntimeException> ex) {
        if (!isSuccess()) {
            throw ex.apply(this);
        }
        return getData();
    }
    public T fetchResultOrNull() {
        if (!isSuccess()) {
            return null;
        }
        return getData();
    }


    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    /**
     * Getter method for property   errorCode.
     *
     * @return property value of errorCode
     */
    public String getErrorCode() {
        return errorCode;
    }

    /**
     * Setter method for property   errorCode .
     *
     * @param errorCode  value to be assigned to property errorCode
     */
    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
}