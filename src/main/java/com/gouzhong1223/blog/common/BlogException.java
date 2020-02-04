package com.gouzhong1223.blog.common;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author : Gouzhong
 * @Blog : www.gouzhong1223.com
 * @Description : 自定义异常
 * @Date : create by QingSong in 2020-02-01 4:49 下午
 * @Email : gouzhong1223@gmail.com
 * @Since : JDK 1.8
 * @PackageName : com.gouzhong1223.blog.common
 * @ProjectName : blog
 * @Version : 1.0.0
 */
@Data
@AllArgsConstructor
public class BlogException extends Exception {
    Integer code;
    String message;


}
