package com.gouzhong1223.blog.controller;

import com.gouzhong1223.blog.common.ResultCode;
import com.gouzhong1223.blog.common.ResultMessage;
import com.gouzhong1223.blog.dto.ResultDto;
import com.gouzhong1223.blog.pojo.Tag;
import com.gouzhong1223.blog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping("/insert")
    public ResultDto insertTag(Tag tag) {
        Tag insertTag = tagService.insertTag(tag);
        if (insertTag == null) {
            return new ResultDto(ResultCode.FAIL.getCode(), ResultMessage.FAIL.getMessaage());
        }
        return new ResultDto(ResultCode.SUCCESS.getCode(), ResultMessage.SUCCESS.getMessaage(), insertTag);
    }
}
