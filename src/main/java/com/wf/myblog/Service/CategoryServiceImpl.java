package com.wf.myblog.Service;

import com.wf.myblog.Bean.Type;
import com.wf.myblog.Dao.CategoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    CategoryDao categoryDao;

    @Transactional
    @Override
    public int saveType(Type type) {
        return categoryDao.saveType(type);
    }

    @Transactional
    @Override
    public Type getType(Long id) {
        return categoryDao.getType(id);
    }

    @Transactional
    @Override
    public List<Type> listType() {
        List<Type> all = categoryDao.getAllType();
        return all;
    }

    @Override
    public List<Type> listTypeTop(Integer size) {
        return categoryDao.listTypeTop(size);
    }

    @Transactional
    @Override
    public int updateType(Long id, Type type) {
        return categoryDao.updateType(type);
    }

    @Transactional
    @Override
    public int delteType(Long id) {
        return categoryDao.deleteType(id);
    }

    @Transactional
    @Override
    public int getTypeByName(String name) {
        return categoryDao.getTypeByName(name);
    }
}
