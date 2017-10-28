package com.boot.test.demo.service;

import com.boot.test.demo.entity.Blog;
import com.boot.test.demo.mapper.BlogMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author <a href="mailto:chengqiuping@wxchina.com ">qiuping.Cheng</a>
 * @Date 2017/10/12
 * @Version 1.0.0
 */
@Component
public class BlogService extends BaseService{
    public void saveBlog(Blog blog) {
        SqlSession sqlsession = sqlSessionFactory.openSession();
        try {
             sqlsession.getMapper(BlogMapper.class).saveBlog(blog);
             sqlsession.commit();
        } finally {
            sqlsession.close();
        }
    }

    public Blog getBlogById(int id) {
        SqlSession sqlsession = sqlSessionFactory.openSession();
        try {
            return sqlsession.getMapper(BlogMapper.class).getBlogById(id);
        } finally {
            sqlsession.close();
        }
    }
}
