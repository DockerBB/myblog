package com.wf.myblog.Dao;

import com.wf.myblog.Bean.Blog;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface BlogDao {
    List<Blog> getAllBlog();
}
