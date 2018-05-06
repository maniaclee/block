package com.meyou.common;

/**
 * Created by lipeng on 2018/2/10.
 */
public interface TemplateService<T> {
    T run() throws Exception;
}
