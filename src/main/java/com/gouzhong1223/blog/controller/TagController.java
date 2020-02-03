package com.gouzhong1223.blog.controller;

import com.gouzhong1223.blog.common.ResultCode;
import com.gouzhong1223.blog.common.ResultMessage;
import com.gouzhong1223.blog.dto.ResponseDto;
import com.gouzhong1223.blog.pojo.Tag;
import com.gouzhong1223.blog.service.TagService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author : Gouzhong
 * @Blog : www.gouzhong1223.com
 * @Description : TagController
 * @Date : create by QingSong in 2020-02-02 12:26 PM
 * @Email : gouzhong1223@gmail.com
 * @Since : JDK 1.8
 * @PackageName : com.gouzhong1223.blog.controller
 * @ProjectName : blog
 * @Version : 1.0.0
 */
@RequestMapping("api/tag")
@RestController
public class TagController {

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

    @GetMapping("listALl")
    public ResponseDto listAllTags() {
        List<Tag> tags = tagService.listAllTags();
        if (CollectionUtils.isEmpty(tags)) {
            return new ResponseDto(ResultCode.FAIL.getCode(), ResultMessage.FAIL.getMessaage());
        }
        return new ResponseDto(ResultCode.SUCCESS.getCode(), ResultMessage.SUCCESS.getMessaage(), tags);
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
}
