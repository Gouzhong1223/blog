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

package com.gouzhong1223.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gouzhong1223.blog.common.PageResult;
import com.gouzhong1223.blog.mapper.BlogMapper;
import com.gouzhong1223.blog.mapper.BlogtagMapper;
import com.gouzhong1223.blog.pojo.Blog;
import com.gouzhong1223.blog.pojo.Blogtag;
import com.gouzhong1223.blog.service.BlogService;
import com.gouzhong1223.blog.util.DateTimeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

/**
 * @Author : Gouzhong
 * @Blog : www.gouzhong1223.com
 * @Description :
 * @Date : create by QingSong in 2020-02-01 4:46 下午
 * @Email : gouzhong1223@gmail.com
 * @Since : JDK 1.8
 * @PackageName : com.gouzhong1223.blog.service.impl
 * @ProjectName : blog
 * @Version : 1.0.0
 */
@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogMapper blogMapper;
    @Autowired
    private BlogtagMapper blogtagMapper;
    public static final Logger LOGGER = LoggerFactory.getLogger(BlogServiceImpl.class);


    @Override
    public int deleteByPrimaryKey(Integer id) {
        Blog blog = blogMapper.selectByPrimaryKey(id);
        if (blog == null) {
            LOGGER.error("当前需要删除的id为{}的Blog不存在！", id);
            return 0;
        }
        try {
            LOGGER.info("删除id为{}的Blog", id);
            blogMapper.deleteByPrimaryKey(id);
            LOGGER.info("开始删除id为{}的Blog所对应的所有Tags", id);
            blogtagMapper.deleteByBlogid(id);
        } catch (Exception e) {
            LOGGER.info("删除id为{}的Blog失败！", id);
            e.printStackTrace();
            return 0;
        }
        return 1;
    }

    @Override
    public int insertSelective(Blog blog, List<Integer> tagids) {
        int insert = 0;
        if (blog != null) {
            blog.setCreatetime(DateTimeUtil.getDateTime());
            blog.setUpdatetime(DateTimeUtil.getDateTime());
            ArrayList<Blogtag> blogtags = new ArrayList<>();
            insert = blogMapper.insertSelective(blog);
            for (Integer tagid : tagids) {
                blogtags.add(new Blogtag(blog.getId(), tagid));
            }
            int batchInsert = blogtagMapper.batchInsert(blogtags);
            if (batchInsert == 0 || insert == 0) {
                LOGGER.error("新增Blog失败");
                return 0;
            }
            return blog.getId();
        }
        LOGGER.error("blog为空,新增失败！！！");
        return 0;
    }

    @Override
    public List<Blog> listAllBlogs() {
        return blogMapper.selectAllBlogs();
    }

    @Override
    public Blog selectBlogById(Integer id) {
        if (id != null) {
            return blogMapper.selectByPrimaryKey(id);
        }
        return null;
    }

    @Override
    public List<Blogtag> selectBlogTagsByBlogId(Integer id) {
        return blogtagMapper.selectAllByBlogid(id);
    }

    @Override
    public int deleteBlogTagsByBlogId(Integer id) {
        return blogtagMapper.deleteByBlogid(id);
    }

    @Override
    public PageResult<Blog> listBlogByPage(Integer pageNum, Integer pageSize) {
        LOGGER.info("封装分页参数，当前页数{}，每一页大小{}", pageNum, pageSize);
        PageHelper.startPage(pageNum, pageSize);
        LOGGER.info("开始查询所有Blog");
        List<Blog> blogs = blogMapper.selectAllBlogs();
        ArrayList<Blog> visitBlogs = new ArrayList<>();
        for (Blog blog : blogs) {
            if (blog.getVisible() == 1) {
                visitBlogs.add(blog);
            }
        }
        PageInfo<Blog> blogPageInfo = new PageInfo<>(visitBlogs);
        LOGGER.info("开始封装分页数据", blogPageInfo);
        return new PageResult<>(blogPageInfo.getPageNum(), blogPageInfo.getPageSize(), blogPageInfo.getTotal(), blogPageInfo.getPages(), blogPageInfo.getList());
    }

    @Override
    public Blog updateBlog(Blog blog, List<Integer> tagids) {
        Blog selectByPrimaryKey = blogMapper.selectByPrimaryKey(blog.getId());
        String createtime = selectByPrimaryKey.getCreatetime();
        BeanUtils.copyProperties(blog, selectByPrimaryKey);
        selectByPrimaryKey.setUpdatetime(DateTimeUtil.getDateTime());
        selectByPrimaryKey.setCreatetime(createtime);
        LOGGER.info("开始更新Blog");
        int update = blogMapper.updateByPrimaryKey(selectByPrimaryKey);
        if (update != 0) {
            LOGGER.info("开始更新Blog对应的Tag");
            for (Integer tagid : tagids) {
                blogtagMapper.updateTagidByBlogid(tagid, blog.getId());
            }
            return selectByPrimaryKey;
        }
        return null;
    }

    @Override
    public int updateBlogVisible(Integer id) {
        Blog blog = blogMapper.selectByPrimaryKey(id);
        int update = 0;
        if (blog.getVisible() == 0) {
            update = blogMapper.updateVisibleById(1, id);
        }
        update = blogMapper.updateVisibleById(0, id);
        return update;
    }
}
