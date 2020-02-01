package com.gouzhong1223.blog.service;

import com.gouzhong1223.blog.pojo.Type;

/**
 * @Author : Gouzhong
 * @Blog : www.gouzhong1223.com
 * @Description : 分类业务
 * @Date : create by QingSong in 2020-02-01 4:46 下午
 * @Email : gouzhong1223@gmail.com
 * @Since : JDK 1.8
 * @PackageName : com.gouzhong1223.blog.service
 * @ProjectName : blog
 * @Version : 1.0.0
 */
public interface TypeService {
    Type selectTypeById(Integer id);
}
