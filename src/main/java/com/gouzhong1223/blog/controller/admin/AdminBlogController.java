package com.gouzhong1223.blog.controller.admin;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gouzhong1223.blog.common.ResultCode;
import com.gouzhong1223.blog.common.ResultMessage;
import com.gouzhong1223.blog.controller.BlogController;
import com.gouzhong1223.blog.dto.ResponseDto;
import com.gouzhong1223.blog.pojo.Blog;
import com.gouzhong1223.blog.service.BlogService;
import com.gouzhong1223.blog.service.TagService;
import com.gouzhong1223.blog.service.TypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author : Gouzhong
 * @Blog : www.gouzhong1223.com
 * @Description : AdminBlogController
 * @Date : create by QingSong in 2020-02-04 11:21 上午
 * @Email : gouzhong1223@gmail.com
 * @Since : JDK 1.8
 * @PackageName : com.gouzhong1223.blog.controller.admin
 * @ProjectName : blog
 * @Version : 1.0.0
 */
@RestController
@RequestMapping("/api/admin/blog")
public class AdminBlogController {

    @Autowired()
    private BlogService blogService;
    @Autowired
    private TypeService typeService;
    @Autowired
    private TagService tagService;
    public static final Logger LOGGER = LoggerFactory.getLogger(BlogController.class);

    @DeleteMapping("/delete/{id}")
    public ResponseDto deleteBlog(@PathVariable("id") Integer id) {
        LOGGER.info("删除id为{}的Blog", id);
        int i = blogService.deleteByPrimaryKey(id);
        if (i != 0) {
            return ResponseDto.builder()
                    .code(ResultCode.SUCCESS.getCode())
                    .message(ResultMessage.SUCCESS.getMessaage())
                    .data(i)
                    .build();
        }
        LOGGER.error("删除id为{}的Blog失败！！！", id);
        return ResponseDto.builder()
                .code(ResultCode.FAIL.getCode())
                .message(ResultMessage.FAIL.getMessaage())
                .data(i)
                .build();
    }

    @PostMapping("/insert")
    public ResponseDto insertBlog(@RequestBody JSONObject jsonObject) {
        JSONObject jsonblog = jsonObject.getJSONObject("blog");
        JSONArray jsontagids = jsonObject.getJSONArray("tagids");
        Blog blog = jsonblog.toJavaObject(Blog.class);
        List<Integer> tagids = jsontagids.toJavaList(Integer.class);
        if (blog != null && !CollectionUtils.isEmpty(tagids)) {
            LOGGER.info("新增Blog", blog, tagids);
            int blogid = blogService.insertSelective(blog, tagids);
            if (blogid != 0) {
                return ResponseDto.builder()
                        .code(ResultCode.SUCCESS.getCode())
                        .message(ResultMessage.SUCCESS.getMessaage())
                        .data(blogService.selectBlogById(blogid))
                        .build();
            }
            LOGGER.error("新增失败!");
            return ResponseDto.builder()
                    .code(ResultCode.FAIL.getCode())
                    .message(ResultMessage.FAIL.getMessaage())
                    .data(blogService.selectBlogById(blogid))
                    .build();
        }
        LOGGER.error("参数为空，新增博客失败!");
        return ResponseDto.builder()
                .code(ResultCode.VALUE_NULL.getCode())
                .message(ResultMessage.VALUE_NULL.getMessaage())
                .data(null)
                .build();
    }

    @PutMapping("update")
    public ResponseDto updateBlog(@RequestBody JSONObject jsonObject) {
        JSONObject jsonblog = jsonObject.getJSONObject("blog");
        JSONArray jsontagids = jsonObject.getJSONArray("tagids");
        Blog blog = jsonblog.toJavaObject(Blog.class);
        List<Integer> tagids = jsontagids.toJavaList(Integer.class);
        if (blog != null && !CollectionUtils.isEmpty(tagids)) {
            LOGGER.info("修改id为{}的Blog", blog.getId());
            Blog updateblog = blogService.updateBlog(blog, tagids);
            if (updateblog != null) {
                LOGGER.info("修改id为{}的Blog成功！", blog.getId());
                return ResponseDto.builder()
                        .code(ResultCode.SUCCESS.getCode())
                        .message(ResultMessage.SUCCESS.getMessaage())
                        .data(updateblog)
                        .build();
            }
            LOGGER.error("修改id为{}的Blog失败！", blog.getId());
            return ResponseDto.builder()
                    .code(ResultCode.FAIL.getCode())
                    .message(ResultMessage.FAIL.getMessaage())
                    .data(null)
                    .build();
        }
        LOGGER.error("修改id为{}的Blog失败！参数为空", blog.getId());
        return ResponseDto.builder()
                .code(ResultCode.FAIL.getCode())
                .message(ResultMessage.FAIL.getMessaage())
                .data(null)
                .build();
    }
}
