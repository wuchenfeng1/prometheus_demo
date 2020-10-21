#Spring Boot Metrics监控之Prometheus
 + Prometheus 与 Grafana 、Alertmanager安装过于简单，不做演示
 + Prometheus架构图
 + ![Image text](https://github.com/wuchenfeng1/prometheus_demo/blob/master/jgt.png)
 + 配置Prometheus的监控程序
 ```

   - job_name: 'monitor_prometheus_job'
     scrape_interval: 5s
     metrics_path: '/api/actuator/prometheus' //指标信息
     static_configs:
     - targets: ['127.0.0.1:8090']
 ```
 + 自定义告警规则 1.yml
 ```
 在prometheus.yml中添加如下：
  rule_files:
    - "rules/*.yml" //自定义告警规则文件1.yml
```
 ```
 //yml 的内容如下：
groups:
# 组名
- name: "交易支付-超时"
  rules:
  # 告警名称
  - alert: "交易支付-超时"
    # 表达式
    expr: cz_time_out_total
    # 持续时间
    for: 1s
    labels:
      # 严重等级
      severity: "高"
    annotations:
      # 告警概括
      summary: "交易支付-超时"
      # 告警描述
      description: "交易支付-超时：超时信息（当前值：{{ $value }}）"
      # 自定义告警发送方式
      sendWay: "5-3,3-2,2-1"
```
 + 通过web.hook配置alertmanager的告警渠道,告警渠道(自定义钉钉、邮件、email、短信、企业微信、飞书)
 ```
   global:
     resolve_timeout: 5m
   route:
     group_by: ['alertname']
     group_wait: 10s
     group_interval: 10s
     repeat_interval: 1h
     receiver: 'web.hook'
   receivers:
   - name: 'web.hook'
     webhook_configs:
     - url: 'http://127.0.0.1:8090/alert/msg' // 自定义告警规则的发送不通渠道的告警，可以采用策略设计模式,使用策略设计模式易于扩展
     send_resolved: true
   inhibit_rules:
     - source_match:
         severity: 'critical'
       target_match:
         severity: 'warning'
       equal: ['alertname', 'dev', 'instance']
      
 ```
  + 告警渠道接口：/alert/msg (自定义钉钉、邮件、email、短信、企业微信、飞书)
   ```
   自定义告警规则的发送不通渠道的告警，可以使用策略设计模式构建多个渠道，易于扩展和代码的维护
   ```
  + 通过注解的方式对请求参数加密和解密 
  用法：在Controller的方法上加上@DecryptRequest/@EncryptResponse 请求或者响应加解密

  + 通过注解的方式对操作日志
  用法：在Controller的方法上加上 @SysLogAnnotation("日志测试") 会记录接口的执行动作
 
  + WebSocket类是WebSocket的配置类向前端推送消息

  + OkHttpClient类是向指定 URL 发送POST方法的请求
  
  + 接口文档：http://localhost:8090/api/swagger-ui.html 


 
 






