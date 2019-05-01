package com.wlj.springbootcar.controller;

import com.wlj.springbootcar.bean.User;
import com.wlj.springbootcar.dao.BookMapper;
import com.wlj.springbootcar.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author LB
 * @create 2019-04-21 14:15
 */
@Controller
public class LoginController {

    @Autowired
    private UserMapper userMapper ;

    @GetMapping("/login")
    public String login(){
        return "login";
    }


    @PostMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("userpassword") String userpassword, @RequestParam("userType") int userType , @RequestParam("validateCode") String validateCode, HttpServletRequest request ,Map<String, Object> map){
        User user = userMapper.login(username, userpassword);
        String rightCode = ((String) request.getSession().getAttribute("checkcode")).toUpperCase();
        validateCode = validateCode.toUpperCase();
        HttpSession session = request.getSession();
        if(rightCode.equals(validateCode)){
            if(null == user){
                map.put("msg","用户名或密码登录错误" );
                return "login";
            }else{
                if(userType == 0){
                    if(user.getUser_level_id() == 0){
                        session.setAttribute("user",user );
                        return "redirect:/page";
                    }else{
                        return "403";
                    }
                }
                if(userType == 1){
                    if(user.getUser_level_id() == 1){
                        session.setAttribute("user",user );
                        return "redirect:/page";
                    }else{
                        return "403";
                    }
                }
                return "403";
            }
        }else{
            map.put("msg","验证码输入错误" );
            return "login";
        }
    }
}
