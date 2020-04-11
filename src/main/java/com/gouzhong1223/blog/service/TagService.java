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

package com.gouzhong1223.blog.service;

import com.gouzhong1223.blog.pojo.Tag;

import java.util.List;

/**
 * @Author : Gouzhong
 * @Blog : www.gouzhong1223.com
 * @Description : 标签业务
 * @Date : create by QingSong in 2020-02-01 4:45 下午
 * @Email : gouzhong1223@gmail.com
 * @Since : JDK 1.8
 * @PackageName : com.gouzhong1223.blog.service
 * @ProjectName : blog
 * @Version : 1.0.0
 */
public interface TagService {

    /**
     * 新增Tag
     *
     * @param tagname
     * @return 插入成功返回Tag，失败返回null
     */
    Tag insertTag(String tagname);

    /**
     * 根据主键删除Tag
     *
     * @param id
     */
    void deleteTagByTagid(Integer id);

    /**
     * 修改Tag
     *
     * @param tag
     * @return 成功返回修改后的Tag，失败返回Null
     */
    Tag updateTag(Tag tag);

    /**
     * 获取所有的Tag
     *
     * @return Tags
     */
    List<Tag> listAllTags();

    /**
     * 根据id查询Tag
     *
     * @param id 主键
     * @return Tag
     */
    Tag selectTagById(Integer id);
}
