package com.cunzai.prometheus.utils.emum;

/**
 * 发送消息的枚举
 * @author cunzai
 */
public enum SendWayEnum {
    /**
     * e-mail邮件
     */
    EMAIL_WAY("1", "emailServiceImpl"),

    /**
     * 钉钉
     */
    DINGTALK_WAY("2", "dingtalkServiceImpl"),
    /**
     * 短信
     */
    SHORT_WAY("3", "smsServiceImpl");

    private String code;
    private String serviceImpl;

    SendWayEnum(String code, String serviceImpl) {
        this.code = code;
        this.serviceImpl = serviceImpl;
    }

    public String getCode() {
        return code;
    }

    public String getServiceImpl() {
        return serviceImpl;
    }

    public static String getServiceImplByCode(String code){
        for (SendWayEnum enums : SendWayEnum.values()) {
            if (code.equals(enums.getCode())) {
                return enums.getServiceImpl();
            }
        }
        return "";
    }
}
