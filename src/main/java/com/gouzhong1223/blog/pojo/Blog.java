package com.gouzhong1223.blog.pojo;

import com.gouzhong1223.blog.util.DateTimeUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author : Gouzhong
 * @Blog : www.gouzhong1223.com
 * @Description : Blog
 * @Date : create by QingSong in 2020-02-03 11:32 PM
 * @Email : gouzhong1223@gmail.com
 * @Since : JDK 1.8
 * @PackageName : com.gouzhong1223.blog.pojo
 * @ProjectName : blog
 * @Version : 1.0.0
 */
@ApiModel(value = "com-gouzhong1223-blog-pojo-Blog")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
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
    private String createtime;

    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间")
    private String updatetime;

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

    /*public void setCreatetime(Date date) {
        this.createtime = DateTimeUtil.getDateTime(date);
    }

    public void setUpdatetime(Date date) {
        this.updatetime = DateTimeUtil.getDateTime(date);
    }*/

    private static final long serialVersionUID = 1L;

    public static BlogBuilder builder() {
        return new BlogBuilder();
    }
}