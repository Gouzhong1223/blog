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

package com.gouzhong1223.blog.handler;

import com.gouzhong1223.blog.common.BlogException;
import com.gouzhong1223.blog.common.ResultCode;
import com.gouzhong1223.blog.dto.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author : Gouzhong
 * @Blog : www.gouzhong1223.com
 * @Description : 自定义异常返回视图
 * @Date : create by QingSong in 2020-02-04 10:35 下午
 * @Email : gouzhong1223@gmail.com
 * @Since : JDK 1.8
 * @PackageName : com.gouzhong1223.blog.handler
 * @ProjectName : blog
 * @Version : 1.0.0
 */
@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(BlogException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseDto handlerBlogException(HttpServletRequest request, BlogException ex) {
        return new ResponseDto(ex.getCode(), ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseDto handlerAllException(HttpServletRequest request, Exception ex) {
        return new ResponseDto(ResultCode.FAIL.getCode(), ex.getMessage());
    }
}
