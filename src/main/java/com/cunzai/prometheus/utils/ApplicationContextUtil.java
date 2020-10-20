package com.cunzai.prometheus.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author: wuchenfeng
 * 日期 2020/9/11 9:53
 */
@Component
public class ApplicationContextUtil implements ApplicationContextAware {
    private static ApplicationContext app;

    public ApplicationContextUtil() {
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        setContext(applicationContext);
    }

    public static void setContext(ApplicationContext applicationContext) {
        if (app == null) {
            app = applicationContext;
        }

    }

    public static ApplicationContext getApplicationContext() {
        return app;
    }

    public static Object getBean(String name) {
        return getApplicationContext().getBean(name);
    }

    public static <T> T getBean(Class<T> clazz) {
        return getApplicationContext().getBean(clazz);
    }

    public static <T> T getBean(String name, Class<T> clazz) {
        return getApplicationContext().getBean(name, clazz);
    }
}
