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
@Table(comment = "留言表")
@TableCharset(MySqlCharsetConstant.UTF8)
@TableEngine(MySqlEngineConstant.InnoDB)
public class Message {
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
    private Timestamp createTime;

    @Column
    private Long parentMessageId;

    @Column
    @IsNotNull
    private boolean adminMessage;

    //回复留言
    private List<Message> replyMessages = new ArrayList<>();
    private Message parentMessage;

    @Column
    private String parentNickname;
}
