package com.gouzhong1223.blog.mapper;

import com.gouzhong1223.blog.pojo.Type;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * Created by Gouzhong1223 Generator 2020/02/01
 */
public interface TypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Type record);

    int insertOrUpdate(Type record);

    int insertOrUpdateSelective(Type record);

    int insertSelective(Type record);

    Type selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Type record);

    int updateByPrimaryKey(Type record);

    int updateBatch(List<Type> list);

    int batchInsert(@Param("list") List<Type> list);

    List<Type> selectAllTypes();

    Type selectOneByTypename(@Param("typename")String typename);

}