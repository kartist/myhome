package com.angelachen.myhome.controller;

import com.angelachen.myhome.common.model.User;
import com.angelachen.myhome.common.util.UserUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Kartist 2018/9/21 22:39
 */
@Controller()
public class HtmlController {

    @GetMapping("/index")
    public String index() {
        return "index";
    }


    @GetMapping("/comment.html")
    public String commentHtml() {

        return "comment/index";
    }

    @GetMapping("/home/index")
    public String livingRoom(HttpServletRequest request) {
        User user = UserUtil.getGoodUser(request);
        request.setAttribute("name", user.getName());
        return "livingRoom";
    }

}
