package com.gouzhong1223.blog.controller;

import com.gouzhong1223.blog.common.ResultCode;
import com.gouzhong1223.blog.common.ResultMessage;
import com.gouzhong1223.blog.dto.ResultDto;
import com.gouzhong1223.blog.pojo.Blog;
import com.gouzhong1223.blog.pojo.Blogtag;
import com.gouzhong1223.blog.pojo.Tag;
import com.gouzhong1223.blog.pojo.Type;
import com.gouzhong1223.blog.service.BlogService;
import com.gouzhong1223.blog.service.TagService;
import com.gouzhong1223.blog.service.TypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
@RequestMapping("api/blog")
public class BlogController {

    @Autowired
    private BlogService blogService;
    @Autowired
    private TypeService typeService;
    @Autowired
    private TagService tagService;
    public static final Logger LOGGER = LoggerFactory.getLogger(BlogController.class);

    @GetMapping("allblogs")
    public ResultDto listAllBlogs() {
        LOGGER.info("查询所有的Blog");
        return ResultDto.builder()
                .code(ResultCode.SUCCESS.getCode())
                .message(ResultMessage.SUCCESS.getMessaage())
                .data(blogService.listAllBlogs())
                .build();
    }

    @GetMapping("/blogdetail/{id}")
    public ResultDto blogDetail(@PathVariable("id") Integer id) {
        LOGGER.info("查询id为{}的Blog", id);
        Blog blog = blogService.selectBlogById(id);
        if (blog != null) {
            LOGGER.info("开始获取id为{}的Blog所有的标签", blog.getId());
            List<Blogtag> blogtags = blogService.selectBlogTagsByBlogId(blog.getId());
            LOGGER.info("获取id为{}的Blog所属分类", blog.getId());
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
        LOGGER.error("获取id为{}的Blog失败！！！", id);
        return ResultDto.builder()
                .code(ResultCode.FAIL.getCode())
                .message(ResultMessage.FAIL.getMessaage())
                .data(null)
                .build();
    }

    @DeleteMapping("/delete/{id}")
    public ResultDto deleteBlog(@PathVariable("id") Integer id) {
        LOGGER.info("删除id为{}的Blog", id);
        int i = blogService.deleteByPrimaryKey(id);
        if (i != 0) {
            LOGGER.info("开始删除id为{}的Blog所对应的所有Tags", id);
            blogService.deleteBlogTagsByBlogId(id);
            return ResultDto.builder()
                    .code(ResultCode.SUCCESS.getCode())
                    .message(ResultMessage.SUCCESS.getMessaage())
                    .data(i)
                    .build();
        }
        LOGGER.error("删除id为{}的Blog失败！！！", id);
        return ResultDto.builder()
                .code(ResultCode.FAIL.getCode())
                .message(ResultMessage.FAIL.getMessaage())
                .data(i)
                .build();
    }

    @PostMapping("/insert")
    public ResultDto insertBlog(@RequestBody Blog blog,
                                @RequestBody List<Integer> tagids) {
        if (blog != null && !CollectionUtils.isEmpty(tagids)) {
            LOGGER.info("新增Blog", blog, tagids);
            int blogid = blogService.insertSelective(blog, tagids);
            if (blogid != 0) {
                return ResultDto.builder()
                        .code(ResultCode.SUCCESS.getCode())
                        .message(ResultMessage.SUCCESS.getMessaage())
                        .data(blogService.selectBlogById(blogid))
                        .build();
            }
            LOGGER.error("新增失败!");
            return ResultDto.builder()
                    .code(ResultCode.FAIL.getCode())
                    .message(ResultMessage.FAIL.getMessaage())
                    .data(blogService.selectBlogById(blogid))
                    .build();
        }
        LOGGER.error("参数为空，新增博客失败!");
        return ResultDto.builder()
                .code(ResultCode.VALUE_NULL.getCode())
                .message(ResultMessage.VALUE_NULL.getMessaage())
                .data(null)
                .build();
    }


}
