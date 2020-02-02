package com.gouzhong1223.blog.service.impl;

import com.gouzhong1223.blog.mapper.TypeMapper;
import com.gouzhong1223.blog.pojo.Type;
import com.gouzhong1223.blog.service.TypeService;
import org.apache.commons.lang3.StringUtils;
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

    @Override
    public Type selectTypeById(Integer id) {
        return typeMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Type> listAllTypes() {
        return typeMapper.selectAllTypes();
    }

    @Override
    public int insertType(String typename) {
        Type type = new Type();
        type.setTypename(typename);
        type.setCreatetime(new Date());
        type.setUpdatetime(new Date());
        return typeMapper.insertSelective(type);
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
}
