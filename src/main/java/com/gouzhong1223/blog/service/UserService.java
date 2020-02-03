package com.gouzhong1223.blog.service;

import com.gouzhong1223.blog.pojo.User;


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
public interface UserService {

    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertOrUpdate(User record);

    int insertOrUpdateSelective(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    /**
     * 登录
     *
     * @param username 用户名
     * @param password 密码
     * @return User对象
     */
    User login(String username, String password);

    /**
     * 用户名做公钥，密码做私钥生成Token
     *
     * @param username 用户名
     * @param password 密码
     * @return Token
     */
    String createToken(String username, String password);
}
