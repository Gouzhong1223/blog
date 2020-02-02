package com.gouzhong1223.blog.controller;

import com.gouzhong1223.blog.service.TypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author : Gouzhong
 * @Blog : www.gouzhong1223.com
 * @Description : TypeController
 * @Date : create by QingSong in 2020-02-02 12:27 PM
 * @Email : gouzhong1223@gmail.com
 * @Since : JDK 1.8
 * @PackageName : com.gouzhong1223.blog.controller
 * @ProjectName : blog
 * @Version : 1.0.0
 */
@RestController
@RequestMapping("api/type")
public class TypeController {

    @Autowired
    private TypeService typeService;
    public static final Logger LOGGER = LoggerFactory.getLogger(TypeController.class);
}
