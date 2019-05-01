package com.lbnm.springboot.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author LB
 * @create 2019-05-01 10:06
 */
@Slf4j
@Controller
public class WebSocketController {

    @RequestMapping("/websocket/{name}")
    public String webSocket(@PathVariable String name, Model model){
        try {
            log.info("跳转到webSocket的页面上");
            model.addAttribute("userName",name );
            return "websocket";
        }catch (Exception e){
            log.info("跳转到websocket的页面上发送异常: "+e.getMessage());
            return "error";
        }
    }
}
