package com.meyou.web;

import com.meyou.common.TemplateExecutor;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by lipeng on 2018/5/6.
 */
@Controller
public class UserWebService {

    public void login(HttpServletRequest request) {
        TemplateExecutor.invoke("sdf", request, () -> {
            request.getSession(true).setAttribute("user", null);
            return null;
        });
    }
}
