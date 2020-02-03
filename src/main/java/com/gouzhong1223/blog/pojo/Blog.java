package com.gouzhong1223.blog.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * Created by Mybatis Generator 2020/02/01
 */
@ApiModel(value = "com.gouzhong1223.blog.pojo.Blog")
@Data
public class Blog implements Serializable {
    /**
     * 主键
     */
    @ApiModelProperty(value = "主键")
    private Integer id;

    /**
     * 博客标题
     */
    @ApiModelProperty(value = "博客标题")
    private String blogtitle;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private Date createtime;

    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间")
    private Date updatetime;

    /**
     * 博客正文
     */
    @ApiModelProperty(value = "博客正文")
    private String blogtext;

    /**
     * 是否可见 0->不可见  1->可见
     */
    @ApiModelProperty(value = "是否可见 0->不可见  1->可见")
    private Integer visible;

    /**
     * 类型
     */
    @ApiModelProperty(value = "类型")
    private Integer typeid;

    /**
     * 是否可分享 0->不可 1->可以分享
     */
    @ApiModelProperty(value = "是否可分享 0->不可 1->可以分享")
    private Integer share;

    /**
     * 博客首图
     */
    @ApiModelProperty(value = "博客首图")
    private String blogimage;

    /**
     * 简介
     */
    @ApiModelProperty(value = "简介")
    private String introduction;

    private static final long serialVersionUID = 1L;

    public Blog() {
    }

    protected boolean canEqual(Object other) {
        return other instanceof com.gouzhong1223.blog.pojo.Blog;
    }
}