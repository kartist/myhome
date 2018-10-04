package com.angelachen.myhome.common.util;

import com.angelachen.myhome.common.exception.AccessException;
import com.angelachen.myhome.common.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author Kartist 2018/10/3 21:47
 */
public class UserUtil {

    public static User getUser(HttpServletRequest request) {
        return getUser(request.getSession());
    }

    public static User getUser(HttpSession session) {
        return (User) session.getAttribute("user");
    }

    public static User getGoodUser(HttpServletRequest request) {
        return getGoodUser(request);
    }

    public static User getGoodUser(HttpSession session) {
        User user = getUser(session);
        if (user == null) {
            throw new AccessException("用户未登陆");
        }
        return user;
    }
}
