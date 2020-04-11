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
