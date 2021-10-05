package com.wf.myblog.Service;

import com.wf.myblog.Bean.Tag;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagService {
    int saveTag(Tag tag);

    Tag getTag(Long id);

    List<Tag> listTag();

    int updateTag(Long id, Tag tag);

    int delteTag(Long id);

    int getTagByName(String name);
}
