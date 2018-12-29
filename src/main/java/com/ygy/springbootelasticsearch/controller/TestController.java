package com.ygy.springbootelasticsearch.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Auther: yanguangyuan
 * @Date: 2018/12/29 10:59
 * @Description: 测试
 */
@Controller
@Api(value = "TestController",description = "测试地址")
@RequestMapping(value = "test")
public class TestController {

    @ApiOperation("初步测试")
    @ResponseBody
    @GetMapping("1")
    public String test1(){
        return "1234";
    }
}
