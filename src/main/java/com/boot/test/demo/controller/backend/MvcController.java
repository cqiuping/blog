package com.boot.test.demo.controller.backend;

import com.boot.test.demo.entity.JsonResp;
import com.boot.test.demo.entity.User;
import com.boot.test.demo.service.UserService;
import com.mysql.jdbc.StringUtils;
import java.io.IOException;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.apache.logging.log4j.LogManager;

/**
 * Created by Administrator on 2017/10/8.
 */
@Controller
//@RequestMapping("backend")
@EnableAutoConfiguration
public class MvcController {

    private static final Logger logger = LogManager.getLogger(MvcController.class);

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String login() {
        logger.debug("进入了登陆界面debug");
        logger.warn("进入了登陆界面warn");
        logger.info("进入了登陆页面");
        return "backend/login";
    }

    @RequestMapping("/")
    public String main() {
        return "backend/main";
    }

    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public JsonResp doLogin(@RequestBody User user) {
        String username = user.getUsername();
        String password = user.getPassword();
        if (StringUtils.isEmptyOrWhitespaceOnly(username) || StringUtils
                .isEmptyOrWhitespaceOnly(password)) {
            return JsonResp.fail("账号或密码不能为空");
        }
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            SecurityUtils.getSubject().login(token);
            System.err.println("登陆成功");
            token.clear();
            User loginUser = userService.findUserByUsername(username);
            Session session = SecurityUtils.getSubject().getSession();
            session.setAttribute("user",loginUser);
            return JsonResp.success(loginUser);
        } catch (UnknownAccountException e) {
            return JsonResp.fail("账号或密码错误1");
        } catch (LockedAccountException e) {
            return JsonResp.fail("账号已被锁定");
        } catch (AuthenticationException e) {
            System.err.println("登陆失败啦");
            return JsonResp.fail("账号或密码错误");
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResp.fail("错误");
        }
    }


    @RequestMapping("/editBlog")
    public String editBlog(){
        System.out.println("editBlog");
        return "backend/editBlog";
    }
}
