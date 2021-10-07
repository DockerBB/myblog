package com.wf.myblog.queryenc;

import com.wf.myblog.Bean.Type;
import lombok.Data;

import java.sql.Timestamp;


@Data
public class BlogQuery {
    private Long id;

    private String title;

    private Timestamp updateTime;

    private Boolean recommend;

    private Boolean published;

    private Long typeId;

    private Type type;
}
