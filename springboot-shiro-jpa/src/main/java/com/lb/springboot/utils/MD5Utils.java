package com.lb.springboot.utils;

import com.lb.springboot.pojo.User;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * @author LB
 * @create 2019-05-07 19:46
 */
public class MD5Utils {
    public static String md5(User user){
        String name = "MD5";
        String pwd = user.getPassword();
        ByteSource salt = ByteSource.Util.bytes(user.getName());
        int num = 2;

        Object result = new SimpleHash(name,pwd ,salt ,num );
        System.out.println(result);
        return result.toString();
    }
}
