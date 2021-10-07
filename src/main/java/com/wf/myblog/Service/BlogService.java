package com.wf.myblog.Service;

import com.wf.myblog.Bean.Blog;
import com.wf.myblog.queryenc.BlogQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogService {
    List<BlogQuery> getAllBlog();

    Blog getBlogById(Long id);

    int saveBlog(Blog blog);

    int updateBlog(Blog blog);

    int deleteBlog(Long id);
}
