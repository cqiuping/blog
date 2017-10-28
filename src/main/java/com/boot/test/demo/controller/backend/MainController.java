package com.boot.test.demo.controller.backend;

import com.boot.test.demo.entity.JsonResp;
import com.boot.test.demo.entity.User;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author <a href="mailto:chengqiuping@wxchina.com ">qiuping.Cheng</a>
 * @Date 2017/10/11
 * @Version 1.0.0
 */
@RestController
@RequestMapping("backend")
@EnableAutoConfiguration
public class MainController {

    @RequestMapping(value = "/loginUser")
    public JsonResp getLoginUser(){
        Subject subject = SecurityUtils.getSubject();
        if(subject!=null){
            User loginUser = (User) subject.getSession().getAttribute("user");
            return JsonResp.success(loginUser);
        }
        else return JsonResp.fail("没有登陆用户");

    }
}
