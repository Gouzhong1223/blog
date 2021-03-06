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

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gouzhong1223.blog.common.PageResult;
import com.gouzhong1223.blog.common.ResultCode;
import com.gouzhong1223.blog.common.ResultMessage;
import com.gouzhong1223.blog.controller.BlogController;
import com.gouzhong1223.blog.dto.ResponseDto;
import com.gouzhong1223.blog.pojo.Blog;
import com.gouzhong1223.blog.service.BlogService;
import com.gouzhong1223.blog.service.TagService;
import com.gouzhong1223.blog.service.TypeService;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
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
@Api("Blog管理员操作接口")
public class AdminBlogController {

    @Autowired()
    private BlogService blogService;
    @Autowired
    private TypeService typeService;
    @Autowired
    private TagService tagService;
    public static final Logger LOGGER = LoggerFactory.getLogger(BlogController.class);

    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "根据传递过来的id删除Blog", notes = "删除Blog", httpMethod = "DELETE")
    @ApiImplicitParam(name = "id", value = "主键", required = true, dataType = "Integer", paramType = "path", example = "1", dataTypeClass = Integer.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "操作成功", response = ResponseDto.class),
            @ApiResponse(code = 201, message = "操作失败", response = ResponseDto.class)
    })
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

    @PostMapping("/pagelist")
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

    @PutMapping("/updatevisible/{id}")
    public ResponseDto updateBlogVisible(@PathVariable("id") Integer id) {
        int update = blogService.updateBlogVisible(id);
        if (update != 0) {
            LOGGER.info("修改id为{}的Blog的显示状态成功！", id);
            return ResponseDto.builder()
                    .code(ResultCode.SUCCESS.getCode())
                    .message(ResultMessage.SUCCESS.getMessaage())
                    .data(id)
                    .build();
        }
        LOGGER.error("修改id为{}的Blog的显示状态失败！", id);
        return ResponseDto.builder()
                .code(ResultCode.FAIL.getCode())
                .message(ResultMessage.FAIL.getMessaage())
                .data(null)
                .build();
    }
}
