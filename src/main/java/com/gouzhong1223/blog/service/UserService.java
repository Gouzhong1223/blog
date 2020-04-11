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
