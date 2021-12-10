package com.isnico.api.enums;

/**
 * 队伍组枚举
 */
public enum GameGroupEnums {
    /**
     * 1, 2v2v2
     */
    g_2V2V2(1,"2v2v2");
    ;

    private final int value;
    private final String desc;

    GameGroupEnums(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public int getValue() {
        return value;
    }

    public String getDesc() {
        return desc;
    }
}
