package com.wf.myblog.Service;

import com.wf.myblog.Bean.Tag;
import com.wf.myblog.Dao.TagsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TagServiceImpl implements TagService{
    @Autowired
    TagsDao tagsDao;

    @Transactional
    @Override
    public int saveTag(Tag tag) {
        return tagsDao.saveTag(tag);
    }

    @Transactional
    @Override
    public Tag getTag(Long id) {
        return tagsDao.getTag(id);
    }

    @Transactional
    @Override
    public List<Tag> listTag() {
        List<Tag> all = tagsDao.getAllTag();
        return all;
    }

    @Transactional
    @Override
    public int updateTag(Long id, Tag tag) {
        return tagsDao.updateTag(tag);
    }

    @Transactional
    @Override
    public int delteTag(Long id) {
        return tagsDao.deleteTag(id);
    }

    @Transactional
    @Override
    public int getTagByName(String name) {
        return tagsDao.getTagByName(name);
    }
}
