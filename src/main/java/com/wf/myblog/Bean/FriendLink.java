package com.wf.myblog.Bean;

import com.gitee.sunchenbin.mybatis.actable.annotation.*;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlCharsetConstant;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlEngineConstant;
import lombok.Data;

import java.util.Date;

@Data
@Table(comment = "友链表")
@TableCharset(MySqlCharsetConstant.UTF8)
@TableEngine(MySqlEngineConstant.InnoDB)
public class FriendLink {
    @IsKey
    @IsNotNull
    @IsAutoIncrement
    private Long id;

    @Column
    @IsNotNull
    private String blogName;

    @Column
    @IsNotNull
    private String blogAddress;

    @Column
    @IsNotNull
    private String pictureAddress;

    @Column
    @IsNotNull
    private Date createTime;
}
