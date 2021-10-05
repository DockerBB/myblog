package com.wf.myblog.Service;

import com.wf.myblog.Bean.Blog;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogService {
    List<Blog> getAllBlog();
}
