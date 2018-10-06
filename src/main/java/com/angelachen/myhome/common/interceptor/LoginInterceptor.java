package com.angelachen.myhome.common.interceptor;

import com.alibaba.fastjson.JSON;
import com.angelachen.myhome.common.model.JsonResult;
import com.angelachen.myhome.common.model.User;
import com.angelachen.myhome.common.util.UserUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.io.PrintWriter;

/**
 * @author Kartist 2018/10/6 12:39
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        User user = UserUtil.getUser(request);
        if (user == null) {
            if (request.getMethod().equalsIgnoreCase("get")) {
                response.sendRedirect("/");
            } else {
                OutputStream os = response.getOutputStream();
                final PrintWriter printWriter = new PrintWriter(os);
                printWriter.write(JSON.toJSONString(new JsonResult(JsonResult.ResultState.ACCESS_REFUSED)));
                printWriter.flush();
                printWriter.close();
            }
            return false;
        }
        return true;
    }
}
