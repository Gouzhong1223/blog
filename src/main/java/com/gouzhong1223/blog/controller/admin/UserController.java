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

package com.gouzhong1223.blog.controller.admin;

import com.gouzhong1223.blog.common.ResultCode;
import com.gouzhong1223.blog.common.ResultMessage;
import com.gouzhong1223.blog.dto.ResponseDto;
import com.gouzhong1223.blog.pojo.User;
import com.gouzhong1223.blog.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

/**
 * @Author : Gouzhong
 * @Blog : www.gouzhong1223.com
 * @Description : UserController
 * @Date : create by QingSong in 2020-02-02 12:28 PM
 * @Email : gouzhong1223@gmail.com
 * @Since : JDK 1.8
 * @PackageName : com.gouzhong1223.blog.controller
 * @ProjectName : blog
 * @Version : 1.0.0
 */
@RestController
@RequestMapping("api/admin/user")
public class UserController {

    @Autowired
    private UserService userService;
    public static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @PostMapping("/login")
    public ResponseDto login(@RequestParam("username") String username,
                             @RequestParam("password") String password,
                             HttpSession session,
                             RedirectAttributes attributes) {
        User login = userService.login(username, password);
        if (login == null) {
            LOGGER.error("登录失败！");
            return new ResponseDto(ResultCode.LOGINFAIL.getCode(), ResultMessage.LOGINFAIL.getMessaage());
        }
        String token = userService.createToken(username, password);
        HashMap map = new HashMap();
        map.put("token", token);
        map.put("userinfo", login);
        return ResponseDto.SUCCESS(map);
    }
}
