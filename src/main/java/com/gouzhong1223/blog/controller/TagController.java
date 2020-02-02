package com.gouzhong1223.blog.controller;

import com.gouzhong1223.blog.common.ResultCode;
import com.gouzhong1223.blog.common.ResultMessage;
import com.gouzhong1223.blog.dto.ResultDto;
import com.gouzhong1223.blog.pojo.Tag;
import com.gouzhong1223.blog.service.TagService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResultDto insertTag(Tag tag) {
        Tag insertTag = tagService.insertTag(tag);
        if (insertTag == null) {
            return new ResultDto(ResultCode.FAIL.getCode(), ResultMessage.FAIL.getMessaage());
        }
        return new ResultDto(ResultCode.SUCCESS.getCode(), ResultMessage.SUCCESS.getMessaage(), insertTag);
    }

    @GetMapping("listALl")
    public ResultDto listAllTags() {
        List<Tag> tags = tagService.listAllTags();
        if (CollectionUtils.isEmpty(tags)) {
            return new ResultDto(ResultCode.FAIL.getCode(), ResultMessage.FAIL.getMessaage());
        }
        return new ResultDto(ResultCode.SUCCESS.getCode(), ResultMessage.SUCCESS.getMessaage(), tags);
    }
}