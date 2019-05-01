package com.wlj.springbootcar.controller;

import com.wlj.springbootcar.bean.Page;
import com.wlj.springbootcar.bean.User;
import com.wlj.springbootcar.dao.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @author LB
 * @create 2019-03-30 17:33
 */
@Controller
public class PageUserController {

    @Autowired
    BookMapper bookMapper;

    @RequestMapping("/page")
    public  String getPageUser(Model model, HttpServletRequest request, HttpSession session){
        User user = (User) session.getAttribute("user");

        String pageNum = request.getParameter("pageNum") == null?"1":request.getParameter("pageNum");
        int totalRecord = bookMapper.BookSize();

        Page page = new Page(Integer.parseInt(pageNum),7 ,totalRecord );
        int startIndex = page.getStartIndex();
        Map<String,Integer> map = new HashMap<>();
        map.put("startIndex",startIndex );
        map.put("pageSize",7 );
        page.setBooklist(bookMapper.Books(map));
        model.addAttribute("page",page );
        if(user.getUser_level_id() == 0){
            return "admin/admin-book-main";
        }else{
            return "main";
        }
    }
}
