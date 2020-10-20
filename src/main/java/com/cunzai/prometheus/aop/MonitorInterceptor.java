package com.cunzai.prometheus.aop;


import com.cunzai.prometheus.utils.MetricsUtils;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;


/**
 * @author wuchenfeng
 */
@Component
public class MonitorInterceptor implements MethodInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(MonitorInterceptor.class);
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        String className = invocation.getThis().getClass().getName();
        String methodName = invocation.getMethod().getName();
        logger.info("类:{}.方法:{}未拦截", className, methodName);
        Object result   = invocation.proceed();
        try {
            StopWatch clock = new StopWatch();
            clock.start(); // 计时开始
            result = invocation.proceed();
            logger.info("拦截类: {}.方法:{}，返回结果:{}", invocation.getThis().getClass().getSimpleName(), className,result);
            clock.stop(); // 计时结束
            // 返回值的内容
            MetricsUtils.returnVal("cz_return_val_total",result.toString());
            //超时时间
            if (clock.getLastTaskTimeMillis()>60){
                MetricsUtils.timeOut("zc_time_out_total", String.valueOf(60));
            }
            logger.info("拦截类:{}.方法:{}，时长:{}毫秒", invocation.getThis().getClass().getSimpleName(), className,clock.getLastTaskTimeMillis());
        } catch (Throwable e) {
            MetricsUtils.exceptionMessage("zc_error_total",e.getMessage());
        }
        return result;
    }

}
