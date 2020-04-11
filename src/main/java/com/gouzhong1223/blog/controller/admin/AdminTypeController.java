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
import com.gouzhong1223.blog.controller.TypeController;
import com.gouzhong1223.blog.dto.ResponseDto;
import com.gouzhong1223.blog.pojo.Type;
import com.gouzhong1223.blog.service.TypeService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author : Gouzhong
 * @Blog : www.gouzhong1223.com
 * @Description : AdminTypeController
 * @Date : create by QingSong in 2020-02-04 11:22 上午
 * @Email : gouzhong1223@gmail.com
 * @Since : JDK 1.8
 * @PackageName : com.gouzhong1223.blog.controller.admin
 * @ProjectName : blog
 * @Version : 1.0.0
 */
@RestController
@RequestMapping("/api/admin/type")
public class AdminTypeController {

    @Autowired
    private TypeService typeService;
    public static final Logger LOGGER = LoggerFactory.getLogger(TypeController.class);

    @PostMapping("/insert")
    public ResponseDto insertType(@RequestParam("typename") String typename) {
        if (StringUtils.isNotEmpty(typename)) {
            if (!typeService.isExist(typename)) {
                LOGGER.info("插入名为{}的type", typename);
                Type type = typeService.insertType(typename);
                return new ResponseDto(ResultCode.SUCCESS.getCode(), ResultMessage.SUCCESS.getMessaage(), type);
            }
            LOGGER.error("type已经存在", typename);
            return new ResponseDto(ResultCode.ISEXIST.getCode(), ResultMessage.ISEXIST.getMessaage());
        }
        LOGGER.error("typename为空", typename);
        return new ResponseDto(ResultCode.VALUE_NULL.getCode(), ResultMessage.VALUE_NULL.getMessaage());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseDto deleteType(@PathVariable("id") Integer id) {
        int i = typeService.deleteType(id);
        if (i != 0) {
            LOGGER.info("删除id为{}的Type", id);
            return new ResponseDto(ResultCode.SUCCESS.getCode(), ResultMessage.SUCCESS.getMessaage(), i);
        }
        LOGGER.error("删除id为{}的Type失败！", id);
        return new ResponseDto(ResultCode.FAIL.getCode(), ResultMessage.FAIL.getMessaage());
    }

    @PutMapping("/update")
    public ResponseDto updateType(@RequestBody Type type) {
        if (StringUtils.isNotEmpty(type.getTypename())) {
            Type updateType = typeService.updateType(type);
            if (updateType != null) {
                LOGGER.info("修改id为{}的Type", type.getId());
                return new ResponseDto(ResultCode.SUCCESS.getCode(), ResultMessage.SUCCESS.getMessaage(), type);
            }
            LOGGER.error("修改id为{}的Type失败！", type.getId());
            return new ResponseDto(ResultCode.FAIL.getCode(), ResultMessage.FAIL.getMessaage());
        }
        LOGGER.error("修改id为{}的Type失败！,参数为空！", type.getId());
        return new ResponseDto(ResultCode.VALUE_NULL.getCode(), ResultMessage.VALUE_NULL.getMessaage());
    }
}
