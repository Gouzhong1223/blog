package com.gouzhong1223.blog.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
* Created by Mybatis Generator 2020/02/01
*/
@ApiModel(value="com.gouzhong1223.blog.pojo.User")
@Data
public class User implements Serializable {
    /**
	* 主键
	*/
    @ApiModelProperty(value="主键")
    private Long id;

    /**
	* 头像图片
	*/
    @ApiModelProperty(value="头像图片")
    private String avatar;

    /**
	* 创建时间
	*/
    @ApiModelProperty(value="创建时间")
    private LocalDateTime createTime;

    /**
	* 邮箱
	*/
    @ApiModelProperty(value="邮箱")
    private String email;

    /**
	* 昵称
	*/
    @ApiModelProperty(value="昵称")
    private String nickname;

    /**
	* 密码
	*/
    @ApiModelProperty(value="密码")
    private String password;

    /**
	* 类型
	*/
    @ApiModelProperty(value="类型")
    private Integer type;

    /**
	* 更新时间
	*/
    @ApiModelProperty(value="更新时间")
    private LocalDateTime updateTime;

    /**
	* 用户名
	*/
    @ApiModelProperty(value="用户名")
    private String username;

    private static final long serialVersionUID = 1L;
}