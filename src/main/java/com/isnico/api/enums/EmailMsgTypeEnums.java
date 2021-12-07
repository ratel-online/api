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
    REGISTERED("REGISTERED", "注册",1),
    FORGET_PASSWORD("FORGET_PASSWORD", "忘记密码",2);

    private final String code;
    private final String desc;
    private final int no;

    EmailMsgTypeEnums(String code, String desc,int no) {
        this.code = code;
        this.desc = desc;
        this.no = no;
    }


}
