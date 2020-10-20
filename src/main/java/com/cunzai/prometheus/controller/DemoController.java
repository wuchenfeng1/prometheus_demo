package com.cunzai.prometheus.controller;


import com.cunzai.prometheus.annotation.DecryptRequest;
import com.cunzai.prometheus.annotation.SysLogAnnotation;
import com.cunzai.prometheus.utils.ResponseBean;
import com.cunzai.prometheus.utils.ResponseUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: wuchenfeng
 * 日期 2020/10/10 10:30
 */
@Api(value="/")
@RestController
public class DemoController {


    @PostMapping("/test1")
    @SysLogAnnotation("日志测试")
    @DecryptRequest
    @ApiOperation(value = "日志测试", notes = "日志测试", httpMethod = "POST")
    public ResponseBean test1(@RequestBody String request){

        return ResponseUtil.success();
    }



}
