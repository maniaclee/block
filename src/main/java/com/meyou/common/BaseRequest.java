package com.meyou.common;

/**
 * Created by lipeng on 2018/3/25.
 */
public class BaseRequest extends AbstractDTO{
    private static final long serialVersionUID = -5107437621062496682L;
    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
