package com.boot.test.demo.controller.backend;

import com.boot.test.demo.entity.Blog;
import com.boot.test.demo.entity.JsonResp;
import com.boot.test.demo.entity.User;
import com.boot.test.demo.service.BlogService;
import java.lang.reflect.Method;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author <a href="mailto:chengqiuping@wxchina.com ">qiuping.Cheng</a>
 * @Date 2017/10/12
 * @Version 1.0.0
 */
@RestController
@RequestMapping("backend/blog")
@EnableAutoConfiguration
public class BlogController {

    @Autowired
    private BlogService blogService;

    @RequestMapping(value = "/saveBlog",method = RequestMethod.POST)
    public JsonResp saveHtml(@RequestBody String content){
        Blog blog = new Blog();
        blog.setContent(content);
        try{
            blogService.saveBlog(blog);
            return JsonResp.success();
        }catch (Exception e){
            e.printStackTrace();
            return JsonResp.fail("存储博客失败");
        }
    }

    @RequestMapping(value = "testJson", method = RequestMethod.POST)
    public JsonResp testJson(@RequestBody User user){
        System.out.println(user.getUsername());
        return JsonResp.success(user);
    }


    
    @RequestMapping(value="/getBlog/{id}",method = RequestMethod.GET)
    public JsonResp getBlogById(@PathVariable("id") Integer id){
       try{
           Blog blog = blogService.getBlogById(id);
           System.err.println(blog.getContent());
           return JsonResp.success(blog);
       }catch (Exception e){
           e.printStackTrace();
           return JsonResp.fail("获取博客失败");
       }
    }

}
