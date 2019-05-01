package com.wlj.springbootcar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @author LB
 * @create 2019-04-23 12:31
 */
@Controller
public class LoginOutController {

    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("user");
        session.invalidate();
        return "redirect:/login";
    }
}
