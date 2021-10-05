package com.wf.myblog.Bean;

import com.gitee.sunchenbin.mybatis.actable.annotation.*;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlCharsetConstant;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlEngineConstant;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Table(comment = "评论表")
@TableCharset(MySqlCharsetConstant.UTF8)
@TableEngine(MySqlEngineConstant.InnoDB)
public class Comment {
    @IsKey
    @IsNotNull
    @IsAutoIncrement
    private Long id;

    @Column
    private String nickname;

    @Column
    private String email;

    @Column
    private String content;

    @Column
    private String avatar;

    @Column
    private Date CreateTime;

    @Column
    private Long blogId;

    @Column
    private Long parentCommentId;

    @Column
    @IsNotNull
    private boolean adminComment;

//    回复评论
    private List<Comment> replyComments = new ArrayList<>();
    private Comment parentComment;

    @Column
    private String parentNickname;
}
