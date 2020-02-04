package com.gouzhong1223.blog.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import lombok.Data;

/**
* Created by Gouzhong1223 Generator 2020/02/01
*/
@ApiModel(value="com.gouzhong1223.blog.pojo.Type")
@Data
public class Type implements Serializable {
    /**
	* 主键
	*/
    @ApiModelProperty(value="主键")
    private Integer id;

    /**
	* 类型名称
	*/
    @ApiModelProperty(value="类型名称")
    private String typename;

    /**
	* 创建时间
	*/
    @ApiModelProperty(value="创建时间")
    private String createtime;

    /**
	* 更新时间
	*/
    @ApiModelProperty(value="更新时间")
    private String updatetime;

    private static final long serialVersionUID = 1L;
}