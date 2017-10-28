package com.boot.test.demo.mapper;

import com.boot.test.demo.entity.Blog;
import org.apache.ibatis.annotations.Param;

/**
 * @Description
 * @Author <a href="mailto:chengqiuping@wxchina.com ">qiuping.Cheng</a>
 * @Date 2017/10/12
 * @Version 1.0.0
 */
public interface BlogMapper {

    void saveBlog(Blog blog);
    Blog getBlogById(@Param("id") int id);
}
