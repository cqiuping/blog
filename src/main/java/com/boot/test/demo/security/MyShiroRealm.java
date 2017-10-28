package com.boot.test.demo.security;

import com.boot.test.demo.entity.User;
import com.boot.test.demo.service.UserService;
import com.sun.media.jfxmedia.logging.Logger;
import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import sun.rmi.runtime.Log;

/**
 * @Description
 * @Author <a href="mailto:chengqiuping@wxchina.com ">qiuping.Cheng</a>
 * @Date 2017/9/27
 * @Version 1.0.0
 */
public class MyShiroRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken)
            throws AuthenticationException {
        System.out.println("MyShiroRealm.doGetAuthenticationInfo()");
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String username = token.getUsername();
        if(username == null){
            throw new AccountException("用户名不能为空!!!");
        }
        System.out.println(username);
        User user = userService.findUserByUsername(username);
        System.out.println("------user--->" + user);
        try {
            return new SimpleAuthenticationInfo(user.getUsername(),user.getPassword(),getName());

        }catch (UnknownAccountException e){
            throw e;
        }catch (RuntimeException e){
            throw e;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
