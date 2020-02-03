package com.gouzhong1223.blog.service;

import com.gouzhong1223.blog.pojo.Type;

import java.util.List;

/**
 * @Author : Gouzhong
 * @Blog : www.gouzhong1223.com
 * @Description : 分类业务
 * @Date : create by QingSong in 2020-02-01 4:46 下午
 * @Email : gouzhong1223@gmail.com
 * @Since : JDK 1.8
 * @PackageName : com.gouzhong1223.blog.service
 * @ProjectName : blog
 * @Version : 1.0.0
 */
public interface TypeService {

    /**
     * 根据id查询Type
     *
     * @param id 主键
     * @return
     */
    Type selectTypeById(Integer id);

    /**
     * 获取所有Type
     *
     * @return List->Types
     */
    List<Type> listAllTypes();

    /**
     * 新增Type
     *
     * @param typename
     * @return 主键
     */
    Type insertType(String typename);

    /**
     * 判断该type是否已经存在
     *
     * @param typename
     * @return true->存在 false->不存在
     */
    boolean isExist(String typename);

    /**
     * 根据id删除Type
     *
     * @param id 主键
     */
    int deleteType(Integer id);

    /**
     * 修改Type
     *
     * @param type
     * @return 修改之后的Type
     */
    Type updateType(Type type);
}
