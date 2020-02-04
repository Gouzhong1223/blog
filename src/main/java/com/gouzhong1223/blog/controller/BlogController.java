package com.gouzhong1223.blog.controller;

import com.gouzhong1223.blog.common.BlogException;
import com.gouzhong1223.blog.common.PageResult;
import com.gouzhong1223.blog.common.ResultCode;
import com.gouzhong1223.blog.common.ResultMessage;
import com.gouzhong1223.blog.dto.ResponseDto;
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

    @Autowired()
    private BlogService blogService;
    @Autowired
    private TypeService typeService;
    @Autowired
    private TagService tagService;
    public static final Logger LOGGER = LoggerFactory.getLogger(BlogController.class);

    @GetMapping("allblogs")
    public ResponseDto listAllBlogs() {
        LOGGER.info("查询所有的Blog");
        return ResponseDto.builder()
                .code(ResultCode.SUCCESS.getCode())
                .message(ResultMessage.SUCCESS.getMessaage())
                .data(blogService.listAllBlogs())
                .build();
    }

    @GetMapping("/blogdetail/{id}")
    public ResponseDto blogDetail(@PathVariable("id") Integer id) throws BlogException {
        LOGGER.info("查询id为{}的Blog", id);
        Blog blog = blogService.selectBlogById(id);
        if (blog != null) {
            LOGGER.info("开始获取id为{}的Blog所有的标签", blog.getId());
            List<Blogtag> blogtags = blogService.selectBlogTagsByBlogId(blog.getId());
            ArrayList<Tag> tags = new ArrayList<>();
            for (Blogtag blogtag : blogtags) {
                tags.add(tagService.selectTagById(blogtag.getTagid()));
            }
            LOGGER.info("获取id为{}的Blog所属分类", blog.getId());
            Type type = typeService.selectTypeById(blog.getTypeid());
            HashMap hashMap = new HashMap();
            hashMap.put("blog", blog);
            hashMap.put("tags", tags);
            hashMap.put("type", type);
            return ResponseDto.builder()
                    .code(ResultCode.SUCCESS.getCode())
                    .message(ResultMessage.SUCCESS.getMessaage())
                    .data(hashMap)
                    .build();
        }
        LOGGER.error("获取id为{}的Blog失败！！！", id);
        throw new BlogException(ResultCode.FAIL.getCode(), ResultMessage.FAIL.getMessaage());
    }

    @GetMapping("/pagelist")
    public ResponseDto listAllBlogByPage(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                         @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
        LOGGER.info("开始分页查询数据，当前页码为{}，当前每一页大小为{}", pageNum, pageSize);
        PageResult<Blog> blogPageResult = blogService.listBlogByPage(pageNum, pageSize);
        if (!CollectionUtils.isEmpty(blogPageResult.getList())) {
            return ResponseDto.SUCCESS(blogPageResult);
        }
        LOGGER.error("分页查询数据，当前页码为{}，当前每一页大小为{}，失败！！, pageNum, pageSize");
        return ResponseDto.FAIL(blogPageResult);
    }
}
