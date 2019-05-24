package com.lb.springboot.service;

import com.lb.springboot.bean.Book;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @author LB
 * @create 2019-05-24 8:53
 */
@Service
public class BookService {
    //监听消息队列的内容
//    @RabbitListener(queues = "atguigu.emps")
//    public void receive(int i){
//        System.out.println("1收到消息："+i);
//    }
//    @RabbitListener(queues = "atguigu.emps")
//    public void receive2(int i){
//        System.out.println("2收到消息："+i);
//    }
}
