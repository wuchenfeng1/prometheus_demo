package com.cunzai.prometheus.utils;

import io.micrometer.core.instrument.Metrics;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: wuchenfeng
 * 日期 2020/9/8 15:10
 */
public class MetricsUtils {
    /**
     * 异常
     * @param informationInfo  指标名称
     * @param exceptionMsg 异常信息
     */
    public static  void exceptionMessage(String informationInfo,String exceptionMsg){
        Metrics.counter(informationInfo,"exception_total",exceptionMsg, "createTime",new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())).increment();
    }

    /**
     * 返回值
     * @param informationInfo 指标名称
     * @param msg 返回值的内容
     */
    public static void returnVal(String informationInfo,String msg) {
        Metrics.counter(informationInfo,"return_val_total",msg, "createTime",new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())).increment();
    }
    /**
     * 超时时间
     * @param informationInfo 指标名称
     * @param timeOut 超时时间
     */
    public static void timeOut(String informationInfo,String timeOut) {
        Metrics.counter(informationInfo,"time_out_total",timeOut , "createTime",new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())).increment();
    }









//
//    public static  void exceptionMessage(String informationInfo,String exceptionMsg){
//        Metrics.counter("requests_error_total",
//                "status", "500","message",exceptionMsg,
//                "createTime",new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())).increment();
//    }
//    public static void returnVal(String informationInfo,String msg) {
//        Metrics.counter("requests_return_val_total",
//                "status", "200","message","返回值",
//                "createTime",new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())).increment();
//    }
//
//    public static void timeOut(String informationInfo,String timeOut) {
//        Metrics.counter("requests_time_out_total",
//                "status", "408","message","请求超时",
//                "createTime",new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())).increment();
//    }


}
