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

package com.gouzhong1223.blog.service.impl;

import com.gouzhong1223.blog.mapper.BlogtagMapper;
import com.gouzhong1223.blog.mapper.TagMapper;
import com.gouzhong1223.blog.pojo.Tag;
import com.gouzhong1223.blog.service.TagService;
import com.gouzhong1223.blog.util.DateTimeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Author : Gouzhong
 * @Blog : www.gouzhong1223.com
 * @Description :
 * @Date : create by QingSong in 2020-02-01 4:47 下午
 * @Email : gouzhong1223@gmail.com
 * @Since : JDK 1.8
 * @PackageName : com.gouzhong1223.blog.service.impl
 * @ProjectName : blog
 * @Version : 1.0.0
 */
@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagMapper tagMapper;
    @Autowired
    private BlogtagMapper blogtagMapper;
    public static final Logger LOGGER = LoggerFactory.getLogger(TagServiceImpl.class);

    @Override
    public Tag insertTag(String tagname) {
        Tag byTagname = tagMapper.selectOneByTagname(tagname);
        if (byTagname == null) {
            Tag tag = new Tag();
            tag.setTagname(tagname);
            tag.setCreatetime(DateTimeUtil.getDateTime());
            tag.setUpdatetime(DateTimeUtil.getDateTime());
            int i = tagMapper.insertSelective(tag);
            if (i != 0) {
                LOGGER.info("新增Tag{}", tag);
                return tag;
            }
        }
        LOGGER.error("新增Tag失败，已经存在相同的Tag！");
        return null;
    }

    @Override
    public void deleteTagByTagid(Integer id) {
        tagMapper.deleteByPrimaryKey(id);
        blogtagMapper.deleteByTagid(id);
    }

    @Override
    public Tag updateTag(Tag tag) {
        Tag select = tagMapper.selectByPrimaryKey(tag.getId());
        select.setUpdatetime(DateTimeUtil.getDateTime());
        select.setTagname(tag.getTagname());
        LOGGER.info("修改Tagid为{}的Tag", tag.getId());
        int i = tagMapper.updateByPrimaryKey(select);
        if (i != 0) {
            return tag;
        }
        LOGGER.error("修改Tag失败！");
        return null;
    }

    @Override
    public List<Tag> listAllTags() {
        return tagMapper.listAllTags();
    }

    @Override
    public Tag selectTagById(Integer id) {
        return tagMapper.selectByPrimaryKey(id);
    }
}
