package com.isnico.api.consts;

public interface AppConst {

    // mail 验证码长度
    int MAIL_AUTH_CODE_LENGTH = 5;

    int TRUE = 1;
    int FALSE = 2;

    //用户token缓存key
    String USER_TOKEN = "ratel:user:token@";

    //邮箱认证缓存key
    String USER_REGISTER_AUTH_CODE = "ratel:user:register:auth:code@";

    // 正则
    String REGEX_EMAIL = "^\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z0-9]+$";
    String REGEX_PWD = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,15}$";
    String REGEX_NAME = "^[\\u4e00-\\u9fa5_a-zA-Z0-9]+$";
}
