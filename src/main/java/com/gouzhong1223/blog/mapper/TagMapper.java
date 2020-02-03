package com.gouzhong1223.blog.mapper;

import com.gouzhong1223.blog.pojo.Tag;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
* Created by Gouzhong1223 Generator 2020/02/01
*/
public interface TagMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Tag record);

    int insertOrUpdate(Tag record);

    int insertOrUpdateSelective(Tag record);

    int insertSelective(Tag record);

    Tag selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Tag record);

    int updateByPrimaryKey(Tag record);

    int updateBatch(List<Tag> list);

    int batchInsert(@Param("list") List<Tag> list);

    List<Tag> listAllTags();

    Tag selectOneByTagname(@Param("tagname")String tagname);
    
}