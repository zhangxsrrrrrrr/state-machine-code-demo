package com.zx.machine;

public enum ActionEnum {
    error(0),
    medicine(1),
    monster(2),
    move(3),
    rise(4),
    finish(5)
    ;

    private final int value;
    ActionEnum(int i) {
        this.value = i;
    }

    public int getValue() {
        return value;
    }

    public static ActionEnum getActionEnum(int value) {
        for (ActionEnum actionEnum : ActionEnum.values()) {
            if (actionEnum.getValue() == value) {
                return actionEnum;
            }
        }
        return error;
    }
}
