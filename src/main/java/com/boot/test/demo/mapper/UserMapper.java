package com.boot.test.demo.mapper;


import com.boot.test.demo.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * Created by Administrator on 2017/8/13.
 */
public interface UserMapper {

     List<User> findAllUsers();

     User findUserByUsername(@Param("username") String username);

}
