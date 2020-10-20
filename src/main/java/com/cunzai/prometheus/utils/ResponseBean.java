package com.cunzai.prometheus.utils;
import java.util.Date;

/**
 * @version 1.0
 * @author: wuchenfeng
 * 日期  15:30
 * @since 1.0
 */


public class ResponseBean<T> {
    private Date timestamp;
    private String status;
    private Object message;
    private T content;

    public ResponseBean() {
    }

    public ResponseBean(String status, Object message, T content) {
        this.status = status;
        this.message = message;
        this.content = content;
        this.timestamp = new Date();
    }

    public Date getTimestamp() {
        return this.timestamp;
    }

    public String getStatus() {
        return this.status;
    }

    public Object getMessage() {
        return this.message;
    }

    public T getContent() {
        return this.content;
    }

    public void setTimestamp(final Date timestamp) {
        this.timestamp = timestamp;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

    public void setMessage(final Object message) {
        this.message = message;
    }

    public void setContent(final T content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "ResponseBean(timestamp=" + this.getTimestamp() + ", status=" + this.getStatus() + ", message=" + this.getMessage() + ", content=" + this.getContent() + ")";
    }
}

