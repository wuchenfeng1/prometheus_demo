package com.cunzai.prometheus.service.impl;


import com.cunzai.prometheus.service.WayService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author: wuchenfeng
 * 日期 2020/9/15 14:55
 */
@Service
public class SmsServiceImpl implements WayService {

    private static final Logger logger = LoggerFactory.getLogger(SmsServiceImpl.class);


    @Override
    public void sendAlertChannel() {
        logger.info("配置短信相关的api信息发送短信就可以了....");
    }
}
