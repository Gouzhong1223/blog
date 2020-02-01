package com.gouzhong1223.blog.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* Created by Gouzhong1223 Generator 2020/02/01
*/
@ApiModel(value="com.gouzhong1223.blog.pojo.Blogtag")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Blogtag implements Serializable {
    /**
	* blodid
	*/
    @ApiModelProperty(value="blodid")
    private Integer blogid;

    /**
	* tagid
	*/
    @ApiModelProperty(value="tagid")
    private Integer tagid;

    private static final long serialVersionUID = 1L;

}