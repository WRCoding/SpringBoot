package com.wlj.springbootcar.controller;

import com.wlj.springbootcar.bean.Book;
import com.wlj.springbootcar.bean.Car;
import com.wlj.springbootcar.bean.User;
import com.wlj.springbootcar.dao.BookMapper;
import com.wlj.springbootcar.dao.UserMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @author LB
 * @create 2019-04-23 16:17
 */
@Controller
public class UserController {

    @Autowired
    UserMapper userMapper;
    @Autowired
    BookMapper bookMapper;

    @PutMapping("/user")
    public String update(@RequestParam("userName") String userName, @RequestParam("userPassword") String userPassword, @RequestParam("userId") String userId, HttpSession session){
        User user = (User) session.getAttribute("user");
        user.setUser_name(userName);
        user.setUser_password(userPassword);
        user.setUser_id(Integer.valueOf(userId));
        int index = userMapper.update(user);
        if(index >0){
            session.setAttribute("user",user );
            session.setAttribute("msg","修改成功" );
            return "redirect:/userup";
        }else{
            session.setAttribute("user",user );
            session.setAttribute("msg","修改失败" );
            return "redirect:/userup";
        }
    }
    @PostMapping("/user")
    public String addCar(@Param("bookId") String bookId,@Param("number") String number,@Param("pageNum") String pageNum,HttpSession session){
        Book book = bookMapper.getBook(Integer.parseInt(bookId));
        List<Car> carList = (List<Car>) session.getAttribute("carList");
        System.out.println(carList == null);
        if(carList == null){
            carList = new ArrayList<>();
            Car car = new Car();
            car.setBook(book);
            car.setNumber(Integer.parseInt(number));
            carList.add(car);
        }else{
            boolean flag=false;
            for (Car car : carList) {
                if(car.getBook().getBookId().equals(Integer.parseInt(bookId))){
                    car.setNumber(car.getNumber() + Integer.parseInt(number));
                    flag = true;
                }
            }
            if(!flag){
                Car car = new Car();
                car.setBook(book);
                car.setNumber(Integer.parseInt(number));
                carList.add(car);
            }
        }
        session.setAttribute("carList",carList );
        return "redirect:/page?pageNum"+Integer.parseInt(pageNum);
    }
    @DeleteMapping("/user/{bookId}")
    public String delete(@PathVariable("bookId") String bookid, HttpSession session){
        List<Car> carList = (List<Car>) session.getAttribute("carList");
        for (int i = 0;i<carList.size();i++) {
            if (carList.get(i).getBook().getBookId().equals(Integer.parseInt(bookid))){
                carList.remove(i);
            }
        }
        return "redirect:/usercar";

    }
    @DeleteMapping("/user")
    public String delete( HttpSession session){
        session.removeAttribute("carList");
        session.removeAttribute("totalPrice");
        return "redirect:/usercar";
    }
    @GetMapping("/user")
    public String total(HttpSession session){
        List<Car> carList = (List<Car>) session.getAttribute("carList");
        double totalPrice = 0;
        for (Car car : carList) {
            totalPrice += car.getBook().getBookSprice()*car.getNumber();
        }
        session.setAttribute("totalPrice",totalPrice );
        return "redirect:/usercar";
    }
    @PostMapping("/user/regist")
    public String regist(@Param("userName")String userName,@Param("userPassword")String userPassword, HttpSession session){

        User user = new User(1,userName ,userPassword );

        session.removeAttribute("regMsg");
        userMapper.regist(user);
        session.setAttribute("regMsg","用户注册成功" );
        return "redirect:/regist";

    }
}
