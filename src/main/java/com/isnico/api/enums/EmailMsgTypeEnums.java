package com.isnico.api.enums;

import lombok.Getter;

/**
 * Created by Eagga_Lo on 2021/12/7 17:32
 *
 * @author Eagga_Lo
 */
@Getter
public enum EmailMsgTypeEnums {

    /**
     * 发送邮件枚举
     */
    REGISTERED("REGISTERED", "注册","Registered"),
    FORGET_PASSWORD("FORGET_PASSWORD", "忘记密码","Reset Password"),
    MODIFY_PASSWORD("MODIFY_PASSWORD", "修改密码","Modify Password");

    private final String code;
    private final String desc;
    private final String text;

    EmailMsgTypeEnums(String code, String desc,String text) {
        this.code = code;
        this.desc = desc;
        this.text = text;
    }


}
