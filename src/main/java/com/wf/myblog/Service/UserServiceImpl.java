package com.wf.myblog.Service;

import com.wf.myblog.Bean.User;
import com.wf.myblog.Dao.UserDao;
import com.wf.myblog.Utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User checkUser(String username, String password) {
        User user = userDao.findByUsernameAndPassword(username, MD5Utils.code(password));
        return user;
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }


}
