package com.meyou.common;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lipeng on 2018/2/10.
 */
public class TemplateExecutor {

    private static Logger logger = LoggerFactory.getLogger(TemplateExecutor.class);
    private static List<Class> exclude = Lists.newArrayList(HttpServletRequest.class, HttpServletResponse.class);

    private static ThreadLocal<Map<String, Object>> extra = new ThreadLocal<>();

    public static void put(String key, Object value) {
        Map<String, Object> map = extra.get();
        if (map == null) {
            extra.set(new HashMap<>());
        }
        extra.get().put(key, value);
    }

    public static <T> BaseResponse<T> invoke(String desc, Object request, TemplateService<T> templateService) {
        try {
            T re = templateService.run();
            logger.info("%s invoke success, request[{}] , response[{}]", desc, serial(request), serial(re));
            return BaseResponse.success(re).extra(extra.get());
        } catch (Exception e) {
            logger.error(String.format("%s invoke error, request[%s]", desc, request), serial(request), e);
            return BaseResponse.error("system error");
        } finally {
            extra.remove();
        }
    }

    private static String serial(Object o) {
        if (o == null) {
            return "null";
        }
        for (Class clz : exclude) {
            if (clz.isAssignableFrom(o.getClass())) {
                return "";
            }
        }
        return JSON.toJSONString(o);
    }

}
