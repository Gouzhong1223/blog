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
import com.gouzhong1223.blog.controller.TagController;
import com.gouzhong1223.blog.dto.ResponseDto;
import com.gouzhong1223.blog.pojo.Tag;
import com.gouzhong1223.blog.service.TagService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author : Gouzhong
 * @Blog : www.gouzhong1223.com
 * @Description : AdminTagController
 * @Date : create by QingSong in 2020-02-04 11:21 上午
 * @Email : gouzhong1223@gmail.com
 * @Since : JDK 1.8
 * @PackageName : com.gouzhong1223.blog.controller.admin
 * @ProjectName : blog
 * @Version : 1.0.0
 */
@RestController
@RequestMapping("/api/admin/tag")
public class AdminTagController {

    @Autowired
    private TagService tagService;
    public static final Logger LOGGER = LoggerFactory.getLogger(TagController.class);

    @PostMapping("/insert")
    public ResponseDto insertTag(@RequestParam("tagname") String tagname) {
        Tag insertTag = tagService.insertTag(tagname);
        if (insertTag == null) {
            return new ResponseDto(ResultCode.FAIL.getCode(), ResultMessage.FAIL.getMessaage());
        }
        return new ResponseDto(ResultCode.SUCCESS.getCode(), ResultMessage.SUCCESS.getMessaage(), insertTag);
    }

    @PutMapping("/update")
    public ResponseDto updateTag(@RequestBody Tag tag) {
        if (tag != null) {
            LOGGER.info("更新id为{}的Tag", tag.getId());
            Tag updateTag = tagService.updateTag(tag);
            if (updateTag != null) {
                LOGGER.info("更新成功！");
                return new ResponseDto(ResultCode.SUCCESS.getCode(), ResultMessage.SUCCESS.getMessaage(), updateTag);
            }
            LOGGER.error("更新id为{}的Tag失败", tag.getId());
            return new ResponseDto(ResultCode.FAIL.getCode(), ResultMessage.FAIL.getMessaage());
        }
        LOGGER.error("参数为空,更新失败");
        return new ResponseDto(ResultCode.VALUE_NULL.getCode(), ResultMessage.VALUE_NULL.getMessaage());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseDto deleteTag(@PathVariable("id") Integer id) {
        Tag tag = tagService.selectTagById(id);
        if (tag != null) {
            tagService.deleteTagByTagid(id);
            LOGGER.info("删除id为{}的Tag", id);
            return new ResponseDto(ResultCode.SUCCESS.getCode(), ResultMessage.SUCCESS.getMessaage(), tag);
        }
        LOGGER.error("删除id为{}的Tag失败，Tag不存在！", id);
        return new ResponseDto(ResultCode.FAIL.getCode(), ResultMessage.FAIL.getMessaage());
    }
}
