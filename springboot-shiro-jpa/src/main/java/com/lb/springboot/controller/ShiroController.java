package com.lb.springboot.controller;

import com.lb.springboot.dao.UserDao;
import com.lb.springboot.pojo.User;
import com.lb.springboot.utils.MD5Utils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @author LB
 * @create 2019-05-07 19:40
 */
@Controller
public class ShiroController {

    @Autowired
    UserDao userDao;

    @RequestMapping("/login")
    public String loginn(){
        return "login";
    }

    @RequestMapping("/register")
    public String register(User user){
        System.out.println(user.getName()+"---"+user.getPassword());
        String password = MD5Utils.md5(user);
        user.setPassword(password);
        userDao.save(user);
        return "login";
    }
    @RequestMapping("/login.action")
    public String login(String username, String password, Model model, HttpSession session){
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username,password );
        try{
            subject.login(token);
            System.out.println(subject.isAuthenticated());
            User user = (User) subject.getPrincipal();
            session.setAttribute("user",user );
            return "main";
        }catch (UnknownAccountException e){
            model.addAttribute("msg","用户名错误" );
            return "login";
        }catch (IncorrectCredentialsException e){
            model.addAttribute("msg","密码错误" );
            return "login";
        }
    }
}
