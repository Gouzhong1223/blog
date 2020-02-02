package com.gouzhong1223.blog.mapper;

import com.gouzhong1223.blog.pojo.Blog;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * Created by Mybatis Generator 2020/02/01
 */
public interface BlogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Blog record);

    int insertOrUpdate(Blog record);

    int insertOrUpdateSelective(Blog record);

    int insertSelective(Blog record);

    Blog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Blog record);

    int updateByPrimaryKey(Blog record);

    int updateBatch(List<Blog> list);

    int batchInsert(@Param("list") List<Blog> list);

    /**
     * 查询所有博客
     *
     * @return
     */
    List<Blog> selectAllBlogs();

    List<Blog> selectAllByTypeid(@Param("typeid")Integer typeid);


}