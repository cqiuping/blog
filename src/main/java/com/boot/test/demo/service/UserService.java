package com.boot.test.demo.service;

import com.boot.test.demo.entity.User;
import com.boot.test.demo.mapper.UserMapper;
import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2017/8/13.
 */
@Component
public class UserService extends BaseService {

    public List<User> findAllUsers() {
        SqlSession sqlsession = sqlSessionFactory.openSession();
        try {
            return sqlsession.getMapper(UserMapper.class).findAllUsers();
        } finally {
            sqlsession.close();
        }
    }

    public User findUserByUsername(String username){
        SqlSession sqlsession = sqlSessionFactory.openSession();
        try {
            return sqlsession.getMapper(UserMapper.class).findUserByUsername(username);
        } finally {
            sqlsession.close();
        }
    }
}