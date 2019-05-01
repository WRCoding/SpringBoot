package com.wlj.springbootcar.controller;

import com.wlj.springbootcar.bean.Book;
import com.wlj.springbootcar.dao.BookMapper;
import com.wlj.springbootcar.dao.UserMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;
import java.io.StringReader;

/**
 * @author LB
 * @create 2019-04-25 20:23
 */
@Controller
public class AdminController {
    @Autowired
    UserMapper userMapper;
    @Autowired
    BookMapper bookMapper;

    @GetMapping("/admin")
    public String updateBook(@PathParam("bookId")String bookId,@PathParam("pageNum")String pageNum,Model model){
        model.addAttribute("bookId",bookId );
        model.addAttribute("pageNum",pageNum );
        model.addAttribute("book",bookMapper.getBook(Integer.parseInt(bookId)) );
        return "admin/admin-book-update";
    }
    @PutMapping("/admin")
    public String updateBook(@Param("book")Book book,Model model){
        int index = bookMapper.updateBook(book);
        if(index>0){
            model.addAttribute("msg","更新成功" );
            return "admin/admin-book-update";
        }else{
            model.addAttribute("msg","更新失败" );
            return "admin/admin-book-update";
        }
    }
    @PostMapping("/admin")
    public String addBook(@PathParam("book")Book book, Model model){
        int index = bookMapper.addBook(book);
        if(index>0){
            model.addAttribute("msg","图书添加成功" );
            return "admin/admin-book-add";
        }else{
            model.addAttribute("msg","图书添加失败" );
            return "admin/admin-book-add";
        }
    }
    @DeleteMapping("/admin/{bookId}")
    public String deleteBook(@PathVariable("bookId")String bookId, HttpSession session,@Param("pageNum")String pageNum){
        bookMapper.deleteBook(Integer.parseInt(bookId));
        session.setAttribute("pageNum",pageNum );
        System.out.println(pageNum);
        return "forward:/page";
    }
}
