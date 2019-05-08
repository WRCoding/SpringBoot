package com.lb.springboot.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author LB
 * @create 2019-05-07 22:03
 */
@Controller
public class PermissionController {

    @RequestMapping("/user/view")
    @RequiresPermissions("user:view")
    public String view(){
        return "view";
    }

    @RequestMapping("/user/add")
    @RequiresPermissions("user:add")
    public String add(){
        return "add";
    }

    @RequestMapping("/user/delete")
    @RequiresPermissions("user:delete")
    public String delete(){
        return "delete";
    }

    @RequestMapping("/user/vip")
    @RequiresPermissions("user:vip")
    public String vip(){
        return "vip";
    }
}
