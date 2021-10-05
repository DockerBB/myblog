package com.wf.myblog.Bean;

import com.gitee.sunchenbin.mybatis.actable.annotation.*;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlCharsetConstant;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlEngineConstant;
import lombok.Data;

@Data
@Table(comment = "图片信息表")
@TableCharset(MySqlCharsetConstant.UTF8)
@TableEngine(MySqlEngineConstant.InnoDB)
public class Picture {
    @IsKey
    @IsNotNull
    @IsAutoIncrement
    private Long id;

    @Column
    private String pictureName;

    @Column
    private String pictureTime;

    @Column
    private String pictureAddress;

    @Column
    private String pictureDescription;
}
