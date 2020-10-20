package com.cunzai.prometheus.utils.emum;

/**
 * @author: wuchenfeng
 * 日期 2020/10/14 11:16
 */
public enum AlertStatus {

    /**
     * 未处理
     */
    UNHANDLE("1"),

    /**
     * 已处理
     */
    HANDLE("2");

    private final String value;

    AlertStatus(String value) {
        this.value = value;
    }

    public String value() {
        return this.value;
    }
}
