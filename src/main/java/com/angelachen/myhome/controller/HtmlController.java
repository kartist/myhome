package com.angelachen.myhome.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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

}
