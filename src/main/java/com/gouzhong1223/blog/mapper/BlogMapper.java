package com.gouzhong1223.blog.mapper;

import com.gouzhong1223.blog.pojo.Blog;import org.apache.ibatis.annotations.Param;import java.util.List;

/**
 * @Author : Gouzhong
 * @Blog : www.gouzhong1223.com
 * @Description : BlogMapper
 * @Date : create by QingSong in 2020-02-03 11:32 PM
 * @Email : gouzhong1223@gmail.com
 * @Since : JDK 1.8
 * @PackageName : com.gouzhong1223.blog.mapper
 * @ProjectName : blog
 * @Version : ${VERSION}
 */
public interface BlogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Blog record);

    int insertSelective(Blog record);

    Blog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Blog record);

    int updateByPrimaryKey(Blog record);

    int insertOrUpdate(Blog record);

    int insertOrUpdateSelective(Blog record);

    int updateBatch(List<Blog> list);

    int batchInsert(@Param("list") List<Blog> list);

    /**
     * 查询所有博客
     *
     * @return
     */
    List<Blog> selectAllBlogs();

    List<Blog> selectAllByTypeid(@Param("typeid") Integer typeid);

    int updateVisibleById(@Param("updatedVisible")Integer updatedVisible,@Param("id")Integer id);

}