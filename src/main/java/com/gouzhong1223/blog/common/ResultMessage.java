package com.gouzhong1223.blog.common;

import lombok.Getter;

/**
 * @Author : Gouzhong
 * @Blog : www.gouzhong1223.com
 * @Description : ResultMessage
 * @Date : create by QingSong in 2020-02-01 8:05 下午
 * @Email : gouzhong1223@gmail.com
 * @Since : JDK 1.8
 * @PackageName : com.gouzhong1223.blog.common
 * @ProjectName : blog
 * @Version : 1.0.0
 */
@Getter
public enum ResultMessage {

    SUCCESS("操作成功！"),
    FAIL("删除失败!"),
    VALUE_NULL("数据为空"),
    ISEXIST("存在同名标签或者分类"),
    LOGINFAIL("登录失败"),
    UNLOGIN("未登录")
    ;

    private String messaage;

    ResultMessage(String messaage) {
        this.messaage = messaage;
    }
}
