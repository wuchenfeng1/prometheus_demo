package com.cunzai.prometheus.service.impl;



import com.cunzai.prometheus.service.WayService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;




/**
 * @author: wuchenfeng
 * 日期 2020/9/11 10:06
 */
@Service
public class DingtalkServiceImpl implements WayService {

    private static final Logger logger = LoggerFactory.getLogger(DingtalkServiceImpl.class);
    @Override
    public void sendAlertChannel() {
        logger.info("配置钉钉api信息发送钉钉消息....");
    }
}
