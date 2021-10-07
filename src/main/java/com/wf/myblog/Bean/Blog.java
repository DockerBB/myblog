package com.wf.myblog.Bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gitee.sunchenbin.mybatis.actable.annotation.*;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlCharsetConstant;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlEngineConstant;
import lombok.Data;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Table(comment = "博客表")
@TableCharset(MySqlCharsetConstant.UTF8)
@TableEngine(MySqlEngineConstant.InnoDB)
public class Blog {
    @IsKey
    @IsNotNull
    @IsAutoIncrement
    private Long id;

    @Column
    @IsNotNull
    private String title;

    @Column
    private String content;

    @Column
    private String firstPicture; //首图

    @Column
    private String flag; //是否原创

    @Column
    private Integer views; //浏览次数

    @Column
    private Integer commentCount;

    @Column
    private boolean appreciation; // 赞赏

    @Column
    @IsNotNull
    private boolean shareStatement; // 版权

    @Column
    @IsNotNull
    private boolean commentable; // 开启评论

    @Column
    @IsNotNull
    private boolean published; // 是否发布

    @Column
    @IsNotNull
    private boolean recommend; // 是否推荐

    @Column
    private Timestamp createTime;

    @Column
    private Timestamp updateTime;

    @Column
    private String description;

    private Type type;

    private User user;

    @Column
    private Long typeId;

    @Column
    private Long userId;

    private List<Comment> commnets = new ArrayList<>();
}
