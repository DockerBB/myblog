package com.wf.myblog.Service;


import com.wf.myblog.Bean.Blog;
import com.wf.myblog.Dao.BlogDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements  BlogService{
    @Autowired
    private BlogDao blogDao;

    @Override
    public List<Blog> getAllBlog() {
        return blogDao.getAllBlog();
    }
}
