package com.wf.myblog.Service;


import com.wf.myblog.Bean.Blog;
import com.wf.myblog.Dao.BlogDao;
import com.wf.myblog.queryenc.BlogIndex;
import com.wf.myblog.queryenc.BlogQuery;
import com.wf.myblog.queryenc.BlogTitle;
import com.wf.myblog.queryenc.SearchBlog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements  BlogService{
    @Autowired
    private BlogDao blogDao;


    @Override
    public List<BlogQuery> getAllBlog() {
        return blogDao.getAllBlog();
    }

    @Override
    public List<BlogQuery> getSearchBlog(SearchBlog searchBlog) {
        return blogDao.getByTitleOrTypeOrRecommend(searchBlog);
    }

    @Override
    public Blog getBlogById(Long id) {
        return blogDao.getBlogById(id);
    }
    @Override
    public int saveBlog(Blog blog) {
        return blogDao.saveBlog(blog);
    }

    @Override
    public int updateBlog(Blog blog) {
        return blogDao.updateBlog(blog);
    }

    @Override
    public int deleteBlog(Long id) {
        return blogDao.deleteBlog(id);
    }

    @Override
    public List<BlogIndex> getBlogDigit() {
        return blogDao.getBlogDigit();
    }

    @Override
    public List<BlogTitle> getBlogTitle() {
        return blogDao.getBlogTitle();
    }

    @Override
    public BlogIndex getBlogDigitById(Long id) {
        return blogDao.getBlogDigitById(id);
    }
}
