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

package com.gouzhong1223.blog.dto;

import com.gouzhong1223.blog.common.ResultCode;
import com.gouzhong1223.blog.common.ResultMessage;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author : Gouzhong
 * @Blog : www.gouzhong1223.com
 * @Description : 返回的json
 * @Date : create by QingSong in 2020-02-01 4:48 下午
 * @Email : gouzhong1223@gmail.com
 * @Since : JDK 1.8
 * @PackageName : com.gouzhong1223.blog.dto
 * @ProjectName : blog
 * @Version : 1.0.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseDto<T> {
    @ApiModelProperty("返回状态码")
    private Integer code;
    @ApiModelProperty("返回提示信息")
    private String message;
    @ApiModelProperty("返回的封装数据")
    private T data;

    public ResponseDto(Integer code, String message) {
        this.code = code;
        this.message = message;
        this.data = null;
    }


    public static <T> ResponseDto<T> SUCCESS(T data) {
        return new ResponseDto<T>(ResultCode.SUCCESS.getCode(), ResultMessage.SUCCESS.getMessaage(), data);
    }

    public static <T> ResponseDto<T> FAIL(T data) {
        return new ResponseDto<T>(ResultCode.FAIL.getCode(), ResultMessage.FAIL.getMessaage(), data);
    }
}
