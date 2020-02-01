package com.gouzhong1223.blog.service;

import com.gouzhong1223.blog.pojo.Blog;
import com.gouzhong1223.blog.pojo.Blogtag;
import com.gouzhong1223.blog.pojo.Tag;

import java.util.List;

/**
 * @Author : Gouzhong
 * @Blog : www.gouzhong1223.com
 * @Description : Blog服务
 * @Date : create by QingSong in 2020-02-01 4:45 下午
 * @Email : gouzhong1223@gmail.com
 * @Since : JDK 1.8
 * @PackageName : com.gouzhong1223.blog.service
 * @ProjectName : blog
 * @Version : 1.0.0
 */
public interface BlogService {
    /**
     * 根据id删除博客
     *
     * @param id id
     * @return 成功非0 失败为0
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 根据实例插入博客
     *
     * @param record 实例
     * @param tags   标签
     * @return
     */
    int insertSelective(Blog record, List<Tag> tags);

    /**
     * 查询所有博客
     *
     * @return
     */
    List<Blog> listAllBlogs();

    /**
     * 根据BlogId查询Blog
     *
     * @param id 主键
     * @return Blog
     */
    Blog selectBlogById(Integer id);

    /**
     * 根据BlogId查询Blogtag
     *
     * @param id 主键
     * @return List<Blogtag>
     */
    List<Blogtag> selectBlogTagsByBlogId(Integer id);

}
