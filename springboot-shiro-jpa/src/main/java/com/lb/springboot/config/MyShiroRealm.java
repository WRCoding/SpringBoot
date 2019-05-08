package com.lb.springboot.config;

import com.lb.springboot.dao.UserDao;
import com.lb.springboot.pojo.Premisson;
import com.lb.springboot.pojo.Role;
import com.lb.springboot.pojo.User;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author LB
 * @create 2019-05-07 15:46
 */
public class MyShiroRealm extends AuthorizingRealm {
    @Autowired
    UserDao userDao;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("权限配置-->MyShiroRealm.doGetAuthorizationInfo()");
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        User user  = (User) principals.getPrimaryPrincipal();
        for(Role role:user.getRoleList()){//从当前的用户获取该用户具有的所有角色
            authorizationInfo.addRole(role.getRole());
            for(Premisson p:role.getPermissions()){
                authorizationInfo.addStringPermission(p.getPermission());
            }
        }
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("-----认证----");
        UsernamePasswordToken token1 = (UsernamePasswordToken) token;
        String name =  token1.getUsername();//获得前端用户输入的名字
        User user = userDao.findByName(name);//从数据库查询，返回用户
        if(null == user){
            return null;
        }
        Object salt = ByteSource.Util.bytes(name);//加用户名为盐
        return new SimpleAuthenticationInfo(user,user.getPassword(), (ByteSource) salt,getName());
    }
}
