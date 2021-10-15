package com.wf.myblog.Dao;

import com.wf.myblog.Bean.Blog;
import com.wf.myblog.queryenc.BlogIndex;
import com.wf.myblog.queryenc.BlogQuery;
import com.wf.myblog.queryenc.BlogTitle;
import com.wf.myblog.queryenc.SearchBlog;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface BlogDao {
    List<BlogQuery> getAllBlog();

    int saveBlog(Blog blog);

    int deleteBlog(Long id);

    Blog getBlogById(Long id);

    int updateBlog(Blog blog);

    List<BlogQuery> getByTitleOrTypeOrRecommend(SearchBlog searchBlog);

    List<BlogIndex> getBlogDigit();

    List<BlogTitle> getBlogTitle();

    BlogIndex getBlogDigitById(Long id);
}
