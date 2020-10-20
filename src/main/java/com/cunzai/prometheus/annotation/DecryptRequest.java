package com.cunzai.prometheus.annotation;


import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 请求解密注解,用于请求参数解密
 *
 * <p>加了此注解的接口(true)将进行数据解密操作
 *    可以放在类上，可以放在方法上 </p>
 * @author wuchenfeng
 */
@Target({ElementType.METHOD , ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DecryptRequest {
    /**
     * 是否对body进行解密
     */
    boolean value() default true;

}
