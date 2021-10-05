package com.wf.myblog.Service;

import com.wf.myblog.Bean.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserService {
    //核对用户名和密码
    User checkUser(String username, String password);
    //查所有用户
    List<User> findAll();
}
