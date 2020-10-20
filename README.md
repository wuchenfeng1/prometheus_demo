#Spring Boot Metrics监控之Prometheus
 + Prometheus 与 Grafana 安装过于简单，不做演示
 + Prometheus架构图
```
 ![Image text](https://github.com/wuchenfeng1/prometheus_demo/jgt.png)
  ```
 + 配置Prometheus的监控程序
 ```
   - job_name: 'monitor_prometheus_job'
     scrape_interval: 5s
     metrics_path: '/api/actuator/prometheus'
     static_configs:
     - targets: ['127.0.0.1:8090']
 ```
 + 通过web.hook配置alertmanager的告警渠道
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
     - url: 'http://127.0.0.1:8090/alert/msg' // 告警渠道
     send_resolved: true
   inhibit_rules:
     - source_match:
         severity: 'critical'
       target_match:
         severity: 'warning'
       equal: ['alertname', 'dev', 'instance']
 ```

 
 



