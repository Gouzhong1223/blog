/*
 *    Copyright [2020] [Gouzhong1223]
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

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