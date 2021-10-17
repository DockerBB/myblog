package com.wf.myblog.Dao;

import com.wf.myblog.Bean.Type;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CategoryDao {
    int saveType(Type type);

    Type getType(Long id);

    List<Type> getAllType();

    List<Type> listTypeTop(Integer size);

    int updateType(Type type);

    int deleteType(Long id);

    int getTypeByName(String name);
}
