package com.gouzhong1223.blog.service.impl;

import com.gouzhong1223.blog.mapper.BlogMapper;
import com.gouzhong1223.blog.mapper.BlogtagMapper;
import com.gouzhong1223.blog.pojo.Blog;
import com.gouzhong1223.blog.pojo.Blogtag;
import com.gouzhong1223.blog.pojo.Tag;
import com.gouzhong1223.blog.service.BlogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
        if (blogMapper.deleteByPrimaryKey(id) == 0) {
            LOGGER.error("删除id为{}的Blog失败", id);
            return blogMapper.deleteByPrimaryKey(id);
        }
        LOGGER.info("删除id为{}的Blog", id);

        return blogMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(Blog blog, List<Tag> tags) {
        int prid = 0;
        if (blog != null) {
            ArrayList<Blogtag> blogtags = new ArrayList<>();
            prid = blogMapper.insertSelective(blog);
            for (Tag tag : tags) {
                blogtags.add(new Blogtag(prid, tag.getId()));
            }
            int batchInsert = blogtagMapper.batchInsert(blogtags);
            if (batchInsert == 0) {
                LOGGER.error("新增Blog失败");
                return 0;
            }
            return prid;
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
}
