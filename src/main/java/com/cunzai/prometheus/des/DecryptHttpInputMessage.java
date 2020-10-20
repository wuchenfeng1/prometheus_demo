package com.cunzai.prometheus.des;

import com.alibaba.fastjson.JSONObject;
import com.cunzai.prometheus.utils.StringUtil;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpInputMessage;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * 请求参数解密
 * @author wuchenfeng
 */
public class DecryptHttpInputMessage implements HttpInputMessage {
	private HttpInputMessage inputMessage;
	private String charset;

	public DecryptHttpInputMessage(HttpInputMessage inputMessage, String charset) {
		this.inputMessage = inputMessage;
		this.charset = charset;
	}

	@Override
	public InputStream getBody() throws IOException {
		String requestParams= StringUtil.InputStreamTOString(inputMessage.getBody(),charset);
		JSONObject jsonObject= JSONObject.parseObject(requestParams);
		String encryptContent=jsonObject.getString("params");
		try {
			String decryptContent=Encryption.desEncrypt(encryptContent);
			return new ByteArrayInputStream(decryptContent.getBytes(charset));
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (InvalidAlgorithmParameterException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public HttpHeaders getHeaders() {
		return inputMessage.getHeaders();
	}
}
