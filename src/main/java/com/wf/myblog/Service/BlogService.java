package com.wf.myblog.Service;

import com.wf.myblog.Bean.Blog;
import com.wf.myblog.queryenc.BlogQuery;
import com.wf.myblog.queryenc.SearchBlog;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogService {
    List<BlogQuery> getAllBlog();

    List<BlogQuery> getSearchBlog(SearchBlog searchBlog);

    Blog getBlogById(Long id);

    int saveBlog(Blog blog);

    int updateBlog(Blog blog);

    int deleteBlog(Long id);
}
