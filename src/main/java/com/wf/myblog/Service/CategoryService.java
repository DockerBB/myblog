package com.wf.myblog.Service;

import com.wf.myblog.Bean.Type;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface CategoryService {
    int saveType(Type type);

    Type getType(Long id);

    List<Type> listType();

    int updateType(Long id, Type type);

    int delteType(Long id);

    int getTypeByName(String name);
}
