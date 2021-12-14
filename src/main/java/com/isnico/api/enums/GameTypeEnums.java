package com.isnico.api.enums;

public enum GameTypeEnums {
    /**
     * 1, 斗地主经典模式
     */
    LANDLORD_CLASSIC_MODE(1,"斗地主经典模式")
;
    private final int value;
    private final String desc;

    GameTypeEnums(int value, String desc) {
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
