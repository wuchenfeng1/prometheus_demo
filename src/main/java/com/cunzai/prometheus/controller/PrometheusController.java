package com.cunzai.prometheus.controller;

import com.alibaba.fastjson.JSONObject;
import com.cunzai.prometheus.service.WayService;
import com.cunzai.prometheus.utils.ApplicationContextUtil;
import com.cunzai.prometheus.utils.ResponseBean;
import com.cunzai.prometheus.utils.ResponseUtil;
import com.cunzai.prometheus.utils.emum.SendWayEnum;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: wuchenfeng
 */
@RestController
public class PrometheusController {

    @PostMapping("/alert/msg")
    public ResponseBean sendAlertChannel(@RequestBody String request){
        System.out.println("接受的告警信息"+request);
        // 通过到
        JSONObject json = JSONObject.parseObject(request);
        //接受的告警信息发送到各个渠道的告警中
        //通过自定义告警规则的发送不通渠道的告警，可以采用策略设计模式,使用策略设计模式易于扩展
        String way = json.getString("way");
        String scanTypeImpl= SendWayEnum.getServiceImplByCode(way);
        WayService wayService  = (WayService) ApplicationContextUtil.getBean(scanTypeImpl);
        wayService.sendAlertChannel();
        return ResponseUtil.success();
    }




    
}
