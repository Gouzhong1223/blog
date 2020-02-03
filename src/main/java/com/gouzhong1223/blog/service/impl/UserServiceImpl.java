package com.gouzhong1223.blog.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.gouzhong1223.blog.util.MD5Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.gouzhong1223.blog.pojo.User;
import com.gouzhong1223.blog.mapper.UserMapper;


import com.gouzhong1223.blog.service.UserService;

/**
 * @Author : Gouzhong
 * @Blog : www.gouzhong1223.com
 * @Description : UserServiceImpl
 * @Date : create by QingSong in 2020-02-02 12:51 PM
 * @Email : gouzhong1223@gmail.com
 * @Since : JDK 1.8
 * @PackageName : com.gouzhong1223.blog.service.impl
 * @ProjectName : blog
 * @Version : 1.0.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;
    public static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public int deleteByPrimaryKey(Long id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(User record) {
        return userMapper.insert(record);
    }

    @Override
    public int insertOrUpdate(User record) {
        return userMapper.insertOrUpdate(record);
    }

    @Override
    public int insertOrUpdateSelective(User record) {
        return userMapper.insertOrUpdateSelective(record);
    }

    @Override
    public int insertSelective(User record) {
        return userMapper.insertSelective(record);
    }

    @Override
    public User selectByPrimaryKey(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(User record) {
        return userMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(User record) {
        return userMapper.updateByPrimaryKey(record);
    }

    @Override
    public User login(String username, String password) {
        User user = userMapper.selectOneByUsername(username);
        if (user != null) {
            if (MD5Util.code(password).equals(user.getPassword())) {
                LOGGER.info("用户名为{}的用户尝试登录，密码为{},密码错误，登录成功！", username, password);
                return user;
            }
            LOGGER.error("用户名为{}的用户尝试登录，密码为{},密码错误，登录失败！", username, password);
            return null;
        }
        LOGGER.error("不存在用户名为{}的用户", username);
        return null;
    }

    @Override
    public String createToken(String username, String password) {
        String token = "";
        token = JWT.create()
                .withClaim("username", username)
                .withClaim("generatetime", System.currentTimeMillis())
                .withClaim("exptime", 1000 * 1 * 60 * 60)
                // 以 password 作为 token 的密钥
                .sign(Algorithm.HMAC256(password));
        return token;
    }


}
