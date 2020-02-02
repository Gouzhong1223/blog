package com.gouzhong1223.blog.mapper;

import com.gouzhong1223.blog.pojo.User;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * @Author : Gouzhong
 * @Blog : www.gouzhong1223.com
 * @Description : UserMapper
 * @Date : create by QingSong in 2020-02-02 12:51 PM
 * @Email : gouzhong1223@gmail.com
 * @Since : JDK 1.8
 * @PackageName : com.gouzhong1223.blog.mapper
 * @ProjectName : blog
 * @Version : 1.0.0
 */
public interface UserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertOrUpdate(User record);

    int insertOrUpdateSelective(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    int updateBatch(List<User> list);

    int batchInsert(@Param("list") List<User> list);

}