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