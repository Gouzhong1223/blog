package com.gouzhong1223.blog.interceptor;

import com.auth0.jwt.JWT;
import com.gouzhong1223.blog.common.BlogException;
import com.gouzhong1223.blog.common.ResultCode;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author : Gouzhong
 * @Blog : www.gouzhong1223.com
 * @Description : 登录拦截器
 * @Date : create by QingSong in 2020-02-03 3:11 PM
 * @Email : gouzhong1223@gmail.com
 * @Since : JDK 1.8
 * @PackageName : com.gouzhong1223.blog.interceptor
 * @ProjectName : blog
 * @Version : 1.0.0
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        String username = request.getHeader("username");
        if (!StringUtils.isAnyEmpty(username, token) && username.equals(JWT.decode(token).getClaim("username").asString())) {
            return true;
        }
        throw new BlogException(ResultCode.UNLOGIN.getCode(), "未登录！");
    }
}
