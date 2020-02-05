package com.gouzhong1223.blog.controller;

import com.gouzhong1223.blog.common.ResultCode;
import com.gouzhong1223.blog.common.ResultMessage;
import com.gouzhong1223.blog.dto.ResponseDto;
import com.gouzhong1223.blog.pojo.Tag;
import com.gouzhong1223.blog.service.TagService;
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
@Api("类型操作接口")
public class TagController {

    @Autowired
    private TagService tagService;
    public static final Logger LOGGER = LoggerFactory.getLogger(TagController.class);

    @GetMapping("listall")
    @ApiOperation(value = "获取所有标签", httpMethod = "GET")
    @ApiResponse(code = 200, message = "操作成功", response = ResponseDto.class)
    public ResponseDto listAllTags() {
        List<Tag> tags = tagService.listAllTags();
        if (CollectionUtils.isEmpty(tags)) {
            LOGGER.error("获取到的Tags为空");
            return new ResponseDto(ResultCode.FAIL.getCode(), ResultMessage.FAIL.getMessaage());
        }
        LOGGER.info("获取所有Tags成功！");
        return new ResponseDto(ResultCode.SUCCESS.getCode(), ResultMessage.SUCCESS.getMessaage(), tags);
    }
}
