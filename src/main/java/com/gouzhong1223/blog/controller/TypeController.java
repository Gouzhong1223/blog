package com.gouzhong1223.blog.controller;

import com.gouzhong1223.blog.common.ResultCode;
import com.gouzhong1223.blog.common.ResultMessage;
import com.gouzhong1223.blog.dto.ResponseDto;
import com.gouzhong1223.blog.pojo.Type;
import com.gouzhong1223.blog.service.TypeService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/listall")
    public ResponseDto listAllTypes() {
        LOGGER.info("获取所有Type");
        List<Type> types = typeService.listAllTypes();
        if (CollectionUtils.isEmpty(types)) {
            LOGGER.error("获取所有Type失败！");
            return new ResponseDto(ResultCode.FAIL.getCode(), ResultMessage.FAIL.getMessaage());
        }
        LOGGER.info("获取所有Type成功！");
        return new ResponseDto(ResultCode.SUCCESS.getCode(), ResultMessage.SUCCESS.getMessaage(), types);
    }

    @PostMapping("/insert")
    public ResponseDto insertType(@RequestParam("typename") String typename) {
        if (StringUtils.isNotEmpty(typename)) {
            if (!typeService.isExist(typename)) {
                LOGGER.info("插入名为{}的type", typename);
                Type type = typeService.insertType(typename);
                return new ResponseDto(ResultCode.SUCCESS.getCode(), ResultMessage.SUCCESS.getMessaage(), type);
            }
            LOGGER.error("type已经存在", typename);
            return new ResponseDto(ResultCode.ISEXIST.getCode(), ResultMessage.ISEXIST.getMessaage());
        }
        LOGGER.error("typename为空", typename);
        return new ResponseDto(ResultCode.VALUE_NULL.getCode(), ResultMessage.VALUE_NULL.getMessaage());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseDto deleteType(@PathVariable("id") Integer id) {
        int i = typeService.deleteType(id);
        if (i != 0) {
            LOGGER.info("删除id为{}的Type", id);
            return new ResponseDto(ResultCode.SUCCESS.getCode(), ResultMessage.SUCCESS.getMessaage(), i);
        }
        LOGGER.error("删除id为{}的Type失败！", id);
        return new ResponseDto(ResultCode.FAIL.getCode(), ResultMessage.FAIL.getMessaage());
    }

    @PutMapping("/update")
    public ResponseDto updateType(@RequestBody Type type) {
        if (StringUtils.isNotEmpty(type.getTypename())) {
            Type updateType = typeService.updateType(type);
            if (updateType != null) {
                LOGGER.info("修改id为{}的Type", type.getId());
                return new ResponseDto(ResultCode.SUCCESS.getCode(), ResultMessage.SUCCESS.getMessaage(), type);
            }
            LOGGER.error("修改id为{}的Type失败！", type.getId());
            return new ResponseDto(ResultCode.FAIL.getCode(), ResultMessage.FAIL.getMessaage());
        }
        LOGGER.error("修改id为{}的Type失败！,参数为空！", type.getId());
        return new ResponseDto(ResultCode.VALUE_NULL.getCode(), ResultMessage.VALUE_NULL.getMessaage());
    }
}
