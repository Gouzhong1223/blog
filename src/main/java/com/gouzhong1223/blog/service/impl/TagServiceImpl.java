package com.gouzhong1223.blog.service.impl;

import com.gouzhong1223.blog.mapper.TagMapper;
import com.gouzhong1223.blog.pojo.Blog;
import com.gouzhong1223.blog.pojo.Tag;
import com.gouzhong1223.blog.service.TagService;
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
    public static final Logger LOGGER = LoggerFactory.getLogger(TagServiceImpl.class);

    @Override
    public Tag insertTag(String tagname) {
        Tag tag = new Tag();
        tag.setTagname(tagname);
        tag.setCreatetime(new Date());
        tag.setUpdatetime(new Date());
        int i = tagMapper.insertSelective(tag);
        if (i != 0) {
            return tag;
        }
        return null;
    }

    @Override
    public void deleteTagByTagid(Integer id) {

    }

    @Override
    public Blog updateTag(Tag tag) {
        return null;
    }

    @Override
    public List<Tag> listAllTags() {
        return tagMapper.listAllTags();
    }
}
