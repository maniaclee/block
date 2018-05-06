package com.meyou.common;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;

/**
 * Created by lipeng on 2017/9/10.
 */
public class AbstractDTO implements Serializable{



    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
