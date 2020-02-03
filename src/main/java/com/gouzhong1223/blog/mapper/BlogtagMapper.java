package com.gouzhong1223.blog.mapper;

import com.gouzhong1223.blog.pojo.Blogtag;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * Created by Gouzhong1223 Generator 2020/02/01
 */
public interface BlogtagMapper {
    int insert(Blogtag record);

    int insertOrUpdate(Blogtag record);

    int insertOrUpdateSelective(Blogtag record);

    int insertSelective(Blogtag record);

    int batchInsert(@Param("list") List<Blogtag> list);

    List<Blogtag> selectAllByBlogid(@Param("blogid")Integer blogid);

    int deleteByBlogid(@Param("blogid")Integer blogid);

    List<Blogtag> selectAllByTagid(@Param("tagid")Integer tagid);

    int deleteByTagid(@Param("tagid")Integer tagid);

    int updateTagidByBlogid(@Param("updatedTagid")Integer updatedTagid,@Param("blogid")Integer blogid);

}