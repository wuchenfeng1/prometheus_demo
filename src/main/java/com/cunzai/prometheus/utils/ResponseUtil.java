package com.cunzai.prometheus.utils;

/**
 * @version 1.0
 * @author: wuchenfeng
 * 日期  15:32
 * @since 1.0
 */

import org.springframework.validation.FieldError;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 接口正常请求的全部是success
 * 定义error失败
 */
public class ResponseUtil {
    private static final String TOTAL = "total";
    private static final String DATA = "data";
    private static final String SUCCESS = "success";
    private static final String ERROR = "error";
    private static final String ITEM = "item";
    private static final String MESSAGE = "message";

    private ResponseUtil() {
    }

    public static ResponseBean success(Object object, Object total, String msg) {
        Map<String, Object> map = new LinkedHashMap();
        map.put(TOTAL, total);
        map.put(DATA, object);
        return new ResponseBean(SUCCESS, msg, map);
    }

    public static ResponseBean success(Object object, String msg) {
        Map<String, Object> map = new LinkedHashMap();
        map.put(DATA, object);
        return new ResponseBean(SUCCESS, msg, map);
    }

    public static ResponseBean success(Object object) {
        ResponseBean result = new ResponseBean();
        result.setStatus(SUCCESS);
        result.setMessage("成功");
        result.setContent(object);
        result.setTimestamp(new Date());
        return result;
    }

    public static ResponseBean success() {
        return success((Object)null, (Object)null, "");
    }

    public static ResponseBean error(String item, String msg) {
        List<Map> errList = new ArrayList();
        ResponseBean result = new ResponseBean();
        Map<String, Object> map = new LinkedHashMap();
        map.put(ITEM, item);
        map.put(MESSAGE, msg);
        errList.add(map);
        result.setMessage(errList);
        result.setStatus(ERROR);
        return result;
    }

    public static ResponseBean error(String msg) {
        ResponseBean result = new ResponseBean();
        List<Map> errList = new ArrayList();
        Map<String, Object> map = new LinkedHashMap();
        map.put(ITEM, (Object)null);
        map.put(MESSAGE, msg);
        errList.add(map);
        result.setMessage(errList);
        result.setStatus(ERROR);
        result.setTimestamp(new Date());
        return result;
    }

    public static ResponseBean error(List<FieldError> list) {
        ResponseBean result = new ResponseBean();
        List<Map> errList = new ArrayList();
        result.setStatus(ERROR);
        Iterator var3 = list.iterator();

        while(var3.hasNext()) {
            FieldError err = (FieldError)var3.next();
            Map<String, Object> map = new LinkedHashMap();
            map.put(ITEM, err.getField());
            map.put(MESSAGE, err.getDefaultMessage());
            errList.add(map);
        }

        result.setMessage(errList);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        simpleDateFormat.format(new Date());
        result.setTimestamp(new Date());
        return result;
    }





}

