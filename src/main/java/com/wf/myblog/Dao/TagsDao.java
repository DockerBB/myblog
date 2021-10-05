package com.wf.myblog.Dao;

import com.wf.myblog.Bean.Tag;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TagsDao {
    int saveTag(Tag tag);

    Tag getTag(Long id);

    List<Tag> getAllTag();

    int updateTag(Tag tag);

    int deleteTag(Long id);

    int getTagByName(String name);
}
