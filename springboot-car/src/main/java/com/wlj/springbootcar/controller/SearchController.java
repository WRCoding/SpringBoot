package com.wlj.springbootcar.controller;

import com.wlj.springbootcar.bean.Book;
import com.wlj.springbootcar.bean.Page;
import com.wlj.springbootcar.bean.User;
import com.wlj.springbootcar.dao.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author LB
 * @create 2019-04-23 20:39
 */
@Controller
public class SearchController {

    @Autowired
    BookMapper bookMapper;

    @GetMapping("/searchBook")
    public String search(@RequestParam("key") String key, Model model,HttpSession session){
        User user = (User) session.getAttribute("user");
        List<Book> booklist = bookMapper.searchBook(key);
        Page page = new Page();
        page.setBooklist(booklist);
        model.addAttribute("page",page );
        if(user.getUser_level_id() == 0){
            return "admin/admin-book-main";
        }else{
            return "main";
        }
    }
}
