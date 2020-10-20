package com.cunzai.prometheus.des;


import com.cunzai.prometheus.annotation.DecryptRequest;
import org.springframework.core.MethodParameter;

/**
 * 判断是否需要请求解密和响应加密
 * @author wuchenfeng
 */
public class NeedDes {
	public NeedDes() {
	}
	/**
	 * 是否需要参数解密
	 * 1.类上标注或者方法上标注,并且都为true
	 * 2.有一个标注为false就不需要解密
	 */
	static boolean needDecrypt(MethodParameter parameter) {
		boolean encrypt = false;
		boolean classPresentAnno  = parameter.getContainingClass().isAnnotationPresent(DecryptRequest.class);
		boolean methodPresentAnno = parameter.getMethod().isAnnotationPresent(DecryptRequest.class);

		if(classPresentAnno){
			//类上标注的是否需要解密
			encrypt = parameter.getContainingClass().getAnnotation(DecryptRequest.class).value();
			//类不加密，所有都不加密
			if(!encrypt){
				return false;
			}
		}
		if(methodPresentAnno){
			//方法上标注的是否需要解密
			encrypt = parameter.getMethod().getAnnotation(DecryptRequest.class).value();
		}
		return encrypt;
	}
}
