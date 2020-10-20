package com.cunzai.prometheus.utils;

import com.alibaba.fastjson.JSONObject;
import okhttp3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


/**
 * 通用http发送方法
 *
 * @author ruoyi
 */
@Component
public class HttpUtils {
    private static final Logger log = LoggerFactory.getLogger(HttpUtils.class);
    /**
     * 向指定 URL 发送POST方法的请求
     * @param url
     * @param param
     * @return
     */
    public Boolean sendPost(String url,String param){
        OkHttpClient httpClient = new OkHttpClient().newBuilder()
                .connectTimeout(20, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.MINUTES).build();
        MediaType json = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(json, param);
        Request req = new Request.Builder().post(body).url(url).build();
        Response res;
        try {
            res = httpClient.newCall(req).execute();
            if(res.code()==200){
                String result = res.body().string();
                JSONObject jsonObject = JSONObject.parseObject(result);
                String errcode = jsonObject.getString("errcode");
               if("0".equals(errcode)){
                   log.info("发送Post接口成功 返回值是：{}",result);
                   return true;
               }
            }
            log.info("发送Post接口失败{},状态吗：{}",res.body(),res.code());
        } catch (IOException e) {
            log.info("发送Post接口异常：{}",e.getMessage());
        } catch (NullPointerException e){
            log.info("发送Post接口异常：{}",e.getMessage());
        }
        return false;
    }

    /**
     * 向指定 URL 发送POST方法的请求
     * @param url
     * @param param
     * @return
     */
    public String sendPostResult(String url,String param){
        OkHttpClient httpClient = new OkHttpClient().newBuilder()
                .connectTimeout(20, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.MINUTES).build();
        MediaType json = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(json, param);
        Request req = new Request.Builder().post(body).url(url).build();
        Response res;
        String result = null;
        try {
            res = httpClient.newCall(req).execute();
             result = res.body().string();
            log.info("发送Post接口失败,状态吗：{}",res.code());
        } catch (IOException e) {
            log.info("发送Post接口异常：{}",e.getMessage());
        } catch (NullPointerException e){
            log.info("发送Post接口异常：{}",e.getMessage());
        }
        return result;
    }



    /**
     * 向指定 URL 发送POST方法的请求
     * @param url
     * @return
     */
    public Boolean sendPost(String url){
        OkHttpClient httpClient = new OkHttpClient().newBuilder()
                .connectTimeout(20, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.MINUTES).build();
        MediaType json = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(json, "");
        Request req = new Request.Builder().post(body).url(url).build();
        Response res;
        try {
            res = httpClient.newCall(req).execute();
            if(res.code()==200){
                String result = res.body().string();
                log.info("发送Post接口成功 返回值是：{}",result);
                return true;
            }
            log.info("发送Post接口失败,状态吗：{}",res.code());
        } catch (IOException e) {
            log.info("发送Post接口异常：{}",e.getMessage());
        } catch (NullPointerException e){
            log.info("发送Post接口异常：{}",e.getMessage());
        }
        return false;
    }
}
