package com.gouzhong1223.blog.service.impl;

import com.gouzhong1223.blog.mapper.TypeMapper;
import com.gouzhong1223.blog.pojo.Type;
import com.gouzhong1223.blog.service.TypeService;
import com.gouzhong1223.blog.util.DateTimeUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Author : Gouzhong
 * @Blog : www.gouzhong1223.com
 * @Description : TypeServiceImpl
 * @Date : create by QingSong in 2020-02-01 4:47 下午
 * @Email : gouzhong1223@gmail.com
 * @Since : JDK 1.8
 * @PackageName : com.gouzhong1223.blog.service.impl
 * @ProjectName : blog
 * @Version : 1.0.0
 */
@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeMapper typeMapper;
    public static final Logger LOGGER = LoggerFactory.getLogger(TypeServiceImpl.class);

    @Override
    public Type selectTypeById(Integer id) {
        return typeMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Type> listAllTypes() {
        return typeMapper.selectAllTypes();
    }

    @Override
    public Type insertType(String typename) {
        Type type = new Type();
        type.setTypename(typename);
        type.setCreatetime(DateTimeUtil.getDateTime());
        type.setUpdatetime(DateTimeUtil.getDateTime());
        typeMapper.insertSelective(type);
        return type;
    }

    @Override
    public boolean isExist(String typename) {
        if (StringUtils.isNotEmpty(typename)) {
            Type type = typeMapper.selectOneByTypename(typename);
            if (type != null) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int deleteType(Integer id) {
        return typeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Type updateType(Type type) {
        Type selectByPrimaryKey = typeMapper.selectByPrimaryKey(type.getId());
        if (selectByPrimaryKey == null) {
            LOGGER.error("需要修改id为{}的Type不存在", type.getId());
            return null;
        }
        selectByPrimaryKey.setTypename(type.getTypename());
        selectByPrimaryKey.setUpdatetime(DateTimeUtil.getDateTime());
        int i = typeMapper.updateByPrimaryKey(selectByPrimaryKey);
        if (i != 0) {
            return selectByPrimaryKey;
        }
        return null;
    }
}
