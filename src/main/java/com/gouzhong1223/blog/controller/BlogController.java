package com.gouzhong1223.blog.controller;

import com.gouzhong1223.blog.common.ResultCode;
import com.gouzhong1223.blog.common.ResultMessage;
import com.gouzhong1223.blog.dto.ResultDto;
import com.gouzhong1223.blog.pojo.Blog;
import com.gouzhong1223.blog.pojo.Blogtag;
import com.gouzhong1223.blog.pojo.Type;
import com.gouzhong1223.blog.service.BlogService;
import com.gouzhong1223.blog.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;


/**
 * @Author : Gouzhong
 * @Blog : www.gouzhong1223.com
 * @Description : BlogController
 * @Date : create by QingSong in 2020-02-01 4:08 下午
 * @Email : gouzhong1223@gmail.com
 * @Since : JDK 1.8
 * @PackageName : com.gouzhong1223.blog.controller
 * @ProjectName : blog
 * @Version : 1.0.0
 */
@RestController
@RequestMapping("api")
public class BlogController {

    @Autowired
    private BlogService blogService;
    @Autowired
    private TypeService typeService;

    @GetMapping("allblogs")
    public ResultDto listAllBlogs() {
        return ResultDto.builder()
                .code(ResultCode.SUCCESS.getCode())
                .message(ResultMessage.SUCCESS.getMessaage())
                .data(blogService.listAllBlogs())
                .build();
    }

    @GetMapping("/blogdetail/{id}")
    public ResultDto blogDetail(@PathVariable("id") Integer id) {
        Blog blog = blogService.selectBlogById(id);
        List<Blogtag> blogtags = blogService.selectBlogTagsByBlogId(blog.getId());
        Type type = typeService.selectTypeById(blog.getTypeid());
        HashMap hashMap = new HashMap();
        hashMap.put("blog", blog);
        hashMap.put("blogtags", blogtags);
        hashMap.put("typr", type);
        return ResultDto.builder()
                .code(ResultCode.SUCCESS.getCode())
                .message(ResultMessage.SUCCESS.getMessaage())
                .data(hashMap)
                .build();
    }
}
