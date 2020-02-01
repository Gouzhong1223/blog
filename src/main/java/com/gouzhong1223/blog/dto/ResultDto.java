package com.gouzhong1223.blog.dto;

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
public class ResultDto<T> {
    private Integer code;
    private String message;
    private T data;
}
