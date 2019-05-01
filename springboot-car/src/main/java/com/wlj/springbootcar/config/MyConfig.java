package com.wlj.springbootcar.config;

import com.wlj.springbootcar.component.LoginHandlerInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author LB
 * @create 2019-04-21 14:09
 */
@Configuration
public class MyConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/main").setViewName("main");
        registry.addViewController("/userup").setViewName("user/user-update");
        registry.addViewController("/usercar").setViewName("user/user-cart");
        registry.addViewController("/search").setViewName("search");
        registry.addViewController("/addbook").setViewName("admin/admin-book-add");
        registry.addViewController("/imoprt").setViewName("admin/admin-book-import");
        registry.addViewController("/regist").setViewName("register");
    }

    //注册拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**").excludePathPatterns("/","/login.html","/login","/resource/**","/webjars/**","/img","/regist","/user/regist");
    }
}
