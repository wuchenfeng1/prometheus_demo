package com.cunzai.prometheus.controller;


import com.cunzai.prometheus.annotation.DecryptRequest;
import com.cunzai.prometheus.annotation.SysLogAnnotation;
import com.cunzai.prometheus.utils.ResponseBean;
import com.cunzai.prometheus.utils.ResponseUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: wuchenfeng
 * 日期 2020/10/10 10:30
 */
@RestController
public class DemoController {


    @PostMapping("/test1")
    @SysLogAnnotation("日志测试")
    @DecryptRequest
    public ResponseBean test1(@RequestBody String request){

        return ResponseUtil.success();
    }



}
