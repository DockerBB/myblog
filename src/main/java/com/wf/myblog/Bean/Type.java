package com.wf.myblog.Bean;

import com.gitee.sunchenbin.mybatis.actable.annotation.*;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlCharsetConstant;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlEngineConstant;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Data
@Table(comment = "博客类型表")
@TableCharset(MySqlCharsetConstant.UTF8)
@TableEngine(MySqlEngineConstant.InnoDB)
public class Type {
    @IsKey
    @IsNotNull
    @IsAutoIncrement
    private Long id;

    @Column
    @IsNotNull
    @NotBlank(message = "分类名称不能为空")
    private String name;

    private List<Blog> blogs = new ArrayList<>();
}
