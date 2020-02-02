package com.gouzhong1223.blog.service;

import com.gouzhong1223.blog.pojo.User;
import java.util.List;
    /**
 * @Author : Gouzhong
 * @Blog : www.gouzhong1223.com
 * @Description : UserService
 * @Date : create by QingSong in 2020-02-02 12:51 PM
 * @Email : gouzhong1223@gmail.com
 * @Since : JDK 1.8
 * @PackageName : com.gouzhong1223.blog.service
 * @ProjectName : blog
 * @Version : ${VERSION}
 */
public interface UserService{

    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertOrUpdate(User record);

    int insertOrUpdateSelective(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}
