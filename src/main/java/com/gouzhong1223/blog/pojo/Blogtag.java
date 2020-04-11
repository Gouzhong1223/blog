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