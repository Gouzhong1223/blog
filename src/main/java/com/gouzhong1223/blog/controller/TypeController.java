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

package com.gouzhong1223.blog.controller;

import com.gouzhong1223.blog.common.ResultCode;
import com.gouzhong1223.blog.common.ResultMessage;
import com.gouzhong1223.blog.dto.ResponseDto;
import com.gouzhong1223.blog.pojo.Type;
import com.gouzhong1223.blog.service.TypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author : Gouzhong
 * @Blog : www.gouzhong1223.com
 * @Description : TypeController
 * @Date : create by QingSong in 2020-02-02 12:27 PM
 * @Email : gouzhong1223@gmail.com
 * @Since : JDK 1.8
 * @PackageName : com.gouzhong1223.blog.controller
 * @ProjectName : blog
 * @Version : 1.0.0
 */
@RestController
@RequestMapping("api/type")
@Api("类型操作接口")
public class TypeController {

    @Autowired
    private TypeService typeService;
    public static final Logger LOGGER = LoggerFactory.getLogger(TypeController.class);


    @GetMapping("/listall")
    @ApiOperation(value = "获取所有类型", httpMethod = "GET")
    @ApiResponse(code = 200, message = "操作成功", response = ResponseDto.class)
    public ResponseDto listAllTypes() {
        LOGGER.info("获取所有Type");
        List<Type> types = typeService.listAllTypes();
        if (CollectionUtils.isEmpty(types)) {
            LOGGER.error("获取所有Type失败！");
            return new ResponseDto(ResultCode.FAIL.getCode(), ResultMessage.FAIL.getMessaage());
        }
        LOGGER.info("获取所有Type成功！");
        return new ResponseDto(ResultCode.SUCCESS.getCode(), ResultMessage.SUCCESS.getMessaage(), types);
    }
}
