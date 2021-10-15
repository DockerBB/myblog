package com.wf.myblog.queryenc;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class BlogIndex {
    private Integer id;
    private String title;
    private String description;
    private Timestamp createTime;
    private Integer views;
    private Integer typeId;
    private String typeName;
    private String firstPicture;
    private String userName;
    private String avatar;
}
