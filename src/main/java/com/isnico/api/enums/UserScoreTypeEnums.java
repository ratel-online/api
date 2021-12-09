package com.isnico.api.enums;

import lombok.Getter;

/**
 * Created by Eagga_Lo on 2021/12/8 15:50
 *
 * @author Eagga_Lo
 */
@Getter
public enum UserScoreTypeEnums {

    /**
     * 积分流水类型
     */
    LANDLORD(1, "斗地主");

    private final int value;
    private final String desc;

    UserScoreTypeEnums(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }
}
