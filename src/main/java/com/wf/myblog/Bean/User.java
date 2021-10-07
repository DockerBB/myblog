package com.wf.myblog.Bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gitee.sunchenbin.mybatis.actable.annotation.*;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlCharsetConstant;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlEngineConstant;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Table(comment = "用户信息表")
@TableCharset(MySqlCharsetConstant.UTF8)
@TableEngine(MySqlEngineConstant.InnoDB)
public class User {
    @IsKey
    @IsNotNull
    @IsAutoIncrement
    private Long id;

    @Column
    private String avatar;

    @Column
    private Timestamp createTime;

    @Column
    private String email;

    @Column
    private String nickName;

    @Column
    private String password;

    @Column
    private Long type;

    @Column
    private Timestamp updateTime;

    @Column
    private String userName;
}
