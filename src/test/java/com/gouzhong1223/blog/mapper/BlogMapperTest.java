package com.gouzhong1223.blog.mapper;


import com.gouzhong1223.blog.pojo.Blog;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * @Author : Gouzhong
 * @Blog : www.gouzhong1223.com
 * @Description : TODO
 * @Date : create by QingSong in 2020-02-03 10:24 下午
 * @Email : gouzhong1223@gmail.com
 * @Since : JDK 1.8
 * @PackageName : com.gouzhong1223.blog.mapper
 * @ProjectName : blog
 * @Version :
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class BlogMapperTest {

    @Autowired
    private BlogMapper blogMapper;

    @Test
    public void selectByPrimaryKey() {
        Blog blog = blogMapper.selectByPrimaryKey(9);
        System.out.println(blog+"---------");
    }
}
