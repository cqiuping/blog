package com.boot.test.demo.controller.backend;

import com.boot.test.demo.entity.Blog;
import com.boot.test.demo.entity.JsonResp;
import com.boot.test.demo.entity.User;
import com.boot.test.demo.service.BlogService;

import com.sun.org.apache.bcel.internal.util.ClassPath;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

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
    private static final Logger logger = LogManager.getLogger(MvcController.class);

    @Autowired
    private BlogService blogService;

    @Value("${main.classpath}")
   private String path;

    @Autowired
    private ApplicationContext context;

    @RequestMapping(value = "/saveBlog", method = RequestMethod.POST)
    public JsonResp saveHtml(@RequestBody String content) {
        Blog blog = new Blog();
        blog.setContent(content);
        try {
            blogService.saveBlog(blog);
            return JsonResp.success();
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResp.fail("存储博客失败");
        }
    }

    @RequestMapping(value = "testJson", method = RequestMethod.POST)
    public JsonResp testJson(@RequestBody User user) {
        System.out.println(user.getUsername());
        return JsonResp.success(user);
    }


    @RequestMapping(value = "/getBlog/{id}", method = RequestMethod.GET)
    public JsonResp getBlogById(@PathVariable("id") Integer id) {
        try {
            Blog blog = blogService.getBlogById(id);
            System.err.println(blog.getContent());
            return JsonResp.success(blog);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResp.fail("获取博客失败");
        }
    }

    @RequestMapping(value="/uploadPic",method=RequestMethod.POST)
    public void hello(HttpServletRequest request,HttpServletResponse response,@RequestParam(value = "editormd-image-file", required = false) MultipartFile attach){
        try {
            request.setCharacterEncoding( "utf-8" );
            response.setCharacterEncoding("utf-8");
            response.setHeader( "Content-Type" , "text/html" );
//            String rootPath = request.getSession().getServletContext().getRealPath("/static/upload/");
//            String rootPath = String.valueOf(getClass().getResource("/static/upload"));
           String rootPath =path + "/static/upload";


            /**
             * 文件路径不存在则需要创建文件路径
             */
            File filePath=new File(rootPath);
            if(!filePath.exists()){
                filePath.mkdirs();
            }

            //最终文件名
            File realFile=new File(rootPath+File.separator+attach.getOriginalFilename());
            logger.info("文件路径:" + realFile);
            attach.transferTo(realFile);
//            FileUtils.copyInputStreamToFile(attach.getInputStream(), realFile);

            //下面response返回的json格式是editor.md所限制的，规范输出就OK
            response.getWriter().write( "{\"success\": 1, \"message\":\"上传成功\",\"url\":\"/static/upload/" + attach.getOriginalFilename() + "\"}" );
        } catch (Exception e) {
            try {
                response.getWriter().write( "{\"success\":0}" );
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

}
